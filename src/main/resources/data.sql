INSERT INTO account(name,gender,address,tel,email,password,creater,deletion_flag) VALUES('administrater1','women','Japan','111','admin1@gmail.com','himitu','Mika.T',0);
INSERT INTO account(name,gender,address,tel,email,password,creater,deletion_flag) VALUES('administrater2','women','Japan','222','admin2@gmail.com','himitu','Mika.T',0);


INSERT INTO room(room_no, price, deletion_flag) VALUES(201, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(202, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(203, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(204, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(205, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(206, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(207, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(208, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(209, 5000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(210, 5000, 0);

INSERT INTO room(room_no, price, deletion_flag) VALUES(301, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(302, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(303, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(304, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(305, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(306, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(307, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(308, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(309, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(310, 6000, 0);

INSERT INTO room(room_no, price, deletion_flag) VALUES(501, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(502, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(503, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(504, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(505, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(506, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(507, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(508, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(509, 10000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(510, 10000, 0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,201,2,'2024-06-01','2024-06-08',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,203,2,'2024-06-01','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,205,2,'2024-06-08','2024-06-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,206,2,'2024-06-15','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,201,2,'2024-06-22','2024-06-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,204,2,'2024-06-25','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,207,2,'2024-06-01','2024-06-03',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,210,2,'2024-06-22','2024-06-23',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,301,2,'2024-06-01','2024-06-02',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-06-14','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-06-08','2024-06-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-06-15','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-06-22','2024-06-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-06-25','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-06-01','2024-06-03',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,310,2,'2024-06-22','2024-06-23',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,301,2,'2024-06-15','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-06-20','2024-06-22',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-06-29','2024-06-30',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,304,2,'2024-06-08','2024-06-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-06-03','2024-06-05',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-06-14','2024-06-17',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,308,2,'2024-06-13','2024-06-14',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,310,2,'2024-06-05','2024-06-10',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,301,2,'2024-06-18','2024-06-20',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,302,2,'2024-06-11','2024-07-22',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-06-26','2024-06-27',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,304,2,'2024-06-14','2024-06-20',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-06-09','2024-06-11',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-06-21','2024-06-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,309,2,'2024-06-13','2024-06-14',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,310,2,'2024-06-26','2024-06-29',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,501,2,'2024-06-01','2024-06-02',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,503,2,'2024-06-14','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,503,2,'2024-06-08','2024-06-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,505,2,'2024-06-15','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,505,2,'2024-06-22','2024-06-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,507,2,'2024-06-25','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,507,2,'2024-06-01','2024-06-03',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,510,2,'2024-06-22','2024-06-23',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,501,2,'2024-06-07','2024-06-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,501,2,'2024-06-15','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,501,2,'2024-06-22','2024-06-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,504,2,'2024-06-01','2024-06-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,505,2,'2024-06-05','2024-06-13',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,508,2,'2024-06-25','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,509,2,'2024-06-21','2024-08-03',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,510,2,'2024-06-05','2024-06-06',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,201,2,'2024-07-01','2024-07-08',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,203,2,'2024-07-01','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,205,2,'2024-07-08','2024-07-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,206,2,'2024-07-15','2024-07-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,207,2,'2024-07-14','2024-07-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,208,2,'2024-07-22','2024-08-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,209,2,'2024-07-06','2024-07-08',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,210,2,'2024-07-03','2024-07-07',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,201,2,'2024-07-25','2024-07-28',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,203,2,'2024-07-28','2024-07-30',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,205,2,'2024-07-26','2024-07-27',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,206,2,'2024-07-24','2024-07-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,207,2,'2024-07-25','2024-07-26',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,209,2,'2024-07-28','2024-08-02',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,209,2,'2024-07-24','2024-07-26',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,210,2,'2024-07-17','2024-07-22',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,301,2,'2024-07-01','2024-07-02',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-07-14','2024-07-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-07-08','2024-07-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-07-15','2024-07-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-07-22','2024-07-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-07-25','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-07-01','2024-07-03',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,310,2,'2024-07-22','2024-07-23',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,301,2,'2024-07-15','2024-07-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-07-20','2024-07-22',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-07-29','2024-07-30',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,304,2,'2024-07-08','2024-07-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-07-03','2024-07-05',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-07-14','2024-07-17',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,308,2,'2024-07-13','2024-07-14',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,310,2,'2024-07-05','2024-07-10',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,301,2,'2024-07-18','2024-07-20',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,302,2,'2024-07-11','2024-07-22',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,303,2,'2024-07-26','2024-07-27',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,304,2,'2024-07-14','2024-07-20',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-07-09','2024-07-11',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-07-21','2024-07-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,309,2,'2024-07-13','2024-07-14',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,310,2,'2024-07-26','2024-07-29',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,301,2,'2024-07-26','2024-07-29',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,302,2,'2024-07-26','2024-07-28',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,302,2,'2024-07-29','2024-07-30',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,304,2,'2024-07-28','2024-07-29',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,305,2,'2024-07-25','2024-07-27',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,307,2,'2024-07-25','2024-07-26',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,308,2,'2024-07-23','2024-07-29',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,310,2,'2024-07-26','2024-07-30',12000,0);


INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,501,2,'2024-07-01','2024-07-02',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,503,2,'2024-07-14','2024-07-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,503,2,'2024-07-08','2024-07-09',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,505,2,'2024-07-15','2024-07-16',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,505,2,'2024-07-22','2024-07-23',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,507,2,'2024-07-25','2024-07-01',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,507,2,'2024-07-01','2024-07-03',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,510,2,'2024-07-22','2024-07-23',12000,0);

INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,201,2,'2024-06-12','2024-06-15',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,202,2,'2024-06-16','2024-06-19',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,204,2,'2024-06-10','2024-06-12',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,204,2,'2024-06-16','2024-06-18',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,205,2,'2024-06-15','2024-06-17',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,208,2,'2024-06-11','2024-06-18',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,209,2,'2024-06-05','2024-06-13',12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in,check_out,total_price,deletion_flag) VALUES(1,210,2,'2024-06-03','2024-06-08',12000,0);
