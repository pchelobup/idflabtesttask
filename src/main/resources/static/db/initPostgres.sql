DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS exchange_rates;
DROP TABLE IF EXISTS limits;


DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq AS BIGINT START WITH 1000;

create TABLE limits
(
    id             BIGINT PRIMARY KEY DEFAULT nextval('global_seq'),
    limit_category VARCHAR(7) NOT NULL,
    date_set_limit timestamp  NOT NULL,
    sum            NUMERIC    NOT NULL
);

CREATE TABLE transactions
(
    id                 BIGINT PRIMARY KEY DEFAULT nextval('global_seq'),
    limit_id           BIGINT      NOT NULL,
    account_from       BIGINT      NOT NULL,
    account_to         BIGINT      NOT NULL,
    currency_shortname VARCHAR(30) NOT NULL,
    sum                NUMERIC     NOT NULL,
    sum_usd            NUMERIC     NOT NULL,
    expense_category   VARCHAR(7)  NOT NULL,
    datetime           TIMESTAMPTZ NOT NULL,
    zone_offset        VARCHAR(6)  NOT NULL,
    limit_exceeded     BOOLEAN     NOT NULL,
    FOREIGN KEY (limit_id) REFERENCES limits (id)
);
/*currency and date should be unique*/
create TABLE exchange_rates
(
    id                 BIGINT PRIMARY KEY DEFAULT nextval('global_seq'),
    date_exchange_rate DATE       NOT NULL,
    currency_shortname VARCHAR(3) NOT NULL,
    value_rate         NUMERIC    NOT NULL
);

