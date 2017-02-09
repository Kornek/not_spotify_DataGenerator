/*Drop check constraints*/
alter table comments drop constraint chk_songid_ablumid;

/*Drop all fk constraints*/
alter table songs drop constraint fk_songs_genreid;
alter table songs drop constraint fk_songs_albumid;
alter table songs drop constraint fk_songs_artistid;
alter table albums drop constraint fk_albums_artistid;
alter table albums drop constraint fk_albums_labelid;
alter table playlists drop constraint fk_playlists_userid;
alter table playlistsongs drop constraint fk_playlistsongs_playlistid;
alter table playlistsongs drop constraint fk_playlistsongs_songid;
alter table comments drop constraint fk_comments_albumid;
alter table comments drop constraint fk_comments_songid;
alter table comments drop constraint fk_comments_userid;
alter table musicians drop constraint fk_musicians_artistid;
alter table ratings drop constraint fk_ratings_userid;
alter table ratings drop constraint fk_ratings_songid;
alter table playstamps drop constraint fk_playstamps_userid;
alter table playstamps drop constraint fk_playstamps_songid;

/*Drop all pk constraints*/
alter table genres drop constraint pk_genreid;
alter table labels drop constraint pk_labelid;
alter table artists drop constraint pk_artistid;
alter table albums drop constraint pk_albumid;
alter table playlists drop constraint pk_playlistid;
alter table songs drop constraint pk_songid;
alter table users drop constraint pk_userid;
alter table playlistsongs drop constraint pk_playlistsongid;
alter table comments drop constraint pk_commentid;
alter table musicians drop constraint pk_musicianid;
alter table ratings drop constraint pk_ratingid;
alter table playstamps drop constraint pk_playstampid;

/*Drop all tables*/
drop table genres;
drop table labels;
drop table artists;
drop table albums;
drop table playlistsongs;
drop table songs;
drop table users;
drop table playlists;
drop table comments;  
drop table musicians;
drop table ratings;
drop table playstamps;

/*Drop all sequences*/
drop sequence songid_seq;
drop sequence playlistid_seq;
drop sequence albumid_seq;
drop sequence userid_seq;
drop sequence genreid_seq;
drop sequence commentid_seq;
drop sequence ratingid_seq;
drop sequence playstampid_seq;
drop sequence artistid_seq;
drop sequence labelid_seq;
drop sequence musicianid_seq;
