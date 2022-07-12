package com.company.qlns.service.dapan;

import java.util.List;
import java.util.UUID;

public interface DapAnService {
    String NAME = "qlns_DapAnService";
    List<String> getDanhSachDapAn(UUID idCauHoi);
}