package com.lyl.foundation.internals.io;

import org.omg.CORBA.portable.InputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.lyl.foundation.internals.io.IOUtils.EOF;

public class BOMInputStream extends ProxyInputStream {

    private final boolean include;
    private final List<ByteOrderMark> boms;
    private ByteOrderMark byteOrderMark;
    private int[] firstBytes;
    private int fbLength;
    private int fbIndex;
    private int markFbIndex;
    private boolean markedAtStart;

    public BOMInputStream(InputStream delegate) {
        this(delegate, false, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(final java.io.InputStream delegate, final boolean include) {
        this(delegate, include, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(final java.io.InputStream delegate, final ByteOrderMark... boms) {
        this(delegate, false, boms);
    }

    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() {

        public int compare(final ByteOrderMark bom1, final ByteOrderMark bom2) {
            final int len1 = bom1.length();
            final int len2 = bom2.length();
            if (len1 > len2) {
                return EOF;
            }
            if (len2 > len1) {
                return 1;
            }
            return 0;
        }
    };

    public BOMInputStream(final java.io.InputStream delegate, final boolean include, final ByteOrderMark... boms) {
        super(delegate);
        if (boms == null || boms.length == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.include = include;
        // Sort the BOMs to match the longest BOM first because some BOMs have the same starting two bytes.
        Arrays.sort(boms, ByteOrderMarkLengthComparator);
        this.boms = Arrays.asList(boms);

    }

    public boolean hasBOM() throws IOException {
        return getBOM() != null;
    }

    public boolean hasBOM(final ByteOrderMark bom) throws IOException {
        if (!boms.contains(bom)) {
            throw new IllegalArgumentException("Stream not configure to detect " + bom);
        }
        return byteOrderMark != null && getBOM().equals(bom);
    }

    public ByteOrderMark getBOM() throws IOException {
        if (firstBytes == null) {
            fbLength = 0;
            // BOMs are sorted from longest to shortest
            final int maxBomSize = boms.get(0).length();
            firstBytes = new int[maxBomSize];
            // Read first maxBomSize bytes
            for (int i = 0; i < firstBytes.length; i++) {
                firstBytes[i] = in.read();
                fbLength++;
                if (firstBytes[i] < 0) {
                    break;
                }
            }
            // match BOM in firstBytes
            byteOrderMark = find();
            if (byteOrderMark != null) {
                if (!include) {
                    if (byteOrderMark.length() < firstBytes.length) {
                        fbIndex = byteOrderMark.length();
                    } else {
                        fbLength = 0;
                    }
                }
            }
        }
        return byteOrderMark;
    }

    public String getBOMCharsetName() throws IOException {
        getBOM();
        return byteOrderMark == null ? null : byteOrderMark.getCharsetName();
    }

    private int readFirstBytes() throws IOException {
        getBOM();
        return fbIndex < fbLength ? firstBytes[fbIndex++] : EOF;
    }

    private ByteOrderMark find() {
        for (final ByteOrderMark bom : boms) {
            if (matches(bom)) {
                return bom;
            }
        }
        return null;
    }

    private boolean matches(final ByteOrderMark bom) {
        // if (bom.length() != fbLength) {
        // return false;
        // }
        // firstBytes may be bigger than the BOM bytes
        for (int i = 0; i < bom.length(); i++) {
            if (bom.get(i) != firstBytes[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int read() throws IOException {
        final int b = readFirstBytes();
        return b >= 0 ? b : in.read();
    }

    @Override
    public int read(final byte[] buf, int off, int len) throws IOException {
        int firstCount = 0;
        int b = 0;
        while (len > 0 && b >= 0) {
            b = readFirstBytes();
            if (b >= 0) {
                buf[off++] = (byte) (b & 0xFF);
                len--;
                firstCount++;
            }
        }
        final int secondCount = in.read(buf, off, len);
        return secondCount < 0 ? firstCount > 0 ? firstCount : EOF : firstCount + secondCount;
    }

    @Override
    public int read(final byte[] buf) throws IOException {
        return read(buf, 0, buf.length);
    }

    @Override
    public synchronized void mark(final int readlimit) {
        markFbIndex = fbIndex;
        markedAtStart = firstBytes == null;
        in.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        fbIndex = markFbIndex;
        if (markedAtStart) {
            firstBytes = null;
        }

        in.reset();
    }

    @Override
    public long skip(long n) throws IOException {
        int skipped = 0;
        while ((n > skipped) && (readFirstBytes() >= 0)) {
            skipped++;
        }
        return in.skip(n - skipped) + skipped;
    }

}
