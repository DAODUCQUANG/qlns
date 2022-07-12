package com.company.qlns.service.phancong;

import com.company.qlns.entity.ChuyenNganh;
import com.company.qlns.entity.UngVien;

public interface PhanCongService {
    String NAME = "qlns_PhanCongService";
    boolean checkUngVienDuocPhanCong(UngVien ungVien);
    boolean checkChuyenNganh(UngVien ungVien,ChuyenNganh chuyenNganh);
}