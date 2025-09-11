#ALBUM_ARTIST table – showcase all albums in top 500 associated with each artist 
CREATE OR REPLACE VIEW View_Album_Artist_Top500 AS
SELECT 
  AA.ArtistID,
  ART.ArtistName,
  AA.AlbumID,
  AA.Album
FROM ALBUM_ARTIST AA
JOIN ARTIST ART ON AA.ArtistID = ART.ArtistID
WHERE 
  EXISTS (
    SELECT 1 
    FROM RANKING R 
    WHERE R.AlbumID = AA.AlbumID AND R.Rank <= 500
  );

#RANKING table – showcase all ranks in top 500 associated with each album 
CREATE OR REPLACE VIEW View_Album_Rankings_Top500 AS
SELECT 
  R.AlbumID,
  AA.Album,
  R.RankYear,
  R.Rank
FROM RANKING R
JOIN ALBUM_ARTIST AA ON R.AlbumID = AA.AlbumID
WHERE R.Rank <= 500
ORDER BY R.Rank ASC;


#This are scrips to the test code

SELECT * FROM View_Album_Artist_Top500;

SELECT * FROM View_Album_Rankings_Top500;