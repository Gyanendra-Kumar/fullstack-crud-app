-- Optional seed data. Spring Boot runs this automatically on startup if
-- spring.sql.init.mode=always is set (see note in README). Safe to ignore
-- while learning ddl-auto=update; useful once you disable it.
INSERT INTO categories (name) VALUES ('Electronics'), ('Books'), ('Groceries')
    ON DUPLICATE KEY UPDATE name = name;
