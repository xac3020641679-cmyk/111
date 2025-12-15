-- Seed data: admin user (manager) and sample recipes
-- Password uses bcrypt for 'adminpass' (encoded)
INSERT INTO USER_ENTITY (id, username, password, role) VALUES (1, 'admin', '$2a$10$7EqJtq98hPqEX7fNZaFWoOa1Gz5y5u0E1Zq9r1mQKfQdH6zYw3Y6', 'MANAGER');

INSERT INTO RECIPE (id, name, description) VALUES (1, 'Spaghetti', 'Classic spaghetti');
INSERT INTO RECIPE (id, name, description) VALUES (2, 'Salad', 'Green salad');

-- sample system setting for order deadline
INSERT INTO SYSTEM_SETTING (id, setting_key, setting_value) VALUES (1, 'order_deadline', '23:59');

-- sample snapshot (optional)

