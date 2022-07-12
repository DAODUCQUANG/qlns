package com.company.qlns.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "QLNS_PHAN_CONG")
@Entity(name = "qlns_PhanCong")
public class PhanCong extends StandardEntity {
    private static final long serialVersionUID = -9104373755323916013L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNG_VIEN_ID")
    private UngVien ungVien;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHUYEN_NGANH_ID")
    private ChuyenNganh chuyenNganh;

    public ChuyenNganh getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(ChuyenNganh chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public UngVien getUngVien() {
        return ungVien;
    }

    public void setUngVien(UngVien ungVien) {
        this.ungVien = ungVien;
    }
}