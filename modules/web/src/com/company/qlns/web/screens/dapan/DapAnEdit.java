package com.company.qlns.web.screens.dapan;

import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.DapAn;

@UiController("qlns_DapAn.edit")
@UiDescriptor("dap-an-edit.xml")
@EditedEntityContainer("dapAnDc")
@LoadDataBeforeShow
public class DapAnEdit extends StandardEditor<DapAn> {
}