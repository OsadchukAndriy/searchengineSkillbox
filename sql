create table Site(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    status ENUM ('INDEXING', 'INDEXED', 'FAILED') NOT NULL,
    status_time DATETIME NOT NULL,
    last_error TEXT,
    url VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL
);

create table Page(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    site_id int NOT NULL,
    path TEXT NOT NULL,
    code int NOT NULL,
    content MEDIUMTEXT NOT NULL,
    INDEX(path(255)),
    FOREIGN KEY (site_id) REFERENCES site(id)
);

