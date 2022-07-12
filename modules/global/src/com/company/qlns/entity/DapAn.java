package com.company.qlns.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "QLNS_DAP_AN")
@Entity(name = "qlns_DapAn")
@NamePattern("%s|tenDapAn")
public class DapAn extends StandardEntity {
    private static final long serialVersionUID = 8282175195007585344L;

    @Column(name = "TEN_DAPAN", nullable = false)
    private String tenDapAn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAU_HOI_ID")
    private CauHoi cauHoi;

    public CauHoi getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(CauHoi cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getTenDapAn() {
        return tenDapAn;
    }

    public void setTenDapAn(String tenDapAn) {
        this.tenDapAn = tenDapAn;
    }

}