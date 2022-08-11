package com.company.qlns.web.screens.phancong;


import com.company.qlns.entity.ChuyenNganh;
import com.company.qlns.entity.UngVien;
import com.company.qlns.service.phancong.PhanCongService;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.NotificationFacet;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.PhanCong;

import javax.inject.Inject;

@UiController("qlns_PhanCong.edit")
@UiDescriptor("phan-cong-edit.xml")
@EditedEntityContainer("phanCongDc")
@LoadDataBeforeShow
public class PhanCongEdit extends StandardEditor<PhanCong> {
    private boolean checkSuKien = false;
    @Inject
    private PickerField<ChuyenNganh> chuyenNganhField;
    @Inject
    private PickerField<UngVien> ungVienField;
    @Inject
    private PhanCongService phanCongService;
    @Inject
    private NotificationFacet thongBaoPhanCongNotification;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        checkSuKien = PersistenceHelper.isNew(getEditedEntity());
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        UngVien ungVien = ungVienField.getValue();
        System.out.println(checkSuKien);
        if(checkSuKien) {
            if(phanCongService.checkUngVienDuocPhanCong(ungVien)) {
                thongBaoPhanCongNotification.show();
                event.preventCommit();
            }
        } else {
            if(phanCongService.checkUngVienDuocPhanCong(ungVien)) {
                if(!phanCongService.checkChuyenNganh(ungVien,chuyenNganhField.getValue())) {
                    thongBaoPhanCongNotification.show();
                    event.preventCommit();
                }
            }
        }
    }
}