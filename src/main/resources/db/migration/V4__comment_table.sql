CREATE TABLE IF NOT EXISTS comments(
    id                          BIGSERIAL NOT NULL,
    post_id                     BIGINT NOT NULL,
    time                        DATE NOT NULL,
    edit_time                   DATE,
    author_id                   BIGINT NOT NULL,
    text                        TEXT NOT NULL,
    is_blocked                  BOOLEAN NOT NULL,
    is_delete                   BOOLEAN NOT NULL,
    like_amount                 BIGINT NOT NULL,
    my_like                     BOOLEAN NOT NULL,
    comments_count              BIGINT NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE post ADD COLUMN comment_id BIGINT;
