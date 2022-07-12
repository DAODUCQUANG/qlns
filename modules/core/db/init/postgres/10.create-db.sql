-- begin QLNS_CHUYEN_NGANH
create table QLNS_CHUYEN_NGANH (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEN_CHUYEN_NGANH varchar(255) not null,
    THOI_GIAN integer not null,
    DIEM_YEU_CAU double precision not null,
    --
    primary key (ID)
)^
-- end QLNS_CHUYEN_NGANH
-- begin QLNS_PHAN_CONG
create table QLNS_PHAN_CONG (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    UNG_VIEN_ID uuid,
    CHUYEN_NGANH_ID uuid,
    --
    primary key (ID)
)^
-- end QLNS_PHAN_CONG
-- begin QLNS_UNG_VIEN
create table QLNS_UNG_VIEN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEN_UNGVIEN varchar(255) not null,
    EMAIL varchar(255) not null,
    SDT varchar(255) not null,
    DIACHI varchar(255) not null,
    MOTA varchar(255),
    TONG_SO_CAU_HOI integer,
    TONG_SO_CAU_TRA_LOI_DUOC integer,
    TONG_SO_CAU_TRA_LOI_DUNG integer,
    KET_QUA_PHE_DUYET boolean,
    SO_DIEM_DAT_DUOC varchar(255),
    --
    primary key (ID)
)^
-- end QLNS_UNG_VIEN
-- begin QLNS_DAP_AN
create table QLNS_DAP_AN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEN_DAPAN varchar(255) not null,
    CAU_HOI_ID uuid not null,
    --
    primary key (ID)
)^
-- end QLNS_DAP_AN
-- begin QLNS_CAU_HOI
create table QLNS_CAU_HOI (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEN_CAU_HOI varchar(255) not null,
    DAP_AN_DUNG uuid,
    CHUYEN_NGANH_ID uuid not null,
    --
    primary key (ID)
)^
-- end QLNS_CAU_HOI
-- begin QLNS_LUONG
create table QLNS_LUONG (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LUONG_HIENTAI varchar(255) not null,
    LUONG_DEXUAT varchar(255) not null,
    --
    primary key (ID)
)^
-- end QLNS_LUONG
