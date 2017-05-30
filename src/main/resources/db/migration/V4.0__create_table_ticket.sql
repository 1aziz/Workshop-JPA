CREATE TABLE concert (
  id BIGINT NOT NULL AUTO_INCREMENT,
  location_id BIGINT NOT NULL,
  artist_id BIGINT NOT NULL,
  date TIMESTAMP NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE location (
  id BIGINT NOT NULL AUTO_INCREMENT,
  location_name VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);


CREATE TABLE artist (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  genre VARCHAR(255) NOT NULL,
  PRIMARY KEY(id));

CREATE TABLE ticket (
  id BIGINT NOT NULL AUTO_INCREMENT,
  location VARCHAR(255) NOT NULL,
  account_id BIGINT NOT NULL,
  artist_id BIGINT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (account_id) REFERENCES account(id),
  FOREIGN KEY (artist_id) REFERENCES artist(id)

);

ALTER TABLE concert ADD CONSTRAINT artist_id_fk FOREIGN KEY (artist_id) REFERENCES artist(id);
ALTER TABLE concert ADD CONSTRAINT location_id_fk FOREIGN KEY (location_id) REFERENCES location(id);