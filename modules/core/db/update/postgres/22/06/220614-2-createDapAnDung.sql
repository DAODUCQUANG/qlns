alter table QLNS_DAP_AN_DUNG add constraint FK_QLNS_DAP_AN_DUNG_ON_ID_DAPAN foreign key (ID_DAPAN) references QLNS_DAP_AN(ID);
create index IDX_QLNS_DAP_AN_DUNG_ON_ID_DAPAN on QLNS_DAP_AN_DUNG (ID_DAPAN);
