-- begin QLNS_PHAN_CONG
alter table QLNS_PHAN_CONG add constraint FK_QLNS_PHAN_CONG_ON_UNG_VIEN foreign key (UNG_VIEN_ID) references QLNS_UNG_VIEN(ID)^
alter table QLNS_PHAN_CONG add constraint FK_QLNS_PHAN_CONG_ON_CHUYEN_NGANH foreign key (CHUYEN_NGANH_ID) references QLNS_CHUYEN_NGANH(ID)^
create index IDX_QLNS_PHAN_CONG_ON_UNG_VIEN on QLNS_PHAN_CONG (UNG_VIEN_ID)^
create index IDX_QLNS_PHAN_CONG_ON_CHUYEN_NGANH on QLNS_PHAN_CONG (CHUYEN_NGANH_ID)^
-- end QLNS_PHAN_CONG

-- begin QLNS_DAP_AN
alter table QLNS_DAP_AN add constraint FK_QLNS_DAP_AN_ON_CAU_HOI foreign key (CAU_HOI_ID) references QLNS_CAU_HOI(ID)^
create index IDX_QLNS_DAP_AN_ON_CAU_HOI on QLNS_DAP_AN (CAU_HOI_ID)^
-- end QLNS_DAP_AN
-- begin QLNS_CAU_HOI
alter table QLNS_CAU_HOI add constraint FK_QLNS_CAU_HOI_ON_DAP_AN_DUNG foreign key (DAP_AN_DUNG) references QLNS_DAP_AN(ID)^
alter table QLNS_CAU_HOI add constraint FK_QLNS_CAU_HOI_ON_CHUYEN_NGANH foreign key (CHUYEN_NGANH_ID) references QLNS_CHUYEN_NGANH(ID)^
create index IDX_QLNS_CAU_HOI_ON_DAP_AN_DUNG on QLNS_CAU_HOI (DAP_AN_DUNG)^
create index IDX_QLNS_CAU_HOI_ON_CHUYEN_NGANH on QLNS_CAU_HOI (CHUYEN_NGANH_ID)^
-- end QLNS_CAU_HOI
