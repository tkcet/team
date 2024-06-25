-- 各種テーブル削除
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS orders;

-- 顧客テーブル
CREATE TABLE account
(
account_id SERIAL PRIMARY KEY,
name VARCHAR(60),
gender VARCHAR(5),
address VARCHAR(150),
tel VARCHAR(11),
email VARCHAR(256) UNIQUE,
password VARCHAR(20),
create_date DATE DEFAULT CURRENT_DATE,
creater VARCHAR(20) DEFAULT 'Mika.T',
update_date DATE DEFAULT CURRENT_DATE,
updater VARCHAR(20),
version_no INTEGER DEFAULT 1,
deletion_flag INTEGER DEFAULT 0
);

-- 商品テーブル
CREATE TABLE room
(
room_no INTEGER PRIMARY KEY,
price INTEGER,
create_date DATE DEFAULT CURRENT_DATE,
creater VARCHAR(20) DEFAULT 'Mika.T',
update_date DATE DEFAULT CURRENT_DATE,
updater VARCHAR(20),
version_no INTEGER DEFAULT 1,
deletion_flag INTEGER DEFAULT 0
);
-- 注文テーブル
CREATE TABLE orders
(
orders_id SERIAL PRIMARY KEY,
account_id INTEGER REFERENCES account(account_id),
room_no INTEGER REFERENCES room(room_no),
number_people INTEGER,
check_in DATE DEFAULT CURRENT_DATE,
check_out DATE DEFAULT CURRENT_DATE + '1 days' ::INTERVAL,
total_price INTEGER,
create_date DATE DEFAULT CURRENT_DATE,
creater VARCHAR(20),
update_date DATE DEFAULT CURRENT_DATE,
updater VARCHAR(20),
version_no INTEGER DEFAULT 1,
deletion_flag INTEGER DEFAULT 0
);