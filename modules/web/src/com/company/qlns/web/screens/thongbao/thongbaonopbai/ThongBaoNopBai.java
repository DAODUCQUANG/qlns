package com.company.qlns.web.screens.thongbao.thongbaonopbai;

import com.company.qlns.web.screens.baithiungvien.Baithiungvien;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.App;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@UiController("qlns_ThongBaoNopBai")
@UiDescriptor("thong-bao-nop-bai.xml")
public class ThongBaoNopBai extends Screen {
    @Inject
    private Label<String> tongSoCauHoiLabel;
    @Inject
    private Label<String> tongSoCauTraLoiDuocLabel;
    @Inject
    private Label<String> tongSoCauTraLoiDungLabel;
    @Inject
    private Label<String> soCauChuaTraLoiLabel;
    @Inject
    private Label<String> tongSoCauTraLoiSaiLabel;
    @Inject
    private ScreenBuilders screenBuilders;

    private int tongSoCauHoi;
    private int tongSoCauTraLoiDuoc;
    private int tongSoCauTraLoiSai;
    private int tongSoCauTraLoiDung;
    private int tongSoCauChuaTraLoi;

    @Subscribe
    public void onInit(InitEvent event) {
        ScreenOptions screenOptions = event.getOptions();
        if (screenOptions instanceof MapScreenOptions) {
            Map<String, Object> pram = ((MapScreenOptions) screenOptions).getParams();
            tongSoCauHoi = (Integer) pram.get("tongSoCauHoi");
            tongSoCauTraLoiDuoc = (Integer) pram.get("tongSoCauTraLoiDuoc");
            tongSoCauTraLoiDung = (Integer) pram.get("tongSoCauTraLoiDung");
            tongSoCauTraLoiSai = (Integer) pram.get("tongSoCauTraLoiSai");
            tongSoCauChuaTraLoi = (Integer) pram.get("tongSoCauChuaTraLoi");
        }
        tongSoCauHoiLabel.setValue("Tổng số câu hỏi: "+ tongSoCauHoi);
        tongSoCauTraLoiDuocLabel.setValue("Tổng số câu trả lời được : " + tongSoCauTraLoiDuoc);
        soCauChuaTraLoiLabel.setValue("Tổng số câu hỏi chưa trả lời: " + tongSoCauChuaTraLoi);
        tongSoCauTraLoiDungLabel.setValue("Tổng số câu hỏi trả lời đúng: " + tongSoCauTraLoiDung);
        tongSoCauTraLoiSaiLabel.setValue("Tổng số câu trả lời sai: " + tongSoCauTraLoiSai);
    }

    @Subscribe(target = Target.FRAME)
    public void onBeforeClose(Window.BeforeCloseEvent event) {
        App.getInstance().logout();
    }
}