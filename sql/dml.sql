CREATE OR REPLACE TRIGGER TRINSERTUSER
BEFORE INSERT ON ERS_USERS
FOR EACH ROW
BEGIN
    SELECT (SYS_GUID())
    INTO :new.u_id
    FROM dual;
END;
/

INSERT INTO ERS_USERS (u_username, u_password, u_firstname, u_lastname, u_email, u_role)
VALUES ('caco', 'asdf', 'Ricardo', 'Aranda', 'email@gmail.com', 'employee');

--INSERT INTO ERS_USERS (u_username, u_password, u_firstname, u_lastname, u_email, u_role)
--VALUES ('manny', 'asdf', 'Jan', 'TheMan', 'janTheMan@gmail.com', 'manager');

COMMIT;