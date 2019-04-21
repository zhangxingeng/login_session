
insert into item(item_num,email,title,description,brand,model,status,start_price,pic1,pic2,pic3) 
values
(111111,'Tom@gmail.com','wow','White House and Justice Dept. Officials Discussed Mueller Report Before Release','Sony','H9',S,1.0,NULL,NULL,NULL),
(222222,'Nick@outlook.com','what','Not all of Robert S. Mueller III findings will be news to President Trump when they are released Thursday morning','Sony','H9',S,2.0,NULL,NULL,NULL),
(333333,'James@rutgers.edu','why','A sense of paranoia is taking hold among some of Mr. Trump’s aides','Sony','H9',A,9.8,NULL,NULL,NULL),
(444444,'Chris@qq.com','how','The report might make clear which of Mr. Trump current and former advisers spoke to the special counsel, how much they said and how much damage they did to the president providing a kind of road map for retaliation','Sony','H9',S,6.9,NULL,NULL,NULL),
(555555,'Cameron@163.com','andthen','Justice Department rules do not require Mr. Barr to make the special counsel report public, and the attorney general’s defenders say','Sony','H9',A,0.0,NULL,NULL,NULL),
(666666,'Emma@yahoo.com','sowhat','Much is at stake for Mr. Barr in Thursday expected release','Sony','H9',A,3.3,NULL,NULL,NULL),
(777777,'Olivia@scarletmail.rutgers.edu','ok','The information that Justice Department officials have provided to the White House could potentially be valuable for Mr. Trump’s legal team as it finalizes a rebuttal to the Mueller report','Sony','H9',S,77.7,NULL,NULL,NULL),
(888888,'Ava@gmail.com','which','Mr. Trump','Sony','H9',A,5555.4,NULL,NULL,NULL),
(999999,'Isabella@outlook.com','with','The discussions between Justice Department officials and White House lawyers have also added to questions about the propriety of the decisions by Attorney General William P. Barr','Sony','H9',S, 66.9,"","","");


insert into user(email,password,name,address,state,zip,phone_num) 
values
('336','88888888','Tom','10 Bayberry close','NJ','08854','7326685517');


insert into cus_rep(cus_email,password) 
values
('336','88888888');


insert into admin(mail,password) 
values
('336','88888888');


show tables;
describe item;
describe user;
describe cus_rep;
describe admin;
show columns from item;
show columns from user;
show columns from cus_rep;
show columns from admin;

/*comment: items belong to noone. need to create more user nick james...*/
/*

*/