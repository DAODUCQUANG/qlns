package com.company.qlns.web.screens.cauhoi;

import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.CauHoi;

@UiController("qlns_CauHoi.browse")
@UiDescriptor("cau-hoi-browse.xml")
@LookupComponent("cauHoisTable")
@LoadDataBeforeShow
public class CauHoiBrowse extends StandardLookup<CauHoi> {
}