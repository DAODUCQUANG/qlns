alter table QLNS_KETQUATEST add constraint FK_QLNS_KETQUATEST_ON_UNG_VIEN foreign key (UNG_VIEN_ID) references QLNS_UNG_VIEN(ID);
create index IDX_QLNS_KETQUATEST_ON_UNG_VIEN on QLNS_KETQUATEST (UNG_VIEN_ID);
