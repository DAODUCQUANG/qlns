alter table QLNS_UNG_VIEN add constraint FK_QLNS_UNG_VIEN_ON_KET_QUA_TEST foreign key (KET_QUA_TEST_ID) references QLNS_KETQUATEST(ID);
alter table QLNS_UNG_VIEN add constraint FK_QLNS_UNG_VIEN_ON_LUONG foreign key (LUONG_ID) references QLNS_LUONG(ID);
create index IDX_QLNS_UNG_VIEN_ON_KET_QUA_TEST on QLNS_UNG_VIEN (KET_QUA_TEST_ID);
create index IDX_QLNS_UNG_VIEN_ON_LUONG on QLNS_UNG_VIEN (LUONG_ID);
