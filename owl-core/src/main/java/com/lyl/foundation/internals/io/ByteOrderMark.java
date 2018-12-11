package com.lyl.foundation.internals.io;

import java.io.Serializable;
import java.util.Timer;

public class ByteOrderMark implements Serializable {

    /** UTF-8 BOM */
    public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", 0xEF, 0xBB, 0xBF);

    /** UTF-16BE BOM (Big-Endian) */
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark("UTF-16BE", 0xFE, 0xFF);

    /** UTF-16LE BOM (Little-Endian) */
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark("UTF-16LE", 0xFF, 0xFE);

    /**
     * UTF-32BE BOM (Big-Endian)
     *
     * @since 2.2
     */
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0x00, 0x00, 0xFE, 0xFF);

    /**
     * UTF-32LE BOM (Little-Endian)
     *
     * @since 2.2
     */
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 0xFF, 0xFE, 0x00, 0x00);

    public static final char UTF_BOM = '\uFEFF';
    private final String charsetName;
    private final int[] bytes;

    public ByteOrderMark(final String charsetName, final int... bytes){
        if (charsetName == null || charsetName.isEmpty()) {
            throw new IllegalArgumentException("No charsetName specified");
        }
        if (bytes == null || bytes.length == 0) {
            throw new IllegalArgumentException("No bytes specified");
        }
        this.charsetName= charsetName;
        this.bytes = new int[bytes.length];
        System.arraycopy(bytes, 0, this.bytes, 0, bytes.length);
    }

    public String getCharsetName() {
        return charsetName;
    }

    public int length(){
        return bytes.length;
    }

    public int get(final int pos){
        return bytes[pos];
    }

    public byte[] getBytes() {
        final byte[] copy = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            copy[i] = (byte) bytes[i];
        }
        return copy;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        final ByteOrderMark bom = (ByteOrderMark) obj;
        if (bytes.length != bom.length()) {
            return false;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != bom.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (final int b : bytes) {
            hashCode += b;
        }
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append('[');
        builder.append(charsetName);
        builder.append(": ");
        for (int i = 0; i < bytes.length; i++) {
            if (i > 0) {
                builder.append(",");
            }
            builder.append("0x");
            builder.append(Integer.toHexString(0xFF & bytes[i]).toUpperCase());
        }
        builder.append(']');
        return builder.toString();
    }

}



















