CREATE DATABASE IF NOT EXISTS hospital_db;
USE hospital_db;

-- Patient details
CREATE TABLE IF NOT EXISTS patients (
    patient_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NULL,
    gender VARCHAR(10) NULL,
    phone VARCHAR(15) NULL,
    address VARCHAR(255) NULL,
    PRIMARY KEY (patient_id)
);

-- Doctor details
CREATE TABLE IF NOT EXISTS doctors (
    doctor_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NULL,
    phone VARCHAR(15) NULL,
    PRIMARY KEY (doctor_id)
);

-- Appointment details
CREATE TABLE IF NOT EXISTS appointments (
    appointment_id INT NOT NULL AUTO_INCREMENT,
    patient_id INT NULL,
    doctor_id INT NULL,
    appointment_date DATE NULL,
    status VARCHAR(30) NULL,
    PRIMARY KEY (appointment_id),
    KEY idx_appointments_patient_id (patient_id),
    KEY idx_appointments_doctor_id (doctor_id),
    CONSTRAINT fk_appointments_patient
        FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    CONSTRAINT fk_appointments_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);

-- Billing details
CREATE TABLE IF NOT EXISTS bills (
    bill_id INT NOT NULL AUTO_INCREMENT,
    patient_id INT NULL,
    amount DECIMAL(10,2) NULL,
    payment_status VARCHAR(30) NULL,
    PRIMARY KEY (bill_id),
    KEY idx_bills_patient_id (patient_id),
    CONSTRAINT fk_bills_patient
        FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);
