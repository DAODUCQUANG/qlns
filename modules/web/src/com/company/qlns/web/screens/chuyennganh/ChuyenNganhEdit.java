package com.company.qlns.web.screens.chuyennganh;

import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.ChuyenNganh;

@UiController("qlns_ChuyenNganh.edit")
@UiDescriptor("chuyen-nganh-edit.xml")
@EditedEntityContainer("chuyenNganhDc")
@LoadDataBeforeShow
public class ChuyenNganhEdit extends StandardEditor<ChuyenNganh> {
}