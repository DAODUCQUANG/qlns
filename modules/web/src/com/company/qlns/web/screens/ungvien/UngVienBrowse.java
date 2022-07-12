package com.company.qlns.web.screens.ungvien;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.actions.list.ExcelAction;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.UngVien;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@UiController("qlns_UngVien.browse")
@UiDescriptor("ung-vien-browse.xml")
@LookupComponent("ungViensTable")
@LoadDataBeforeShow

public class UngVienBrowse extends StandardLookup<UngVien> {
    @Inject
    private UiComponents uiComponents;
    @Inject
    private LookupField ketQuaPheDuyetLookupField;
    @Inject
    private CollectionLoader<UngVien> ungViensDl;
    @Named("ungViensTable.dowload")
    private ExcelAction ungViensTableDowload;


    @Subscribe
    public void onInit(InitEvent event) {
        List<String> list = new ArrayList<String>();
        list.add("Thí Sinh Đã Qua Bài Test");
        list.add("Thí Sinh Chưa Qua Bài Test");
        ketQuaPheDuyetLookupField.setOptionsList(list);
    }

    @Subscribe("ketQuaPheDuyetLookupField")
    public void onKetQuaPheDuyetLookupFieldValueChange(HasValue.ValueChangeEvent event) {
        if(ketQuaPheDuyetLookupField.getValue().equals("Thí Sinh Đã Qua Bài Test")) {
            ungViensDl.setQuery("select e from qlns_UngVien e where e.ketQuaPheDuyet = true");
            ungViensDl.load();
        }
        if(ketQuaPheDuyetLookupField.getValue().equals("Thí Sinh Chưa Qua Bài Test")) {
            ungViensDl.setQuery("select e from qlns_UngVien e where e.ketQuaPheDuyet is null or e.ketQuaPheDuyet = false");
            ungViensDl.load();
        }
    }

    public Component taiVe(Entity entity) {
        Button buttonTaiVe = uiComponents.create(Button.class);
        buttonTaiVe.setId("taiVeButton");
        buttonTaiVe.setCaption("Tải về");
        buttonTaiVe.setAction(ungViensTableDowload);
        buttonTaiVe.setStyleName("buttonExcel");
        return buttonTaiVe;
    }
}