package com.company.qlns.web.screens.quanlycauhoi;

import com.company.qlns.service.chuyennganh.ChuyenNganhService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.CauHoi;
import com.haulmont.cuba.gui.screen.LookupComponent;

import javax.inject.Inject;

@UiController("qlns_QuanLyCauHoi.browse")
@UiDescriptor("quan-li-cau-hoi-browse.xml")
@LookupComponent("cauHoisTable")
@LoadDataBeforeShow
public class QuanLyCauHoiBrowse extends StandardLookup<CauHoi> {
    @Inject
    private LookupField tenChuyenNganhLookupField;
    @Inject
    private ChuyenNganhService chuyenNganhService;
    @Inject
    private CollectionLoader<CauHoi> cauHoisDl;

    @Subscribe
    public void onInit(InitEvent event) {
        tenChuyenNganhLookupField.setOptionsList(chuyenNganhService.getTenChuyenNganh());
        tenChuyenNganhLookupField.setNullOptionVisible(false);
    }

    @Subscribe("tenChuyenNganhLookupField")
    public void onTenChuyenNganhLookupFieldValueChange(HasValue.ValueChangeEvent event) {
        cauHoisDl.setQuery("select e from qlns_CauHoi e where e.chuyenNganh.tenChuyenNganh = :tenChuyenNganh");
        cauHoisDl.setParameter("tenChuyenNganh", tenChuyenNganhLookupField.getValue());
        cauHoisDl.load();
    }

    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {
    }

}