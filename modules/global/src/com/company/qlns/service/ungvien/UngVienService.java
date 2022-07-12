package com.company.qlns.service.ungvien;

import com.company.qlns.entity.UngVien;

import java.util.List;
import java.util.UUID;

public interface UngVienService {
    String NAME = "qlns_UngVienService";

    void setDiemUngVien(int tongSoCauHoi, int soCauTraLoiDung, int tongSoCauTraLoiDuoc,float diemUngVien,Boolean ketQuaPheDuyet, String email);
    boolean checkEmailUngVien(String email);
    boolean checkUngVien(UUID idUngVien);
    String getNameUngVien(String email);
    UngVien getUngVien(UUID uuid);
}