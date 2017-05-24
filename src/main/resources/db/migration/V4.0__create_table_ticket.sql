CREATE TABLE ticket (
  id BIGINT NOT NULL AUTO_INCREMENT,
  location VARCHAR(255) NOT NULL,
  account_id BIGINT NOT NULL,
  artist_id BIGINT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (account_id) REFERENCES account(id)
  FOREIGN KEY (artist_id) REFERENCES artist(id)

);