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
    SDT integer not null,
    DIACHI varchar(255) not null,
    MOTA varchar(255) not null,
    KET_QUA_TEST_ID uuid,
    KETQUADANHGIA varchar(255) not null,
    KET_QUA_PHE_DUYET boolean,
    LUONG_ID uuid,
    --
    primary key (ID)
);