CREATE TABLE sale (
  id BIGINT NOT NULL AUTO_INCREMENT,
  price INT NOT NULL,
  sell_date TIMESTAMP NOT NULL,

  ticket_account_id BIGINT NOT NULL,
  ticket_concert_id  BIGINT NOT NULL,

  CONSTRAINT pk_sale PRIMARY KEY(id),
  CONSTRAINT fk_account_id FOREIGN KEY (ticket_account_id) REFERENCES ticket(account_id),
  CONSTRAINT ticket_concert_id FOREIGN KEY(ticket_concert_id) REFERENCES ticket(concert_id),
  CONSTRAINT chk_price CHECK (price > 0)
);

CREATE TABLE audittrail (
  id BIGINT NOT NULL AUTO_INCREMENT,
  account_id BIGINT NOT NULL,
  sale_id BIGINT NOT NULL,
  CONSTRAINT pk_audittrail PRIMARY KEY(id),
  CONSTRAINT account_id_fk FOREIGN KEY (account_id) REFERENCES account(id),
  CONSTRAINT sale_id_fk FOREIGN KEY (sale_id) REFERENCES sale(id)

)