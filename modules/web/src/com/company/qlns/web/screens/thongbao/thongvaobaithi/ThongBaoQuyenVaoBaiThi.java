package com.company.qlns.web.screens.thongbao.thongvaobaithi;

import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.App;

@UiController("qlns_ThongBaoQuyenVaoBaiThi")
@UiDescriptor("thong-bao-quyen-vao-bai-thi.xml")
public class ThongBaoQuyenVaoBaiThi extends Screen {
    @Subscribe(target = Target.FRAME)
    public void onBeforeClose(Window.BeforeCloseEvent event) {
        App.getInstance().logout();
    }

}