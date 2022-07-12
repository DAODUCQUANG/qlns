alter table QLNS_DAP_AN add constraint FK_QLNS_DAP_AN_ON_CAU_HOI foreign key (CAU_HOI_ID) references QLNS_CAU_HOI(ID);
create index IDX_QLNS_DAP_AN_ON_CAU_HOI on QLNS_DAP_AN (CAU_HOI_ID);
