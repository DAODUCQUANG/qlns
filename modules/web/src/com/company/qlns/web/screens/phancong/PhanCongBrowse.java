package com.company.qlns.web.screens.phancong;

import com.company.qlns.service.cauhoi.CauHoiService;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.PhanCong;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@UiController("qlns_PhanCong.browse")
@UiDescriptor("phan-cong-browse.xml")
@LookupComponent("phanCongsTable")
@LoadDataBeforeShow
public class PhanCongBrowse extends StandardLookup<PhanCong> {
}