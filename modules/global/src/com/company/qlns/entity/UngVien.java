package com.company.qlns.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

@Table(name = "QLNS_UNG_VIEN")
@Entity(name = "qlns_UngVien")
@NamePattern("%s %s|tenUngVien,email")
public class UngVien extends StandardEntity {
    private static final long serialVersionUID = -731808033551351957L;

    @Column(name = "TEN_UNGVIEN", nullable = false)
    private String tenUngVien;

    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SDT", nullable = false)
    private String soDienThoai;

    @Column(name = "DIACHI", nullable = false)
    private String diaChi;

    @Column(name = "MOTA")
    private String moTa;

    @Column(name = "TONG_SO_CAU_HOI")
    @Positive
    private Integer tongSoCauHoi;

    @Column(name = "TONG_SO_CAU_TRA_LOI_DUOC")
    @Positive
    private Integer tongSoCauTraLoiDuoc;

    @Column(name = "TONG_SO_CAU_TRA_LOI_DUNG")
    private Integer tongSoCauTraLoiDung;

    @Column(name = "KET_QUA_PHE_DUYET")
    private Boolean ketQuaPheDuyet;

    @Column(name = "SO_DIEM_DAT_DUOC")
    private String soDiemDatDuoc;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "ungVien")
    private PhanCong phanCong;

    public String getSoDiemDatDuoc() {
        return soDiemDatDuoc;
    }

    public void setSoDiemDatDuoc(String soDiemDatDuoc) {
        this.soDiemDatDuoc = soDiemDatDuoc;
    }

    public Integer getTongSoCauTraLoiDung() {
        return tongSoCauTraLoiDung;
    }

    public void setTongSoCauTraLoiDung(Integer tongSoCauTraLoiDung) {
        this.tongSoCauTraLoiDung = tongSoCauTraLoiDung;
    }

    public Integer getTongSoCauTraLoiDuoc() {
        return tongSoCauTraLoiDuoc;
    }

    public void setTongSoCauTraLoiDuoc(Integer tongSoCauTraLoiDuoc) {
        this.tongSoCauTraLoiDuoc = tongSoCauTraLoiDuoc;
    }

    public Integer getTongSoCauHoi() {
        return tongSoCauHoi;
    }

    public void setTongSoCauHoi(Integer tongSoCauHoi) {
        this.tongSoCauHoi = tongSoCauHoi;
    }


    public String getTenUngVien() {
        return tenUngVien;
    }
    public void setTenUngVien(String tenUngVien) {
        this.tenUngVien = tenUngVien;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public PhanCong getPhanCong() {
        return phanCong;
    }

    public void setPhanCong(PhanCong phanCong) {
        this.phanCong = phanCong;
    }

    public Boolean getKetQuaPheDuyet() {
        return ketQuaPheDuyet;
    }

    public void setKetQuaPheDuyet(Boolean ketQuaPheDuyet) {
        this.ketQuaPheDuyet = ketQuaPheDuyet;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }


}