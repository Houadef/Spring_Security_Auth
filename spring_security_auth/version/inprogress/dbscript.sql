create table frm_manage_account_user (
PK_ID serial Primary KEY,
USER_ID VARCHAR (32) UNIQUE NOT NULL,
USER_FIRST_NAME VARCHAR (64) NOT NULL,
USER_LAST_NAME VARCHAR (64) NOT NULL,
USER_MIDLENAME VARCHAR (64),
USER_INITAL VARCHAR (64),
USER_USERNAME VARCHAR (64) UNIQUE NOT NULL,
USER_PASSWORD VARCHAR (64) NOT NULL,
USER_PHONE VARCHAR (64),
USER_PHOTO_URL varchar(512) ,
USER_EMAIL VARCHAR (255) UNIQUE NOT NULL,
IS_IN_TRASH BOOLEAN DEFAULT FALSE NOT NULL,
IS_DELETED BOOLEAN DEFAULT FALSE NOT NULL
);

create table log_manage_account_user_ (
ID serial Primary KEY,
FK_PK_ID VARCHAR (32) UNIQUE NOT NULL,
FK_ACTION_PK_ID VARCHAR NOT NULL,
CURRENT_VALUES VARCHAR,
NEW_VALUES VARCHAR,
DATE_LOG DATE NOT NULL,
FK_USER_PK_ID INT NOT NULL
);

CREATE SEQUENCE seq_manage_account_user_seq 
INCREMENT 5
START 10;

