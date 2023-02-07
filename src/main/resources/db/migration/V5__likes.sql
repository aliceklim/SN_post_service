ALTER TABLE post
ADD COLUMN time_changed TIMESTAMP,
ADD COLUMN type VARCHAR(255),
ADD COLUMN is_deleted BOOLEAN DEFAULT FALSE,
ADD COLUMN comment_count BIGINT DEFAULT 0,
ADD COLUMN like_amount BIGINT DEFAULT 0,
ADD COLUMN my_like BOOLEAN DEFAULT FALSE,
ADD COLUMN imagepath VARCHAR(255),
ADD COLUMN publish_date TIMESTAMP;

ALTER TABLE comments ADD COLUMN imagepath VARCHAR(255);

ALTER TABLE comments
ALTER COLUMN "time" TYPE TIMESTAMP,
ALTER COLUMN edit_time TYPE TIMESTAMP;

CREATE TABLE IF NOT EXISTS like2post (
    person_id           BIGINT NOT NULL,
    post_id             BIGINT NOT NULL,
    PRIMARY KEY (person_id, post_id),
    FOREIGN KEY (person_id) REFERENCES person_service.person(id),
    FOREIGN KEY (post_id) REFERENCES post(id)
);

CREATE TABLE IF NOT EXISTS like2comment (
    person_id              BIGINT NOT NULL,
    comment_id             BIGINT NOT NULL,
    PRIMARY KEY (person_id, comment_id),
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (comment_id) REFERENCES comment(id)
);