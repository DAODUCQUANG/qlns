package com.company.qlns.web.screens.ungvien;

import com.company.qlns.service.ungvien.UngVienService;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.NotificationFacet;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.UngVien;
import javax.inject.Inject;
import java.util.UUID;

@UiController("qlns_UngVien.edit")
@UiDescriptor("ung-vien-edit.xml")
@EditedEntityContainer("ungVienDc")
@LoadDataBeforeShow
public class UngVienEdit extends StandardEditor<UngVien> {
    @Inject
    private TextField<Integer> tongSoCauHoiField;
    @Inject
    private TextField<Integer> tongSoCauTraLoiDungField;
    @Inject
    private TextField<Integer> tongSoCauTraLoiDuocField;
    @Inject
    private TextField<String> emailField;
    @Inject
    private UngVienService ungVienService;
    @Inject
    private NotificationFacet thongBaoEmailNotification;
    private boolean checkSuKien = false;
    @Inject
    private TextField<String> diemUngVienField;
    @Inject
    private CheckBox ketQuaPheDuyetCheckBox;

    @Subscribe
    public void onInit(InitEvent event) {
        tongSoCauHoiField.setEnabled(false);
        tongSoCauTraLoiDungField.setEnabled(false);
        tongSoCauTraLoiDuocField.setEnabled(false);
        diemUngVienField.setEnabled(false);
        ketQuaPheDuyetCheckBox.setEditable(false);
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        checkSuKien = PersistenceHelper.isNew(getEditedEntity());
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        UUID idUngVien = getEditedEntity().getId();
        System.out.println("checkSuKien1:"+checkSuKien);
        if(checkSuKien){
            if (ungVienService.checkEmailUngVien(emailField.getValue())) {
                thongBaoEmailNotification.show();
                event.preventCommit();
            }
        } else {
            if(ungVienService.checkUngVien(idUngVien)) {
                if (!emailField.getValue().equals(ungVienService.getUngVien(idUngVien).getEmail()) && ungVienService.checkEmailUngVien(emailField.getValue())) {
                    thongBaoEmailNotification.show();
                    event.preventCommit();
                }
            }
        }
    }
}