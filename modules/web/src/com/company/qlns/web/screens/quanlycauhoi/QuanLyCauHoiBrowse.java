package com.company.qlns.web.screens.quanlycauhoi;

import com.company.qlns.service.chuyennganh.ChuyenNganhService;
import com.company.qlns.web.screens.cauhoi.CauHoiEdit;
import com.company.qlns.web.screens.thongbao.thongbaonopbai.ThongBaoNopBai;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.CauHoi;
import com.haulmont.cuba.gui.screen.LookupComponent;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

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
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Metadata metadata;
    @Inject
    private Button createCauHoi;
    @Inject
    private Table<CauHoi> table;
    @Inject
    private Notifications notifications;
    @Inject
    private NotificationFacet notification_2;
    //    @Inject
//    private ScreenBuilders screenBuilders;

    @Subscribe
    public void onInit(InitEvent event) {
        tenChuyenNganhLookupField.setOptionsList(chuyenNganhService.getTenChuyenNganh());
        tenChuyenNganhLookupField.setNullOptionVisible(false);

//        table.setItemClickAction(new BaseAction("whatever") {
//            @Override
//            public void actionPerform(Component component) {
//                notification_2(ordersTable.getSingleSelected() + " clicked");
//            }
//        });
    }
    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        if (tenChuyenNganhLookupField.getValue()==null) {
            System.out.println("chay vao day");
            createCauHoi.setEnabled(false);
        }
    }

    @Subscribe("tenChuyenNganhLookupField")
    public void onTenChuyenNganhLookupFieldValueChange(HasValue.ValueChangeEvent event) {
        createCauHoi.setEnabled(true);
        cauHoisDl.setQuery("select e from qlns_CauHoi e where e.chuyenNganh.tenChuyenNganh = :tenChuyenNganh");
        cauHoisDl.setParameter("tenChuyenNganh", tenChuyenNganhLookupField.getValue());
        cauHoisDl.load();
    }

    @Subscribe("createCauHoi")
    public void onCreateCauHoiClick1(Button.ClickEvent event) {
        CauHoi cauHoi = metadata.create(CauHoi.class);
        cauHoi.setChuyenNganh(chuyenNganhService.getChuyenNganhByName(tenChuyenNganhLookupField.getValue().toString()));
        screenBuilders.editor(CauHoi.class, this).newEntity(cauHoi).withScreenClass(CauHoiEdit.class)
                .withOpenMode(OpenMode.NEW_TAB)
                .build()
                .show();
        //neu truong hop la edit screenBuilders.editor(CauHoi.class, this).editEntity
    }
//    @Subscribe("table.tenCauHoi")
//    public void onOrdersTableNameClick(Table.Column.ClickEvent<CauHoi> event) {
//        System.out.println("Cau hoi: " + event.getItem().getTenCauHoi());
//    }
//    @Subscribe("table")
//    protected void onCustomersTableSelection(Table.SelectionEvent<CauHoi> event) {
//        notifications.create()
//                .withCaption("You selected " + event.getSelected().toArray()[0]+ " customers")
//                .show();
//    }
}