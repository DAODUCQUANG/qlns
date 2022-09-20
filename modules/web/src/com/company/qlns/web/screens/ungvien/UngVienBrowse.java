package com.company.qlns.web.screens.ungvien;

import com.company.qlns.service.user.UserService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.actions.list.ExcelAction;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.qlns.entity.UngVien;
import com.haulmont.cuba.gui.screen.LookupComponent;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vaadin.server.VaadinService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
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
    @Inject
    private UserService userService;
    @Inject
    private Button excelButton;
    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private CollectionContainer<UngVien> ungViensDc;

    @Subscribe
    public void onInit(InitEvent event) {
        List<String> list = new ArrayList<String>();
        list.add("Thí Sinh Đã Qua Bài Test");
        list.add("Thí Sinh Chưa Qua Bài Test");
        ketQuaPheDuyetLookupField.setOptionsList(list);
        excelButton.setAction(ungViensTableDowload);
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
    @Subscribe("createUser")
    public void onCreateUserClick(Button.ClickEvent event) throws IOException {
//        userService.createUser("quang","1234");
        VaadinService vaadinService = VaadinService.getCurrent();
        String absolutePath = vaadinService.getBaseDirectory().getAbsolutePath();
        try {
            String pathFile = absolutePath  + "\\VAADIN\\quangword.docx";
            File fileImport = new File(pathFile);
            byte[] bytes = Files.readAllBytes(fileImport.toPath());
            exportDisplay.show(new ByteArrayDataProvider(bytes), fileImport.getName(), ExportFormat.DOCX);
        } catch (IOException e) {
            System.out.println(e);
        }
        userService.sendEmail("kakaquang98@gmail.com","Thông báo hệ thống","Thông báo hệ thống của bạn là gì?");
    }

    @Subscribe("pdfBtn")
    public void onPdfBtnClick(Button.ClickEvent event) {
        List<UngVien> ungVienList = ungViensDc.getItems();
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        VaadinService vaadinService = VaadinService.getCurrent();
        String absolutePath = vaadinService.getBaseDirectory().getAbsolutePath();
        try {
            String pathFile = absolutePath  + "\\VAADIN\\ungvien.pdf";
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\kakaq\\StudioProjects\\qlns\\modules\\global\\src\\com\\company\\qlns\\resource\\quang.pdf"));
            document.open();
            BaseFont customfont = BaseFont.createFont("D:\\font-times-new-roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontNormal = new Font(customfont,12, Font.NORMAL);
            Paragraph pa = new Paragraph("Đoạn text cần truyền vào kkk", fontNormal);
            document.add(pa);
            PdfPTable t = new PdfPTable(10);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);
            BaseColor baseColor = new BaseColor(152, 158, 158);

            PdfPCell c1 = new PdfPCell(new Phrase("Tên ứng viên",fontNormal));
            c1.setBackgroundColor(baseColor);
            t.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Email",fontNormal));
            c2.setBackgroundColor(baseColor);
            t.addCell(c2);

            PdfPCell c3 = new PdfPCell(new Phrase("Số điện thoại",fontNormal));
            c3.setBackgroundColor(baseColor);
            t.addCell(c3);

            PdfPCell c4 = new PdfPCell(new Phrase("Địa chỉ",fontNormal));
            c4.setBackgroundColor(baseColor);
            t.addCell(c4);

            PdfPCell c5 = new PdfPCell(new Phrase("Mô tả",fontNormal));
            c5.setBackgroundColor(baseColor);
            t.addCell(c5);

            PdfPCell c6 = new PdfPCell(new Phrase("Số câu hỏi",fontNormal));
            c6.setBackgroundColor(baseColor);
            t.addCell(c6);

            PdfPCell c7 = new PdfPCell(new Phrase("Số câu trả lời được",fontNormal));
            c7.setBackgroundColor(baseColor);
            t.addCell(c7);

            PdfPCell c8 = new PdfPCell(new Phrase("Số câu trả lới đúng",fontNormal));
            c8.setBackgroundColor(baseColor);
            t.addCell(c8);

            PdfPCell c9 = new PdfPCell(new Phrase("Điểm đạt được",fontNormal));
            c9.setBackgroundColor(baseColor);
            t.addCell(c9);

            PdfPCell c10 = new PdfPCell(new Phrase("Kết quả phê duyệt",fontNormal));
            c10.setBackgroundColor(baseColor);
            t.addCell(c10);

            for(UngVien n : ungVienList) {
                t.addCell(n.getTenUngVien());
                t.addCell(n.getEmail());
                t.addCell(n.getSoDienThoai());
                t.addCell(n.getDiaChi());
                if(n.getMoTa()==null || n.getMoTa().isEmpty()) {
                    t.addCell("");
                } else {
                    t.addCell(n.getMoTa());
                }
                if(n.getTongSoCauHoi()==null) {
                    t.addCell("");
                } else {
                    t.addCell(String.valueOf(n.getTongSoCauHoi()));
                }
                if(n.getTongSoCauTraLoiDuoc()==null) {
                    t.addCell("");
                } else {
                    t.addCell(String.valueOf(n.getTongSoCauTraLoiDuoc()));
                }
                if(n.getTongSoCauTraLoiDung()==null) {
                    t.addCell("");
                } else {
                    t.addCell(String.valueOf(n.getTongSoCauTraLoiDung()));
                }
                if(n.getSoDiemDatDuoc()==null) {
                    t.addCell("");
                } else {
                    t.addCell(String.valueOf(n.getSoDiemDatDuoc()));
                }
                if(n.getKetQuaPheDuyet() == null || n.getKetQuaPheDuyet() == false) {
                    t.addCell("Đạt");
                } else {
                    t.addCell("Không đạt");
                }

            }
            document.add(t);
            document.close();
            System.out.println("Write file succes!");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
//    public Component taiVe(Entity entity) {
//        Button buttonTaiVe = uiComponents.create(Button.class);
//        buttonTaiVe.setId("taiVeButton");
//        buttonTaiVe.setCaption("Tải về");
//        buttonTaiVe.setAction(ungViensTableDowload);
//        buttonTaiVe.setStyleName("buttonExcel");
//        return buttonTaiVe;
//    }
//    @Subscribe("quangBtn")
//    public void onQuangBtnClick(Button.ClickEvent event) {
//        userService.cre   ateUser("quang","1");
//    }
}