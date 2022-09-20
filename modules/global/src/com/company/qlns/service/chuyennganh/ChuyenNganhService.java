package com.company.qlns.service.chuyennganh;

import com.company.qlns.entity.ChuyenNganh;

import java.util.List;
import java.util.UUID;

public interface ChuyenNganhService {
    String NAME = "qlns_ChuyenNganhService";
    UUID getIdChuyenNganh(String emails);
    List<String> getTenChuyenNganh();
    ChuyenNganh getChuyenNganh(UUID idChuyenNganh);
    ChuyenNganh getChuyenNganhByName(String nameChuyenNganh);
}