INSERT INTO account(name,gender,address,tel,email,password,deletion_flag) VALUES('administrater1','women','Japan','111','admin1@gmail.com','himitu',0);
INSERT INTO account(name,gender,address,tel,email,password,deletion_flag) VALUES('administrater2','women','Japan','222','admin2@gmail.com','himitu',0);
INSERT INTO account(name,gender,address,tel,email,password,deletion_flag) VALUES('administrater3','women','Japan','333','admin3@gmail.com','himitu',0);

INSERT INTO room(room_no, price, deletion_flag) VALUES(201, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(202, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(203, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(204, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(205, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(206, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(207, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(208, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(209, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(210, 6000, 0);

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

INSERT INTO room(room_no, price, deletion_flag) VALUES(501, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(502, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(503, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(504, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(505, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(506, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(507, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(508, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(509, 6000, 0);
INSERT INTO room(room_no, price, deletion_flag) VALUES(510, 6000, 0);

INSERT INTO orders(account_id, room_no, number_people,total_price,deletion_flag) VALUES(1,201,2,12000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in, check_out, total_price,deletion_flag) VALUES(1,203,2,'2024-06-21','2024-06-25',48000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in, check_out, total_price,deletion_flag) VALUES(1,304,2,'2024-06-27','2024-06-30',36000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in, check_out, total_price,deletion_flag) VALUES(1,501,2,'2024-06-27','2024-06-30',36000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in, check_out, total_price,deletion_flag) VALUES(1,210,2,'2024-06-01','2024-06-05',48000,1);
INSERT INTO orders(account_id, room_no, number_people,check_in, check_out, total_price,deletion_flag) VALUES(1,201,2,'2024-07-01','2024-07-05',48000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in, check_out, total_price,deletion_flag) VALUES(1,207,2,'2024-06-25','2024-07-03',96000,0);
INSERT INTO orders(account_id, room_no, number_people,check_in, check_out, total_price,deletion_flag) VALUES(1,203,2,'2024-06-07','2024-06-13',72000,0);