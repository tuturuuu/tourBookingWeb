CREATE TABLE asm1.Booking (
    id INT(11) NOT NULL AUTO_INCREMENT,
    user_id INT(11),
    tour_id INT(11),
    created_date DATE,
    adult_quant INT(5),
    child_quant INT(5),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (tour_id) REFERENCES Tour(id) ON DELETE CASCADE
);

DROP TABLE asm1.Booking

