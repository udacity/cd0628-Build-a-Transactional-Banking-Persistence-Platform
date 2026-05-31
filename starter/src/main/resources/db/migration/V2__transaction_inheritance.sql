CREATE TABLE deposit (
    id BIGINT PRIMARY KEY REFERENCES transaction(id)
);

CREATE TABLE withdrawal (
    id BIGINT PRIMARY KEY REFERENCES transaction(id)
);

CREATE TABLE transfer (
    id BIGINT PRIMARY KEY REFERENCES transaction(id),
    target_account_id BIGINT NOT NULL REFERENCES account(id)
);