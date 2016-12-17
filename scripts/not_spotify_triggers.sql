CREATE OR REPLACE trigger tri_songs
  before insert on songs      
  for each row 
begin  
  if :NEW.songid is null then
    select songid_seq.nextval into :NEW.songid from dual;
  end if;
end;
/


CREATE OR REPLACE trigger tri_playlists  
  before insert on playlists              
  for each row 
begin  
  if :NEW.playlistid is null then
    select playlistid_seq.nextval into :NEW.playlistid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_albums 
  before insert on albums              
  for each row 
begin  
  if :NEW.albumid is null then
    select albumid_seq.nextval into :NEW.albumid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_users  
  before insert on users              
  for each row 
begin  
  if :NEW.userid is null then
    select userid_seq.nextval into :NEW.userid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_genres
  before insert on genres              
  for each row 
begin  
  if :NEW.genreid is null then
    select genreid_seq.nextval into :NEW.genreid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_comments
  before insert on comments              
  for each row 
begin  
  if :NEW.commentid is null then
    select commentid_seq.nextval into :NEW.commentid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_ratings
  before insert on ratings              
  for each row 
begin  
  if :NEW.ratingid is null then
    select ratingid_seq.nextval into :NEW.ratingid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_playstamps
  before insert on playstamps              
  for each row 
begin  
  if :NEW.playstampid is null then
    select playstampid_seq.nextval into :NEW.playstampid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_artists
  before insert on artists              
  for each row 
begin  
  if :NEW.artistid is null then
    select artistid_seq.nextval into :NEW.artistid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_labels
  before insert on labels              
  for each row 
begin  
  if :NEW.labelid is null then
    select labelid_seq.nextval into :NEW.labelid from dual;
  end if;
end;
/

CREATE OR REPLACE trigger tri_musicians
  before insert on musicians 
  for each row 
begin  
  if :NEW.musicianid is null then
    select musicianid_seq.nextval into :NEW.musicianid from dual;
  end if;
end;
/