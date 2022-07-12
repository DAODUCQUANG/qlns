package com.company.qlns.service.cauhoi;

import com.company.qlns.entity.CauHoi;

import java.util.List;
import java.util.UUID;

public interface CauHoiService {
    String NAME = "qlns_CauHoiService";
    List<CauHoi> getListCauHoi(UUID idChuyenNganh);
    String getDapAnDung(UUID idCauHoi);
}