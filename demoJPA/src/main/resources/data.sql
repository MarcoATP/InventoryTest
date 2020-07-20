DROP TABLE IF EXISTS item;
 
CREATE TABLE item (
  no INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  amount INT(11) NOT NULL,
  inventory_code VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO item (name, amount, inventory_code) VALUES
  ('Item1', '24', '1234567'),
  ('Item2', '33', 'qwerty'),
  ('Item3', '51', 'zxcvbnm');