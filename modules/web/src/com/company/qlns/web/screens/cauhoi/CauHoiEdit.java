package com.company.qlns.web.screens.cauhoi;

import com.company.qlns.entity.ChuyenNganh;
import com.company.qlns.entity.DapAn;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.CauHoi;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@UiController("qlns_CauHoi.edit")
@UiDescriptor("cau-hoi-edit.xml")
@EditedEntityContainer("cauHoiDc")
@LoadDataBeforeShow
public class CauHoiEdit extends StandardEditor<CauHoi> {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private PickerField<DapAn> dapAnDungField;

    @Subscribe("dapAnDungField.lookup")
    public void onDapAnDungFieldLookup(Action.ActionPerformedEvent event) {
        Map<String, Object> pram = new HashMap<>();
        pram.put("dapAnId", getEditedEntity().getId());
        MapScreenOptions mapScreenOptions = new MapScreenOptions(pram);
        screenBuilders.lookup(dapAnDungField)
                .withOptions(mapScreenOptions)
                .withOpenMode(OpenMode.NEW_TAB).build().show();
    }
}