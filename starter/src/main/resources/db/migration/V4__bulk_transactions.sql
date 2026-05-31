-- V4: bulk-seed ~10,000 transactions across ~6 months and all 5 accounts.
-- Used to demonstrate offset vs keyset pagination at realistic scale.
-- Advance the IDENTITY sequence past the existing manually-inserted ids,
-- so auto-generated bulk inserts don't collide.
SELECT setval(
    pg_get_serial_sequence('transaction', 'id'),
    (SELECT MAX(id) FROM transaction)
);

INSERT INTO transaction (account_id, amount, type, created_at, description)
SELECT
    1 + (n % 5),                                   -- account_id 1..5
    ROUND((10 + (n * 7) % 491)::numeric, 2),       -- pseudo-random amount 10-500
    CASE n % 3
        WHEN 0 THEN 'DEPOSIT'
        WHEN 1 THEN 'WITHDRAWAL'
        ELSE 'TRANSFER'
    END,
    TIMESTAMP '2026-06-01 00:00:00' - ((n * 25) || ' minutes')::interval,
    'Bulk transaction ' || n
FROM generate_series(1, 10000) AS n;

-- Populate child tables: each transaction's id must appear in the matching child table.
INSERT INTO deposit (id)
SELECT t.id FROM transaction t
WHERE t.type = 'DEPOSIT'
  AND NOT EXISTS (SELECT 1 FROM deposit d WHERE d.id = t.id);

INSERT INTO withdrawal (id)
SELECT t.id FROM transaction t
WHERE t.type = 'WITHDRAWAL'
  AND NOT EXISTS (SELECT 1 FROM withdrawal w WHERE w.id = t.id);

INSERT INTO transfer (id, target_account_id)
SELECT t.id, 1 + ((t.id + 1) % 5)
FROM transaction t
WHERE t.type = 'TRANSFER'
  AND NOT EXISTS (SELECT 1 FROM transfer tr WHERE tr.id = t.id);