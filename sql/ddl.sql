CREATE TABLE ERS_USERS (
    u_id number primary key not null,
    u_username varchar2(40) unique not null,
    u_password varchar2(40) not null,
    u_firstname varchar2(40),
    u_lastname varchar2(40),
    u_email varchar2(40) unique,
    ur_id number
);

CREATE TABLE ERS_USER_ROLES (
    ur_id number primary key not null,
    ur_role varchar2(40)
);

CREATE TABLE ERS_REINBURSEMENTS (
    r_id number primary key not null,
    r_amount number not null,
    r_description varchar2(100), 
    r_receipt blob,
    r_submitted timestamp not null,
    r_resolved timestamp,
    u_id_author number not null,
    u_id_resolver number,
    rt_id number not null,
    rs_id number not null
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS (
    rs_id number primary key,
    rs_status varchar2(30) not null
);

CREATE TABLE ERS_REINBURSEMENT_TYPE (
    rt_id number primary key,
    rt_type varchar(30) not null
);

ALTER TABLE ERS_USERS ADD CONSTRAINT FKUserRoles
FOREIGN KEY (ur_id) REFERENCES ERS_USER_ROLES (ur_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REINBURSEMENTS ADD CONSTRAINT FKAuthorId
FOREIGN KEY (u_id_author) REFERENCES ERS_USERS (u_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REINBURSEMENTS ADD CONSTRAINT FKResolverId
FOREIGN KEY (u_id_resolver) REFERENCES ERS_USERS (u_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REINBURSEMENTS ADD CONSTRAINT FKType
FOREIGN KEY (rt_id) REFERENCES ERS_REINBURSEMENT_TYPE (rt_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REINBURSEMENTS ADD CONSTRAINT FKStatus
FOREIGN KEY (rs_id) REFERENCES ERS_REIMBURSEMENT_STATUS (rs_id)
ON DELETE CASCADE;