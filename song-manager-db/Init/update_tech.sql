-- Creates the song table 
CREATE TABLE song
(
  song_id numeric(8) NOT NULL,
  title varchar(64) NOT NULL,
  CONSTRAINT pk_song PRIMARY KEY (song_id)
);

CREATE SEQUENCE song_seq INCREMENT 1 START 1 CACHE 1 CYCLE;
ALTER TABLE song_seq OWNER TO dev;

ALTER TABLE song OWNER TO dev;
ALTER TABLE song ALTER COLUMN song_id SET DEFAULT NEXTVAL('song_seq');

-- Creates the song writer table
CREATE TABLE song_writer
(
  song_writer_id numeric(8) NOT NULL,
  first_name varchar(32) NOT NULL,
  last_name varchar(32),
  CONSTRAINT pk_song_writer PRIMARY KEY (song_writer_id),
  CONSTRAINT u_song_writer UNIQUE (first_name, last_name)
);

CREATE SEQUENCE song_writer_seq INCREMENT 1 START 1 CACHE 1 CYCLE;
ALTER TABLE song_writer_seq OWNER TO dev;

ALTER TABLE song_writer OWNER TO dev;
ALTER TABLE song_writer ALTER COLUMN song_writer_id SET DEFAULT NEXTVAL('song_writer_seq');

-- Creates the association table between song and song_writer
CREATE TABLE song_song_writer
(
  song_id numeric(8) NOT NULL,
  song_writer_id numeric(8) NOT NULL,
  CONSTRAINT pk_song_song_writer PRIMARY KEY (song_id, song_writer_id),
  CONSTRAINT fk_song_song_writer_song FOREIGN KEY (song_id)
      REFERENCES song (song_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_song_song_writer_song_writer FOREIGN KEY (song_writer_id)
      REFERENCES song_writer (song_writer_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Creates the score table 
CREATE TABLE score
(
	score_id numeric(8) NOT NULL,
	song_id numeric(8) NOT NULL,
	version smallint NOT NULL,
	receipt_date timestamp without time zone NOT NULL,
	CONSTRAINT score_pk PRIMARY KEY (score_id),
	CONSTRAINT fk_score_song FOREIGN KEY (song_id)
      REFERENCES song (song_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE SEQUENCE score_seq INCREMENT 1 START 1 CACHE 1 CYCLE;
ALTER TABLE score_seq OWNER TO dev;

ALTER TABLE score OWNER TO dev;
ALTER TABLE score ALTER COLUMN score_id SET DEFAULT NEXTVAL('score_seq');