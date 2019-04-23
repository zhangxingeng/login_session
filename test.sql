use BuyMe;
INSERT INTO user(email,password,name,address,state,zip,phone_num) 
VALUES
('Tom@gmail.com','88888888','Tom','10 Bayberry Close','NJ','08854','7326685517');

INSERT INTO phone_type(brand,model,ram,rom,cpu_core,os)
VALUES
('Apple','iPhone 7',2,128,4,'iOS10');

INSERT INTO item(email,title,description,brand,model,status,start_price,pic1,pic2,pic3)
VALUES
('Tom@gmail.com','Factory Unlocked','This is a B stock item, meaning unit is in fair cosmetic condition and will show signs of use in the form of scrapes or scratches.','Apple','iPhone 7','A',220,NULL,NULL,NULL);

