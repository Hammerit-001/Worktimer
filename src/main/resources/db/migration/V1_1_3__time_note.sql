CREATE TABLE if not exists time_note
(
    time_note_id SERIAL PRIMARY KEY,
    worker_id BIGINT, FOREIGN KEY (worker_id) REFERENCES workers(worker_id) ON DELETE RESTRICT,
    date date,
    time time

)