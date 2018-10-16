CREATE TABLE ERS_USERS (
    u_id varchar2(40) primary key not null,
    u_username varchar2(40) unique not null,
    u_password varchar2(40) not null,
    u_firstname varchar2(40),
    u_lastname varchar2(40),
    u_email varchar2(40) unique,
    u_role varchar2(40)
);

CREATE TABLE ERS_REINBURSEMENTS (
    r_id varchar2(40) primary key not null,
    r_amount number not null,
    r_description varchar2(100), 
    r_receipt blob,
    r_submitted timestamp not null,
    r_resolved timestamp,
    r_type varchar(40) not null,
    r_status varchar(40) not null,
    u_id_author varchar2(40) not null,
    u_id_resolver varchar2(40)
);

ALTER TABLE ERS_REINBURSEMENTS ADD CONSTRAINT FKAuthorId
FOREIGN KEY (u_id_author) REFERENCES ERS_USERS (u_id)
ON DELETE CASCADE;

ALTER TABLE ERS_REINBURSEMENTS ADD CONSTRAINT FKResolverId
FOREIGN KEY (u_id_resolver) REFERENCES ERS_USERS (u_id)
ON DELETE CASCADE;