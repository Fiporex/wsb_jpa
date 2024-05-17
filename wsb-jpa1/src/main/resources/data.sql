-- Inserting into ADDRESS table
INSERT INTO address (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, '123 Main St', 'Apt 4B', 'New York', '10001'),
    (2, '456 Elm St', NULL, 'Los Angeles', '90001'),
    (3, '789 Oak St', 'Suite 500', 'Chicago', '60601'),
    (4, '101 Maple St', 'Unit 2', 'San Francisco', '94101'),
    (5, '202 Pine St', 'Floor 3', 'Houston', '77001');
-- Inserting into DOCTOR table
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES
    (1, 'John', 'Doe', '123456789', 'john.doe@example.com', 'D001', 'CARDIOLOGY', 1),
    (2, 'Jane', 'Smith', '987654321', 'jane.smith@example.com', 'D002', 'DERMATOLOGY', 2),
    (3, 'Alice', 'Johnson', '555555555', 'alice.johnson@example.com', 'D003', 'NEUROLOGY', 3),
    (4, 'Bob', 'Brown', '444444444', 'bob.brown@example.com', 'D004', 'PEDIATRICS', 4),
    (5, 'Carol', 'Williams', '333333333', 'carol.williams@example.com', 'D005', 'ORTHOPEDICS', 5);
-- Inserting into MEDICAL_TREATMENT table

-- Inserting into PATIENT table
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES
    (1, 'Michael', 'Brown', '123456789', 'michael.brown@example.com', 'P001', '1980-05-20', 1),
    (2, 'Sarah', 'Davis', '987654321', 'sarah.davis@example.com', 'P002', '1990-08-15', 2),
    (3, 'David', 'Wilson', '555555555', 'david.wilson@example.com', 'P003', '1975-02-10', 3),
    (4, 'Emily', 'Martinez', '444444444', 'emily.martinez@example.com', 'P004', '1985-12-30', 4),
    (5, 'James', 'Garcia', '333333333', 'james.garcia@example.com', 'P005', '2000-01-25', 5);
-- Inserting into VISIT table
INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES
    (1, 'Routine Checkup', '2023-01-15T10:00:00', 1, 1),
    (2, 'Dermatology Consultation', '2023-02-20T14:30:00', 2, 2),
    (3, 'Neurological Examination', '2023-03-10T09:00:00', 3, 3),
    (4, 'Pediatric Checkup', '2023-04-05T11:00:00', 4, 4),
    (5, 'Orthopedic Consultation', '2023-05-25T16:00:00', 5, 5);
-- Inserting into MEDICAL_TREATMENT table
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES
    (1, 'Ultrasound Examination', 'USG', 1),
    (2, 'Electrocardiogram', 'EKG', 2),
    (3, 'Radiography', 'RTG', 3),
    (4, 'Ultrasound Follow-up', 'USG', 4),
    (5, 'X-Ray Examination', 'RTG', 5);






