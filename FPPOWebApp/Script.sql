
CREATE TABLE ref_phone_type (
	id INT NOT NULL,
	short_desc VARCHAR(20) NOT NULL,
	long_desc VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE ref_address_type (
	id INT NOT NULL,
	short_desc VARCHAR(20),
	long_desc VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE phone (
	id INT NOT NULL,
	user_id INT NOT NULL,
	type INT NOT NULL,
	number VARCHAR(45) NOT NULL,
	extension VARCHAR(10),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE user (
	id INT NOT NULL,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	lastname VARCHAR(45) NOT NULL,
	firstname VARCHAR(45) NOT NULL,
	registration_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	last_payment_date DATE,
	paid BIT DEFAULT b'0' NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE address (
	id INT NOT NULL,
	user_id INT NOT NULL,
	type INT NOT NULL,
	line1 VARCHAR(200) NOT NULL,
	line2 VARCHAR(200),
	city VARCHAR(45) NOT NULL,
	state VARCHAR(45) NOT NULL,
	postal_code VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE INDEX user_id_idx ON address (user_id ASC);

CREATE INDEX address_type_idx ON address (type ASC);

CREATE UNIQUE INDEX username_UNIQUE ON user (username ASC);

CREATE INDEX fk_phone_type_idx ON phone (type ASC);

CREATE INDEX fk_user_idx ON phone (user_id ASC);

ALTER TABLE ref_address_type ADD PRIMARY KEY (id);

ALTER TABLE phone ADD PRIMARY KEY (id);

ALTER TABLE user ADD PRIMARY KEY (id);

ALTER TABLE address ADD PRIMARY KEY (id);

ALTER TABLE phone ADD CONSTRAINT fk_user FOREIGN KEY (user_id)
	REFERENCES user (id)
	ON DELETE CASCADE;

ALTER TABLE address ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id)
	REFERENCES user (id)
	ON DELETE CASCADE;

ALTER TABLE phone ADD CONSTRAINT fk_phone_type FOREIGN KEY (type)
	REFERENCES ref_phone_type (id);

ALTER TABLE address ADD CONSTRAINT fk_address_type FOREIGN KEY (type)
	REFERENCES ref_address_type (id);

