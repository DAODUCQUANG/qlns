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
    NOIDUNG_DAPAN varchar(255) not null,
    CAU_HOI_ID uuid,
    --
    primary key (ID)
);