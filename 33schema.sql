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

CREATE TABLE staff(
	staff_email VARCHAR(50),
	password VARCHAR(20),
    PRIMARY KEY (staff_email)
);

CREATE TABLE staff_to_user(
	staff_email VARCHAR(50),
	email VARCHAR(50),
    PRIMARY KEY (email, staff_email),
    FOREIGN KEY (email) REFERENCES user(email)
		ON DELETE CASCADE,
	FOREIGN KEY (staff_email) REFERENCES staff(staff_email)
		ON DELETE CASCADE
);

CREATE TABLE admin(
	admin_email VARCHAR(50),
	password VARCHAR(20),
    PRIMARY KEY (admin_email)
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
        PRIMARY KEY(email, item_num, price)
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

CREATE TABLE email(
	message_id int auto_increment,
	sender_email VARCHAR(50),
    reciver_email VARCHAR(50),
    message VARCHAR(200) NOT NULL,
    PRIMARY KEY (message_id)
);
use BuyMe;
INSERT INTO user(email,password,name,address,state,zip,phone_num) 
VALUES
('1','1','Tom','10 Bayberry Close','NJ','08854','7326685517');

INSERT INTO staff(staff_email,password) 
VALUES
('1','1');
INSERT INTO admin(admin_email,password) 
VALUES
('1','1');

INSERT INTO phone_type(brand,model,ram,rom,cpu_core,os)
VALUES
('Apple','iPhone 7',2,64,2,'iOS10'),
('samsung','galaxy',4,128,4,'android');

INSERT INTO item(email,title,description,brand,model,status,start_price,pic1,pic2,pic3)
VALUES
('1','Apple iPhone 7 16GB 64GB 128GB (Unlocked) Space Gray, Rose Gold, Silver, Gold',
'This update to the iPhone series features an improved camera, processor, and battery, 
plus its water-resistant. Other features are similar, including a pressure-sensitive screen
 with haptic feedback, rounded metal design, NFC, fingerprint reader, Siri voice assistant, 
and front camera.','Apple','iPhone 7','A',220,NULL,NULL,NULL),
('1','Samsung Galaxy S9 Plus SM-G965U 64GB Smartphone Unlocked','Dual Optical Image Stabilization DeX compatible for using the S9+
 with a monitor, keyboard, or mouse Samsung Knox for multi-level security designed from the 
chip up Secure Folder gives you the ability to separate work information from personal Wireless 
charging support with optional accessories Expand your storage with optional microSD cards 
(up to 400GB) Dolby Atmos technology for multi-dimensional sound Turn Super Slow-mo videos 
into GIFs Edit Super Slow-mo videos with music and 3 styles of looping IP68 rating, so it can 
be submerged in up to 5min of freshwater for up to 30 minutes. Its also dust, dirt and sand 
resistant Live translation of other languages in real time Use AR and Bixby Vision for more 
info of the world around you','samsung','galaxy','A',220,NULL,NULL,NULL);

INSERT INTO `BuyMe`.`bids` (`item_num`, `email`, `price`) VALUES ('1', '1', '12');
INSERT INTO `BuyMe`.`bids` (`item_num`, `email`, `price`) VALUES ('1', '1', '13');
INSERT INTO `BuyMe`.`bids` (`item_num`, `email`, `price`) VALUES ('1', '1', '14');
INSERT INTO `BuyMe`.`bids` (`item_num`, `email`, `price`) VALUES ('1', '1', '17');
INSERT INTO `BuyMe`.`bids` (`item_num`, `email`, `price`) VALUES ('1', '1', '21');
