DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS tooth;
DROP TABLE IF EXISTS treatment;

CREATE TABLE app_user 
(id BIGSERIAL PRIMARY KEY,
username VARCHAR(100) NOT NULL, 
passwordhash VARCHAR(100) NOT NULL,
userrole VARCHAR(100) NOT NULL
);

INSERT INTO app_user(username, passwordHash, userRole)
VALUES 
('user', '$2a$10$To60L.aku8gdDn8iNUE9bez7SF3QoDzgISLpAIXjCfamCbIsZG7ti', 'USER'),
('admin', '$2a$10$swT1C0pA70rGpfQjjT1EH.rHrSc62aPwMmhFHFwtiLNn7qvEhPhW6', 'ADMIN')
;

CREATE TABLE tooth 
(id BIGSERIAL PRIMARY KEY,
toothname VARCHAR(100) NOT NULL
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

CREATE TABLE patient 
(patientid BIGSERIAL PRIMARY KEY,
patientname VARCHAR(100) NOT NULL
);

INSERT INTO patient(patientname)
VALUES
('Suvi Sammakkosuo'),
('Alma Martikkala'),
('Kalle Taxell')
;

CREATE TABLE treatment 
(id BIGSERIAL PRIMARY KEY,
tooth BIGINT,
patient BIGINT,
toothinfo VARCHAR(1000),
FOREIGN KEY (tooth) REFERENCES tooth(id),
FOREIGN KEY (patient) REFERENCES patient(id)
);

CREATE TABLE message
(id BIGSERIAL PRIMARY KEY,
messagebody VARCHAR(1000)
);

INSERT INTO treatment (tooth, patient, toothinfo) 
VALUES 
(1, 1, 'Cavity on surfaces 1-4'),
(1, 2, 'Burned'),
(4, 1, 'Green, growing moss')
;
