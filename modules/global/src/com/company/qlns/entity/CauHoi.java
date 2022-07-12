package com.company.qlns.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "QLNS_CAU_HOI")
@Entity(name = "qlns_CauHoi")
@NamePattern("%s|tenCauHoi")
public class CauHoi extends StandardEntity {
    private static final long serialVersionUID = -8429150873328512303L;

    @Column(name = "TEN_CAU_HOI", nullable = false)
    @NotNull
    private String tenCauHoi;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "cauHoi")
    private List<DapAn> dapAn;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DAP_AN_DUNG")
    private DapAn dapAnDung;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CHUYEN_NGANH_ID")
    private ChuyenNganh chuyenNganh;

    public ChuyenNganh getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(ChuyenNganh chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public DapAn getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(DapAn dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public List<DapAn> getDapAn() {
        return dapAn;
    }

    public void setDapAn(List<DapAn> dapAn) {
        this.dapAn = dapAn;
    }

    public String getTenCauHoi() {
        return tenCauHoi;
    }
    public void setTenCauHoi(String tenCauHoi) {
        this.tenCauHoi = tenCauHoi;
    }
}