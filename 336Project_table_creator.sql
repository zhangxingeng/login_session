DROP DATABASE IF EXISTS BuyMe;
CREATE DATABASE IF NOT EXISTS BuyMe;
USE BuyMe;

CREATE TABLE user(
	email VARCHAR(50),
    password VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    address VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    zip VARCHAR(6) NOT NULL,
    phone_num VARCHAR(10) NOT NULL,
    PRIMARY KEY (email)
);

CREATE TABLE buyer(
	buyer_num int auto_increment,
    email VARCHAR(50),
    fdbk INT NOT NULL,
    PRIMARY KEY (buyer_num),
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE
);

CREATE TABLE seller(
	seller_num int auto_increment,
    email VARCHAR(50),
    fdbk INT NOT NULL,
    PRIMARY KEY (seller_num),
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE
);

CREATE TABLE card(
	email VARCHAR(16),
	card_num VARCHAR(20),
	name VARCHAR(50),
	address VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    zip VARCHAR(6) NOT NULL,
    expiration_date CHAR(4) NOT NULL,
    cvv CHAR(3) NOT NULL,
    PRIMARY KEY (card_num),
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE
);

CREATE TABLE cus_rep(
	cus_email VARCHAR(50),
	password VARCHAR(20),
    PRIMARY KEY (cus_email)
);

CREATE TABLE cr_responsible_for_user(
	cus_email VARCHAR(50),
	email VARCHAR(50),
    PRIMARY KEY (email, cus_email),
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (cus_email) REFERENCES cus_rep(cus_email)
		ON DELETE CASCADE
);

CREATE TABLE admin(
	email VARCHAR(50),
	password VARCHAR(20),
    PRIMARY KEY (email)
);

CREATE TABLE phone_type(
	brand VARCHAR(25) NOT NULL,
	model VARCHAR(50) NOT NULL,
	ram INT NOT NULL,
	rom INT NOT NULL,
	cpu_core INT NOT NULL,
    os VARCHAR(20),
	PRIMARY KEY(brand, model)
);

CREATE TABLE item(
	item_num int auto_increment,
	email VARCHAR(50),
	title VARCHAR(50),
	description VARCHAR(500),
	brand VARCHAR(25) NOT NULL,
	model VARCHAR(50) NOT NULL,
	status CHAR(1),
	start_price FLOAT NOT NULL,
	timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	pic1 VARCHAR(20),
	pic2 VARCHAR(20),
	pic3 VARCHAR(20),
	PRIMARY KEY(item_num),
	FOREIGN KEY (email)
        REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (brand, model)
        REFERENCES phone_type(brand, model)
		ON DELETE CASCADE
	
);



CREATE TABLE bids(
	item_num int,
	email VARCHAR(50) NOT NULL,
	price FLOAT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (item_num) REFERENCES item(item_num)
		ON DELETE CASCADE,
        PRIMARY KEY(email, item_num)
);



CREATE TABLE purchase(
	item_num int,
	buyer_num int,
	seller_num int,
	fdbk_buyer INT NOT NULL,
	fdbk_seller INT NOT NULL,
	PRIMARY KEY (item_num, buyer_num, seller_num),
	FOREIGN KEY (item_num) REFERENCES item(item_num)
		ON DELETE CASCADE,
	FOREIGN KEY (buyer_num) REFERENCES buyer(buyer_num)
		ON DELETE CASCADE,
	FOREIGN KEY (seller_num) REFERENCES seller(seller_num)
		ON DELETE CASCADE
);

CREATE TABLE question(
	question_num int auto_increment,
	item_num int,
	email VARCHAR(50) NOT NULL,
	question VARCHAR(100),
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (item_num) REFERENCES item(item_num)
		ON DELETE CASCADE,
    PRIMARY KEY (question_num)
);

CREATE TABLE answer(
	question_num int,
	email VARCHAR(50) NOT NULL,
	answer VARCHAR(500),
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (question_num) REFERENCES question(question_num)
		ON DELETE CASCADE
);

CREATE TABLE alert(
	email VARCHAR(50) NOT NULL,
	item_num int,
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (item_num) REFERENCES item(item_num)
		ON DELETE CASCADE,
    PRIMARY KEY(email, item_num)
);

CREATE TABLE watchlist(
	email VARCHAR(50) NOT NULL,
	item_num int,
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (item_num) REFERENCES item(item_num)
		ON DELETE CASCADE,
    PRIMARY KEY(email, item_num)
);
