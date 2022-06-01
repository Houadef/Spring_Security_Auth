create table manage_account_user (
ID serial Primary KEY,
USER_ID VARCHAR (32) UNIQUE NOT NULL,
USER_FIRST_NAME VARCHAR (64) NOT NULL,
USER_LAST_NAME VARCHAR (64) NOT NULL,
USER_USERNAME VARCHAR (64) UNIQUE NOT NULL,
USER_PASSWORD VARCHAR (64) NOT NULL,
USER_PHONE VARCHAR (64),
USER_PHOTO_URL varchar(512) ,
USER_EMAIL VARCHAR (255) UNIQUE NOT NULL,

DATE_CREATION DATE NOT NULL,
DATE_MODIFICATION DATE NOT NULL,
DATE_DELETION DATE,
LAST_VIEWED_DATE DATE,
CREATED_BY INT,
MIDIFIED_BY INT,
DELETED_BY INT,
VIEWED_BY INT,
IS_IN_TRASH BOOLEAN DEFAULT false NOT NULL,
IS_DELETED BOOLEAN DEFAULT false NOT NULL

);
