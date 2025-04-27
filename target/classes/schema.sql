CREATE TABLE poll(
	id LONG PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(255),
	question VARCHAR(255),
	answer VARCHAR(255),
	vote1 INT,
	vote2 INT,
	vote3 INT,
	dateField DATETIME
);
	