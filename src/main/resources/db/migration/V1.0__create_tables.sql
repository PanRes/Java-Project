CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE address (
                         id UUID PRIMARY KEY,
                         street VARCHAR(100) NOT NULL,
                         house_number INTEGER NOT NULL,
                         postal_code VARCHAR(10) NOT NULL,
                         town VARCHAR(100) NOT NULL
);

CREATE UNIQUE INDEX full_address_index ON address (street, house_number, postal_code, town);

CREATE TABLE "user" (
                      id UUID PRIMARY KEY,
                      first_name VARCHAR(100) NOT NULL,
                      last_name VARCHAR(100) NOT NULL,
                      address_id UUID NOT NULL REFERENCES address (id)
);

CREATE UNIQUE INDEX full_name_address_index ON "user" (first_name, last_name, address_id);

CREATE TABLE book (
                      id UUID PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      summary VARCHAR(2000) NOT NULL,
                      isbn VARCHAR NOT NULL UNIQUE ,
                      purchased INTEGER NOT NULL,
                      available INTEGER NOT NULL
);

CREATE UNIQUE INDEX book_name_isbn ON book (name, isbn);

CREATE TABLE user_book (
                           user_id UUID REFERENCES "user" (id),
                           book_id UUID REFERENCES book (id)
);


