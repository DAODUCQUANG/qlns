package com.company.qlns.web.screens.baithiungvien;

import com.company.qlns.service.cauhoi.CauHoiService;
import com.company.qlns.service.chuyennganh.ChuyenNganhService;
import com.company.qlns.service.dapan.DapAnService;
import com.company.qlns.service.ungvien.UngVienService;
import com.company.qlns.web.screens.thongbao.thongbaonopbai.ThongBaoNopBai;
import com.company.qlns.web.screens.thongbao.thongvaobaithi.ThongBaoQuyenVaoBaiThi;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.RadioButtonGroup;
import com.haulmont.cuba.gui.executors.BackgroundTask;
import com.haulmont.cuba.gui.executors.BackgroundTaskHandler;
import com.haulmont.cuba.gui.executors.BackgroundWorker;
import com.haulmont.cuba.gui.executors.TaskLifeCycle;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@UiController("qlns_Baithiungvien")
@UiDescriptor("baiThiUngVien.xml")
public class Baithiungvien extends Screen {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Label<String> tenCauHoiLabel;
    @Inject
    private Label<String> soCauDaTraLoiLabel;
    @Inject
    private RadioButtonGroup<String> dapAnRadio;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private ChuyenNganhService chuyenNganhService;
    @Inject
    private CauHoiService cauHoiService;
    @Inject
    private DapAnService dapAnService;
    @Inject
    private UngVienService ungVienService;
    @Inject
    private Button nextButton;
    @Inject
    private Label<String> thoiGianLamBaiLabel;
    @Inject
    private BackgroundWorker backgroundWorker;
    @Inject
    private Label<String> tenUngVien;
    @Inject
    private Label<String> chuyenNganh;
    private BackgroundTaskHandler taskHandler;
    int phut = 0;
    int giay = 0;
    int count = 0;
    int tongSoCauTraLoiDung = 0;
    int tongSoCauChuaTraLoi = 0;
    boolean ketQuaPheDuyet = false;

    @Subscribe
    public void onInit(InitEvent event) {
        if (userSessionSource.getUserSession().getRoles().toString().equals("[ungvien]")) {
            UUID idChuyenNganh = chuyenNganhService.getIdChuyenNganh(userSessionSource.getUserSession().getUser().getLogin());
            int thoiGian = chuyenNganhService.getChuyenNganh(idChuyenNganh).getThoiGian();
            phut = thoiGian / 60;
            giay = thoiGian % 60;
            thoiGianLamBaiLabel.setValue(phut + ":" + giay);
            tenCauHoiLabel.setValue(cauHoiService.getListCauHoi(idChuyenNganh).get(0).getTenCauHoi());
            UUID uuidCauHoi = cauHoiService.getListCauHoi(idChuyenNganh).get(0).getId();
            dapAnRadio.setOptionsList(dapAnService.getDanhSachDapAn(uuidCauHoi));
            soCauDaTraLoiLabel.setValue(count + "/" + cauHoiService.getListCauHoi(idChuyenNganh).size());
            tenUngVien.setValue("Tên ứng viên: " + ungVienService.getNameUngVien(userSessionSource.getUserSession().getUser().getLogin()));
            chuyenNganh.setValue("Chuyên ngành: "+ chuyenNganhService.getChuyenNganh(idChuyenNganh).getTenChuyenNganh());
            System.out.println("ROLE" + userSessionSource.getUserSession().getRoles());
            demNguoc(idChuyenNganh);
        }
    }

    @Subscribe("nextButton")
    public void onNextButtonClick(Button.ClickEvent event) {
        UUID idChuyenNganh = chuyenNganhService.getIdChuyenNganh(userSessionSource.getUserSession().getUser().getLogin());
        UUID uuidCauHoi = cauHoiService.getListCauHoi(idChuyenNganh).get(count).getId();
        if (dapAnRadio.getValue() != null && cauHoiService.getDapAnDung(uuidCauHoi).equals(dapAnRadio.getValue())) {
            tongSoCauTraLoiDung += 1;
        }
        if (dapAnRadio.getValue() == null) {
            tongSoCauChuaTraLoi += 1;
            System.out.println("Tổng số  câu chưa trả lời: " + tongSoCauChuaTraLoi);
        } else {
            dapAnRadio.setValue(null);
        }
        count += 1;
        System.out.println("COUNT:::::"+count);
        soCauDaTraLoiLabel.setValue(count + "/" + cauHoiService.getListCauHoi(idChuyenNganh).size());
        //Hien thi danh sach va cau hoi
        if (count < cauHoiService.getListCauHoi(idChuyenNganh).size()) {
            tenCauHoiLabel.setValue(cauHoiService.getListCauHoi(idChuyenNganh).get(count).getTenCauHoi());
            UUID uuidCauHoi1 = cauHoiService.getListCauHoi(idChuyenNganh).get(count).getId();
            dapAnRadio.setOptionsList(dapAnService.getDanhSachDapAn(uuidCauHoi1));
        }

        if (count == cauHoiService.getListCauHoi(idChuyenNganh).size() - 1) {
            nextButton.setVisible(false);
        }
        System.out.println("COUNT IN BTN NEXT:" + count);

    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        if (userSessionSource.getUserSession().getRoles().toString().equals("[ungvien]") == false) {
            screenBuilders.screen(this).withScreenClass(ThongBaoQuyenVaoBaiThi.class)
                    .withOpenMode(OpenMode.DIALOG)
                    .build()
                    .show();
        }
    }

