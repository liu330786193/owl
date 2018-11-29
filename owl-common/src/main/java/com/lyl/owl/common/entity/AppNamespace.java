package com.lyl.owl.common.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AppNamespace")
@SQLDelete(sql = "Update AppNamespace set isDeleted = 1 where id = ?")
@Where(clause = "isDeleted = 0")
public class AppNamespace {
}
