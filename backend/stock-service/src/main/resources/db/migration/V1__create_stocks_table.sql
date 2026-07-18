CREATE TABLE stocks (
    id UUID PRIMARY KEY,
    symbol VARCHAR(10) NOT NULL,
    company_name VARCHAR(200) NOT NULL,
    current_price NUMERIC(19, 4) NOT NULL,
    previous_close NUMERIC(19, 4) NOT NULL,
    last_updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL,
    CONSTRAINT uk_stocks_symbol UNIQUE (symbol),
    CONSTRAINT chk_stocks_current_price_positive CHECK (current_price > 0),
    CONSTRAINT chk_stocks_previous_close_positive CHECK (previous_close > 0)
);
