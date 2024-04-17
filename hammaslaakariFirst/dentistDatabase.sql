DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS tooth;
DROP TABLE IF EXISTS treatment;
DROP TABLE IF EXISTS messagedentist;

CREATE TABLE app_user 
(id BIGSERIAL PRIMARY KEY,
username VARCHAR(100) NOT NULL, 
passwordhash VARCHAR(100) NOT NULL,
userrole VARCHAR(100) NOT NULL
);

INSERT INTO app_user(username, passwordhash, userrole)
VALUES 
('user', '$2a$10$To60L.aku8gdDn8iNUE9bez7SF3QoDzgISLpAIXjCfamCbIsZG7ti', 'USER'),
('admin', '$2a$10$swT1C0pA70rGpfQjjT1EH.rHrSc62aPwMmhFHFwtiLNn7qvEhPhW6', 'ADMIN')
;

CREATE TABLE patient (
    patientid SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);


INSERT INTO patient(username)
VALUES
('Suvi Sammakkosuo'),
('Alma Martikkala'),
('Kalle Taxell'),
('Olivia Martikkala'),
('Mikko Kani')
;



CREATE TABLE treatment (
    treatmentid SERIAL PRIMARY KEY,
    patientid BIGINT REFERENCES patient(patientid)    
);

INSERT INTO treatment (patientid) 
VALUES
(2),
(3),
(5)
;

CREATE TABLE tooth (
    toothid SERIAL PRIMARY KEY,
    toothname VARCHAR(255) NOT NULL
);

INSERT INTO tooth(toothname)
VALUES
('rightUp1'),
('rightUp2'),
('rightUp3'),
('rightDown1'),
('rightDown2'),
('rightDown3'),
('leftUp1'),
('leftUp2'),
('leftUp3'),
('leftDown1'),
('leftDown2'),
('leftDown3')
;

CREATE TABLE tooth_treatment (
    id SERIAL PRIMARY KEY,
    toothid BIGINT REFERENCES tooth(toothid),
    treatmentid BIGINT REFERENCES treatment(treatmentid),
    treatmentinfo VARCHAR(255)
);

INSERT INTO tooth_treatment (toothid, treatmentid, treatmentinfo) 
VALUES 
(1, 2, 'Cavity on surfaces 1-4'),
(1, 1, 'Burned'),
(4, 3, 'Green, growing moss'),
(7, 3, 'Cavity on surfaces 1-4'),
(5, 3, 'Burned'),
(12, 2, 'Green, growing moss')
;


