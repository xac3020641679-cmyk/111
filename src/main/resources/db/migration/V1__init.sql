-- Initial schema for cafeteria ordering system
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  username VARCHAR(100) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  phone VARCHAR(50),
  department VARCHAR(200),
  workstation VARCHAR(200),
  role VARCHAR(50) NOT NULL
);

CREATE TABLE recipes (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  category VARCHAR(100),
  image_url VARCHAR(500),
  unit VARCHAR(50),
  price DECIMAL(10,2),
  description TEXT
);

CREATE TABLE menu_snapshots (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  created_by VARCHAR(100),
  created_at DATETIME
);

CREATE TABLE menu_snapshot_items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  menu_snapshot_id BIGINT NOT NULL,
  recipe_id BIGINT,
  name VARCHAR(200) NOT NULL,
  category VARCHAR(100),
  unit VARCHAR(50),
  price DECIMAL(10,2) NOT NULL,
  image_url VARCHAR(500),
  FOREIGN KEY (menu_snapshot_id) REFERENCES menu_snapshots(id) ON DELETE CASCADE
);

CREATE TABLE orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT,
  user_name VARCHAR(100),
  user_phone VARCHAR(50),
  workstation VARCHAR(200),
  created_at DATETIME,
  order_date DATE,
  total_price DECIMAL(10,2)
);

CREATE TABLE order_items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT NOT NULL,
  menu_snapshot_item_id BIGINT,
  name VARCHAR(200),
  unit VARCHAR(50),
  quantity INT,
  unit_price DECIMAL(10,2),
  subtotal DECIMAL(10,2),
  FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

CREATE TABLE system_settings (
  name VARCHAR(100) PRIMARY KEY,
  value VARCHAR(200)
);

-- Seed default settings
INSERT INTO system_settings (name, value) VALUES ('order_deadline', '09:00');
INSERT INTO system_settings (name, value) VALUES ('delivery_start', '11:30');
