package com.company.qlns.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "QLNS_LUONG")
@Entity(name = "qlns_Luong")
public class Luong extends StandardEntity {
    private static final long serialVersionUID = -8025017989089501428L;

    @Column(name = "LUONG_HIENTAI", nullable = false)
    private String luongHienTai;
    @Column(name = "LUONG_DEXUAT", nullable = false)
    private String luongDeXuat;

    public String getLuongHienTai() {
        return luongHienTai;
    }

    public void setLuongHienTai(String luongHienTai) {
        this.luongHienTai = luongHienTai;
    }

    public String getLuongDeXuat() {
        return luongDeXuat;
    }

    public void setLuongDeXuat(String luongDeXuat) {
        this.luongDeXuat = luongDeXuat;
    }
}