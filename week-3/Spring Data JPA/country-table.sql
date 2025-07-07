CREATE TABLE department (
  dp_id INT PRIMARY KEY AUTO_INCREMENT,
  dp_name VARCHAR(50)
);

CREATE TABLE employee (
  em_id INT PRIMARY KEY AUTO_INCREMENT,
  em_name VARCHAR(50),
  em_dp_id INT,
  FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);
INSERT INTO department (dp_name) VALUES ('Technology'), ('HR');

INSERT INTO employee (em_name, em_dp_id) VALUES 
('Alice', 1), 
('Bob', 1), 
('Charlie', 2);
