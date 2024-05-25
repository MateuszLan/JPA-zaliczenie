insert into address (id, address_line1, address_line2, city, postal_code)
            values  (1, 'xx', 'yy', 'city', '62-030'),
                    (2, 'Główna 123', 'Apt 2', 'Warszawa', '11-222'),
                    (3, 'Leśna',NULL, 'Kraków', '12-345'),
                    (4, 'Kolejowa 76', 'mieszkanie 1', 'Gdańsk', '23-456');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_entity_id)
VALUES (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', '1', 'Chirurgia',1),
(2, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', '2', 'Pediatria',1);

insert into patient (id, first_name, last_name, treatment_status, date_of_birth, telephone_number, email, patient_number, address_entity_id)
     VALUES (1, 'Adam', 'Nowak', true, '1990-05-15', '111222333', 'adam.nowak@example.com', 'PAC123', 1),
     (2, 'Ewa', 'Nowak', false, '1985-10-20', '444555666', 'ewa.nowak@example.com', 'PAC456', 1),
     (3, 'Mateusz', 'Kowalski', true, '1991-05-15', '121222333', 'mateusz.kowalski@example.com', 'PAC789', 2);

insert into medicalTreatment (id, description, treatment_type)
 VALUES (1, 'Przepisano leki przeciwbólowe', 'PHARMACEUTICAL'),
 (2, 'Zalecono rehabilitację', 'REHABILITATION');

insert into visit (id, description, time, doctor_id, patient_id, medical_treatment_entity_id)
VALUES (1, 'Wizyta kontrolna', '2024-03-15 10:00:00', 1, 1, 1),
(2, 'Badanie krwi', '2024-03-16 14:30:00', 2, 2, 2),
(3, 'Badanie krwi', '2024-03-15 12:00:00', 1, 3, 2),
(4, 'Rentgen', '2024-03-15 13:00:00', 1, 3, 2);