    @Subscribe("submit")
    public void onSubmitClick(Button.ClickEvent event) {
        taskHandler.cancel();
        UUID idChuyenNganh = chuyenNganhService.getIdChuyenNganh(userSessionSource.getUserSession().getUser().getLogin());
        nopBaiVaHienThiKetQua(idChuyenNganh);
    }


    private void demNguoc(UUID idChuyenNganh) {
        BackgroundTask<Integer, Void> task = new BackgroundTask<Integer, Void>(chuyenNganhService.getChuyenNganh(idChuyenNganh).getThoiGian(), this) {
            @Override
            public Void run(TaskLifeCycle<Integer> taskLifeCycle) throws InterruptedException {
                Thread.sleep(1000);
                return null;
            }
            @Override
            public void done(Void result) {
                super.done(result);
                thoiGianLamBaiLabel.setValue(phut + ":" + giay);
                if (giay == 0) {
                    giay = 60;
                    phut--;
                }
                if (phut < 0) {
                    thoiGianLamBaiLabel.setValue(00 + ":" + 00);
                    phut = 0;
                    giay = 0;
                    nopBaiVaHienThiKetQua(idChuyenNganh);
                } else {
                    giay--;
                    demNguoc(idChuyenNganh);
                }
            }
        };
        taskHandler = backgroundWorker.handle(task);
        taskHandler.execute();
    }

    public void nopBaiVaHienThiKetQua(UUID idChuyenNganh) {
        int tongSoCauHoi = cauHoiService.getListCauHoi(idChuyenNganh).size();

        if (dapAnRadio.getValue() != null) {
            UUID uuidCauHoi = cauHoiService.getListCauHoi(idChuyenNganh).get(count).getId();
            count++;
            if (dapAnRadio.getValue() != null && cauHoiService.getDapAnDung(uuidCauHoi).equals(dapAnRadio.getValue())) {
                tongSoCauTraLoiDung += 1;
            }
        }
        if (count < tongSoCauHoi) {
            tongSoCauChuaTraLoi = tongSoCauHoi - count;
        }
        int tongSoCauTraLoiDuoc = tongSoCauHoi - tongSoCauChuaTraLoi;
        float diemUngVien = (float) tongSoCauTraLoiDung / tongSoCauHoi;
        if ((double)diemUngVien >= chuyenNganhService.getChuyenNganh(idChuyenNganh).getDiemYeuCau()) {
            ketQuaPheDuyet = true;
        }
        ungVienService.setDiemUngVien(tongSoCauHoi, tongSoCauTraLoiDung, tongSoCauTraLoiDuoc ,diemUngVien*10, ketQuaPheDuyet, userSessionSource.getUserSession().getUser().getLogin());
        //khoitaomanhinh hien thi ket qua
        Map<String, Object> mapKetQuaLamBai = new HashMap<>();
        MapScreenOptions mapScreenOptions = new MapScreenOptions(mapKetQuaLamBai);
        mapKetQuaLamBai.put("tongSoCauHoi", tongSoCauHoi);
        mapKetQuaLamBai.put("tongSoCauTraLoiDuoc", tongSoCauTraLoiDuoc);
        mapKetQuaLamBai.put("tongSoCauChuaTraLoi", tongSoCauChuaTraLoi);
        mapKetQuaLamBai.put("tongSoCauTraLoiDung", tongSoCauTraLoiDung);
        mapKetQuaLamBai.put("tongSoCauTraLoiSai", tongSoCauTraLoiDuoc - tongSoCauTraLoiDung);
        screenBuilders.screen(this).withScreenClass(ThongBaoNopBai.class)
                .withOptions(mapScreenOptions)
                .withOpenMode(OpenMode.DIALOG)
                .build()
                .show();
    }
}