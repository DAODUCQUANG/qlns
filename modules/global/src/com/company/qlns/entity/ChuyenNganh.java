package com.company.qlns.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "QLNS_CHUYEN_NGANH")
@Entity(name = "qlns_ChuyenNganh")
@NamePattern("%s|tenChuyenNganh")
public class ChuyenNganh extends StandardEntity {
    private static final long serialVersionUID = -9108754062675781573L;

    @NotNull
    @Column(name = "TEN_CHUYEN_NGANH", nullable = false)
    private String tenChuyenNganh;

    @NotNull
    @Column(name = "THOI_GIAN", nullable = false)
    private Integer thoiGian;

    @NotNull
    @Column(name = "DIEM_YEU_CAU", nullable = false)
    private Double diemYeuCau;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "chuyenNganh")
    private List<CauHoi> cauHoi;

    public Double getDiemYeuCau() {
        return diemYeuCau;
    }

    public void setDiemYeuCau(Double diemYeuCau) {
        this.diemYeuCau = diemYeuCau;
    }

    public Integer getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Integer thoiGian) {
        this.thoiGian = thoiGian;
    }

    public List<CauHoi> getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(List<CauHoi> cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getTenChuyenNganh() {
        return tenChuyenNganh;
    }

    public void setTenChuyenNganh(String tenChuyenNganh) {
        this.tenChuyenNganh = tenChuyenNganh;
    }
}