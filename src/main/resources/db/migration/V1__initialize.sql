CREATE TABLE document (id bigserial PRIMARY KEY, name VARCHAR(255), content VARCHAR(5000), type VARCHAR(255), created_at TIMESTAMP DEFAULT current_timestamp, updated_at TIMESTAMP DEFAULT current_timestamp);
INSERT INTO document (name, content, type) VALUES
('Russian Passport', 'serial number', 'PASSPORT'),
('Сar License', 'number', 'DRIVERS_LICENSE'),
('International Passport', 'serial number', 'PASSPORT');
