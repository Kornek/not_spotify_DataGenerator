create table genres(
	genreid number not null,
	genrename varchar2(255),
	constraint pk_genreid primary key (genreid)
);
create table labels(
	labelid number not null,
	labelname varchar2(255),
	constraint pk_labelid primary key (labelid)
);
create table artists(
	artistid number not null,
	artistname varchar2(255),
	constraint pk_artistid primary key (artistid)
);
create table albums (
  albumid number not null,
  artistid number not null,
  labelid number not null,
  albumname varchar2(255) not null,
  coverimage blob,
  constraint pk_albumid primary key(albumid),
  constraint fk_albums_artistid foreign key (artistid) references artists(artistid),
  constraint fk_albums_labelid foreign key (labelid) references labels(labelid)
);
create table songs (
  songid number not null,
  songname varchar2(255) not null,
  albumid number not null,
  artistid number not null,
  genreid number not null,
  songfile blob not null,
  tracknr number,
  constraint pk_songid primary key (songid),
  constraint fk_songs_albumid foreign key (albumid) references albums(albumid),
  constraint fk_songs_artistid foreign key (artistid) references artists(artistid),
  constraint fk_songs_genreid foreign key (genreid) references genres(genreid)
);
create table users (
  userid number not null,
  username varchar2(255) not null,
  firstname varchar2(255),
  lastname varchar2(255),
  email varchar2 (255) not null unique,
  password varchar2 (255),
  constraint pk_userid primary key (userid)
);
create table playlists (
  playlistid number not null,
  playlistname varchar2(255) not null,
  userid number not null,
  created date,
  constraint pk_playlistid primary key (playlistid),
  constraint fk_playlists_userid foreign key (userid) references users(userid)
);
create table playlistsongs (
	playlistid number not null,
	songid number not null,
	constraint fk_playlistsongs_playlistid foreign key (playlistid) references playlists(playlistid),
	constraint fk_playlistsongs_songid foreign key (songid) references songs(songid),
	constraint pk_playlistsongsid primary key (playlistid,songid)
);
create table comments(
	commentid number not null,
	songid number,
	albumid number,
	userid not null,
	text varchar2(255),
	constraint pk_commentid primary key (commentid),
	constraint fk_comments_albumid foreign key (albumid) references albums(albumid),
	constraint fk_comments_songid foreign key (songid) references songs(songid),
	constraint fk_comments_userid foreign key (userid) references users(userid),
	constraint chk_songid_ablumid check(songid IS NOT NULL OR albumid IS NOT NULL)
);
create table musicians(
	musicianid number not null,
	artistid number not null,
	musicianname varchar2(255),
	constraint pk_musicianid primary key (musicianid),
	constraint fk_musicians_artistid foreign key (artistid) references artists(artistid)
);
create table ratings(
	ratingid number not null,
	songid number not null,
	userid number not null,
	rating smallint,
	constraint pk_ratingid primary key (ratingid),
	constraint fk_ratings_userid foreign key (userid) references users(userid),
	constraint fk_ratings_songid foreign key (songid) references songs(songid)
);
create table playstamps (
	playstampid number not null,
	songid number not null,
	userid number not null,
	played timestamp not null,
	constraint pk_playstampid primary key (playstampid),
	constraint fk_playstamps_userid foreign key (userid) references users(userid),
	constraint fk_playstamps_songid foreign key (songid) references songs(songid)
);

CREATE SEQUENCE songid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE playlistid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE albumid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE userid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;

 
 CREATE SEQUENCE genreid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE commentid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE ratingid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 CREATE SEQUENCE playstampid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE artistid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE labelid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
 
 CREATE SEQUENCE musicianid_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE;
