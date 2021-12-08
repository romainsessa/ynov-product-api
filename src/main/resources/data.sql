DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
 
CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  cost INT(250) NOT NULL
);
 
INSERT INTO products (name, description, cost) VALUES
  ('iphone', 'smartphone apple', 1000),
  ('ipad', 'tablette apple', 500),
  ('imac', 'ordinateur apple', 2000);
  
 CREATE TABLE comments (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  id_product INT(250)
);

INSERT INTO comments (content, id_product) VALUES
  ('trop cher', 1),
  ('trop cool', 1),
  ('useless', 3);
  
 CREATE TABLE categories (
  category_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO categories (name) VALUES
  ('smartphone'),
  ('tablette'),
  ('ordinateur'),
  ('apple');
  
CREATE TABLE category_product (
	category_id INT NOT NULL,
	product_id INT NOT NULL
);

INSERT INTO category_product (category_id, product_id) VALUES
	(1,1),
	(2,2),
	(3,3),
	(4,1),
	(4,2),
	(4,3);
	
CREATE TABLE users (
	id INT AUTO_INCREMENT  PRIMARY KEY,
	username VARCHAR(255),
	password VARCHAR(255)
);

INSERT INTO users (username, password) VALUES
	('user',
	'$2a$12$3QJUKRUlH6eOldgAeEhBXuVXnFYcdG9L6TeJ8Dtw726lmYrFPomgW'),
	('admin',
	'$2a$12$hJuHwAbUTK77f5iv51yRLeUjot6rL4pwzJNC3u4K2wQSSho1CjBla');