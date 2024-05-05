CREATE TABLE users(
                      id SERIAL PRIMARY KEY NOT NULL,
                    name TEXT NOT NULL,
                      login TEXT NOT NULL UNIQUE,
                      password TEXT NOT NULL,
                      role TEXT NOT NULL
);