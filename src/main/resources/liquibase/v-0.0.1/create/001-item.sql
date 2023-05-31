CREATE TABLE IF NOT EXISTS item (
    id        UUID                    NOT NULL CONSTRAINT PK_item PRIMARY KEY DEFAULT uuid_generate_v4(),
    name      VARCHAR UNIQUE          NOT NULL,
    added     TIMESTAMP DEFAULT NOW() NOT NULL,
    available BOOLEAN   DEFAULT TRUE  NOT NULL
);