package com.company.qlns.web.screens.chuyennganh;

import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.ChuyenNganh;

@UiController("qlns_ChuyenNganh.browse")
@UiDescriptor("chuyen-nganh-browse.xml")
@LookupComponent("chuyenNganhsTable")
@LoadDataBeforeShow
public class ChuyenNganhBrowse extends StandardLookup<ChuyenNganh> {
}