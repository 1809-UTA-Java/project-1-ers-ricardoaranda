CREATE TABLE ERS_USERS (
    u_id number primary key,
    u_username varchar2(40),
    u_password varchar2(40),
    u_firstname varchar2(40),
    u_lastname varchar2(40),
    u_email varchar2(40),
    ur_id number
);

CREATE TABLE ERS_USER_ROLES (
    ur_id number primary key,
    ur_role varchar2(40)
);

CREATE TABLE ERS_REINBURSEMENTS (
    r_id number primary key,
    r_amount number,
    r_description varchar2(100), 
    r_receipt blob,
    r_submitted timestamp,
    r_resolved timestamp,
    u_id_author number,
    u_id_resolver number,
    rt_type number,
    rs_status number
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS (
    rs_id number,
    rs_status varchar2(30)
);

CREATE TABLE ERS_REINBURSEMENT_TYPE (
    rt_id number,
    rt_type varchar(30)
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
FOREIGN KEY (rt_type) REFERENCES ERS_REINBURSEMENT_TYPE (rt_type)
ON DELETE CASCADE;

ALTER TABLE ERS_REINBURSEMENTS ADD CONSTRAINT FKStatus
FOREIGN KEY (rs_status) REFERENCES ERS_REIMBURSEMENT_STATUS (rs_status)
ON DELETE CASCADE;