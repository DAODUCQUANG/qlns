package com.company.qlns.web.screens.dapan;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.DapAn;
import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

@UiController("qlns_DapAn.browse")
@UiDescriptor("dap-an-browse.xml")
@LookupComponent("dapAnsTable")
@LoadDataBeforeShow
public class DapAnBrowse extends StandardLookup<DapAn> {
    private UUID param = null;
    @Inject
    private CollectionLoader<DapAn> dapAnsDl;
    @Inject
    private ScreenBuilders screenBuilders;
    @Subscribe
    public void onInit(InitEvent event) {
        ScreenOptions screenOptions = event.getOptions();
        if(screenOptions instanceof MapScreenOptions) {
            Map<String,Object> pram = ((MapScreenOptions) screenOptions).getParams();
            param = (UUID) pram.get("dapAnId");
        }
        if(param != null) {
            String query = "select e from qlns_DapAn e where e.cauHoi.id = :id";
            dapAnsDl.setQuery(query);
            System.out.println("Chay o day");
            dapAnsDl.setParameter("id",param);
            dapAnsDl.load();
        }
    }
}