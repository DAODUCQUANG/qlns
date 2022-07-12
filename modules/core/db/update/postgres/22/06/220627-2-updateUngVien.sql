alter table QLNS_UNG_VIEN rename column sdt to sdt__u08780 ;
alter table QLNS_UNG_VIEN alter column sdt__u08780 drop not null ;
alter table QLNS_UNG_VIEN add column SDT varchar(255) ^
update QLNS_UNG_VIEN set SDT = '' where SDT is null ;
alter table QLNS_UNG_VIEN alter column SDT set not null ;
