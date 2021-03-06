alter table QLNS_PHAN_CONG add constraint FK_QLNS_PHAN_CONG_ON_UNG_VIEN foreign key (UNG_VIEN_ID) references QLNS_UNG_VIEN(ID);
alter table QLNS_PHAN_CONG add constraint FK_QLNS_PHAN_CONG_ON_CHUYEN_NGANH foreign key (CHUYEN_NGANH_ID) references QLNS_CHUYEN_NGANH(ID);
create index IDX_QLNS_PHAN_CONG_ON_UNG_VIEN on QLNS_PHAN_CONG (UNG_VIEN_ID);
create index IDX_QLNS_PHAN_CONG_ON_CHUYEN_NGANH on QLNS_PHAN_CONG (CHUYEN_NGANH_ID);
