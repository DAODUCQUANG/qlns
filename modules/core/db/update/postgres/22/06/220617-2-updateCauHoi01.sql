alter table QLNS_CAU_HOI add constraint FK_QLNS_CAU_HOI_ON_DAP_AN_DUNG foreign key (DAP_AN_DUNG_ID) references QLNS_DAP_AN(ID);
create index IDX_QLNS_CAU_HOI_ON_DAP_AN_DUNG on QLNS_CAU_HOI (DAP_AN_DUNG_ID);
