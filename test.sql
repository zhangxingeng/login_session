
insert into item(item_num,email,title,description,category,status,start_price,pic1,pic2,pic3) 
values
(111111,'Tom@gmail.com','wow','White House and Justice Dept. Officials Discussed Mueller Report Before Release','phone',0,1.0,NULL,NULL,NULL),
(222222,'Nick@outlook.com','what','Not all of Robert S. Mueller III’s findings will be news to President Trump when they are released Thursday morning','phone',0,2.0,NULL,NULL,NULL),
(333333,'James@rutgers.edu','why','A sense of paranoia is taking hold among some of Mr. Trump’s aides','phone',0,9.8,NULL,NULL,NULL),
(444444,'Chris@qq.com','how','The report might make clear which of Mr. Trump’s current and former advisers spoke to the special counsel, how much they said and how much damage they did to the president — providing a kind of road map for retaliation','phone',1,6.9,NULL,NULL,NULL),
(555555,'Cameron@163.com','andthen','Justice Department rules do not require Mr. Barr to make the special counsel’s report public, and the attorney general’s defenders say','phone',1,0.0,NULL,NULL,NULL),
(666666,'Emma@yahoo.com','sowhat','Much is at stake for Mr. Barr in Thursday’s expected release','phone','gun',1,3.3,NULL,NULL,NULL),
(777777,'Olivia@scarletmail.rutgers.edu','ok','The information that Justice Department officials have provided to the White House could potentially be valuable for Mr. Trump’s legal team as it finalizes a rebuttal to the Mueller report','phone',0,77.7,NULL,NULL,NULL),
(888888,'Ava@gmail.com','which','Mr. Trump','phone',0,5555.4,NULL,NULL,NULL),
(999999,'Isabella@outlook.com','with','The discussions between Justice Department officials and White House lawyers have also added to questions about the propriety of the decisions by Attorney General William P. Barr','phone',1,66.9,NULL,NULL,NULL),


insert into user(email,password,name,address,state,zip,phone_num) 
values
('Tom@gmail.com','password','Tom','10 Bayberry close','NJ','08854','7326685517')


insert into cus_rep(cus_email,password) 
values
('cus_rep1@gmail.com','password')


insert into admin(mail,password) 
values
('admin1@gmail.com','password')


show tables;
describe item;
describe user;
describe cus_rep;
describe admin;
show columns from item;
show columns from user;
show columns from cus_rep;
show columns from admin;
