DELETE
FROM transactions;
DELETE
FROM exchange_rates;
DELETE
FROM limits;

INSERT INTO limits(id, limit_category, date_set_limit, zone_offset, sum)
VALUES (1, 'PRODUCT', '2024-01-01 10:00:00', '+02:00', 1000),
       (2, 'SERVICE', '2024-01-01 10:00:00', '+02:00', 1000),
       (3, 'PRODUCT', '2024-01-10 10:00:00', '+02:00', 5000),
       (4, 'PRODUCT', '2024-02-01 10:00:00', '+02:00', 1000),
       (5, 'SERVICE', '2024-02-01 10:00:00', '+02:00', 1000),
       (6, 'PRODUCT', '2024-02-11 10:00:00', '+02:00', 400);

INSERT INTO transactions(id, limit_id, account_from, account_to, currency_shortname, sum, sum_usd, expense_category,
                         datetime, zone_offset, limit_exceeded)
VALUES (1, 1, 1111111111, 2222222222, 'RUB', 22000.00, 220.00, 'PRODUCT', '2024-01-01 10:00:00', '+02:00', false),
       (2, 1, 1111111111, 2222222222, 'RUB', 220000.00, 2200.00, 'PRODUCT', '2024-01-07 10:00:00', '+02:00', true),
       (3, 2, 1111111111, 2222222222, 'RUB', 22000.00, 220.00, 'PRODUCT', '2024-01-11 10:00:00', '+02', false),
       (4, 3, 1111111111, 2222222222, 'RUB', 39900.00, 399.00, 'PRODUCT', '2024-02-01 10:00:00', '+02', false),
       (5, 4, 1111111111, 2222222222, 'RUB', 200.00, 2.2, 'PRODUCT', '2024-02-12 10:00:00', '+02', true),
       (6, 5, 1111111111, 2222222222, 'RUB', 200.00, 2.2, 'SERVICE', '2024-02-01 10:00:00', '+02', false);


INSERT INTO exchange_rates(id, date_exchange_rate, currency_shortname, value_rate)
VALUES (1, '2024-01-01', 'RUB', 0.01115),
       (2, '2024-01-08', 'RUB', 0.01115),
       (3, '2024-01-11', 'RUB', 0.01126),
       (4, '2024-02-01', 'RUB', 0.01115),
       (5, '2024-02-12', 'RUB', 0.011);

