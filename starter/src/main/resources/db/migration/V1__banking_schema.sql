CREATE TABLE customer (
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    email           VARCHAR(255) NOT NULL UNIQUE,
    address_street  VARCHAR(255) NOT NULL,
    address_city    VARCHAR(100) NOT NULL,
    address_state   VARCHAR(50)  NOT NULL,
    address_zip     VARCHAR(20)  NOT NULL
);

CREATE TABLE account ( 
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
    customer_id BIGINT NOT NULL REFERENCES customer(id), 
    account_number VARCHAR(100) UNIQUE NOT NULL, 
    balance NUMERIC(19,2) NOT NULL DEFAULT 0, 
    account_type VARCHAR(100) NOT NULL
);

CREATE TABLE transaction (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
    account_id BIGINT NOT NULL REFERENCES account(id), 
    amount NUMERIC(19,2) NOT NULL, 
    type VARCHAR(100) NOT NULL, 
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    description TEXT
);
