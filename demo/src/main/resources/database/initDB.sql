CREATE TABLE IF NOT EXISTS clients
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(50)  NOT NULL
<<<<<<< HEAD
)
;
=======
);
CREATE TABLE IF NOT EXISTS orders
(
    id    SERIAL PRIMARY KEY ,
    clientid  INTEGER NOT NULL ,
    amount NUMERIC(10,2) NOT NULL
);
>>>>>>> be4c206 (Initial commit)
