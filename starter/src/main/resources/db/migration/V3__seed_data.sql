INSERT INTO CUSTOMER( name, email, address_street, address_city, address_state, address_zip) VALUES
('Jane Smith', 'jane@homegoods.com', '545 Street View', 'Springfield', 'Florida', '87656'),
('John White', 'john@buyer.com', '256th Street East', 'San Francisco', 'California', '65432'),
('William Jones', 'william@shopper.com', '67th Street West', 'Huntington Beach', 'California', '67895');

INSERT INTO ACCOUNT( customer_id, account_number, balance, account_type) VALUES
(1, 'ACCOUNT1', 1000.00, 'CHECKING'),
(1, 'ACCOUNT2', 5500.00, 'SAVINGS'),
(2, 'ACCOUNT3', 2000.00, 'CHECKING'),
(2, 'ACCOUNT4', 12000.00, 'SAVINGS'),
(3, 'ACCOUNT5', 3000.00, 'CHECKING');

INSERT INTO TRANSACTION(id, account_id, amount, type, created_at, description)
OVERRIDING SYSTEM VALUE VALUES
(1, 1, 100.00, 'DEPOSIT', '2026-01-15 10:30:00', 'Initial Deposit'),
(2, 1, 50.00, 'WITHDRAWAL', '2026-02-05 10:30:00', 'Atm Withdrawal'),
(3, 2, 200.00, 'DEPOSIT', '2026-02-22 10:30:00', 'Paycheck'),
(4, 1, 75.00, 'TRANSFER', '2026-03-10 10:30:00', 'Transfer to John'),
(5, 3, 500.00, 'DEPOSIT', '2026-03-25 10:30:00', 'Paycheck'),
(6, 4, 1000.00, 'DEPOSIT', '2026-04-03 10:30:00', 'Bonus'),
(7, 4, 200.00, 'WITHDRAWAL', '2026-04-28 10:30:00', 'Bill Payment'),
(8, 5, 150.00, 'TRANSFER', '2026-05-15 10:30:00', 'Transfer to Jane');


INSERT INTO deposit(id) VALUES (1), (3), (5), (6);
INSERT INTO withdrawal(id) VALUES (2), (7);
INSERT INTO transfer(id, target_account_id) VALUES (4, 3), (8, 1);
