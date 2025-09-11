# Query 1; This query returns information on which albums had a lot of weeks on the buildboard and also were ranked very highly in the roling stones top 100
#The second query shows the opposite, albums that were rakned high on the buillboard but were not ranked as well.
# this could be usefull because it shows the correlarion between weeks on the billboard and roling stones rank
select ALBUM.Album, ALBUM.Wks_Billboard, RANKING.Rank, RANKING.RankYear
from ALBUM join RANKING on RANKING.AlbumID= ALBUM.AlbumID
where Wks_Billboard > 200 and Rank<100 and RankYear = 2003;

select ALBUM.Album, ALBUM.Wks_Billboard, RANKING.Rank, RANKING.RankYear
from ALBUM join RANKING on RANKING.AlbumID= ALBUM.AlbumID
where Wks_Billboard > 200 and Rank>100 and RankYear = 2003;


#Query 2; this query shows how many total albums each artist had in the rolingtones top 500 list between 2003, 2020 and 2012
#It is ordered by decending order so it is easy to see who has the most albums on the list
select ARTIST.ArtistName, count(ALBUM.Album) as AlbumCount
from ALBUM 
join ALBUM_ARTIST on ALBUM_ARTIST.AlbumID = ALBUM.AlbumID
join ARTIST on ALBUM_ARTIST.ArtistID = ARTIST.ArtistID
group by ARTIST.ArtistName
order by AlbumCount Desc;

#Query 3; This query is similer to the fisr one and it shos the corrilation between spotify popularity and weeks on the billboard. 
select Spotify_Popularity, Wks_Billboard, Album
from ALBUM
where Spotify_Popularity >50 and Wks_Billboard<10;

select Spotify_Popularity, Wks_Billboard, Album
from ALBUM
where Spotify_Popularity <50 and Wks_Billboard>200;

#query 4; This query finds the average member count of music groups with albums in the top 500 for each year. 
#This query could be usefull because it shows how trends in the music industry have changed.
#from 1965-1980 there were a lot of bigger bands and a lot of solo artists in the others. 
select ALBUM.Release_Year,AVG(ARTIST.Member_Count)
from ALBUM
join ALBUM_ARTIST on ALBUM_ARTIST.AlbumID = ALBUM.AlbumID
join ARTIST on ALBUM_ARTIST.ArtistID = ARTIST.ArtistID
join RANKING on RANKING.AlbumID= ALBUM.AlbumID
where RankYear = 2003
group by ALBUM.Release_Year;

#query 5; This query shows only jazz albums in the top 500 albums
#It can easily be changed to look at another genere which could be usefull if you just want to see albums of a secific genre. 
Select ALBUM.Album, ARTIST.ArtistName
from ALBUM
join ALBUM_ARTIST on ALBUM_ARTIST.AlbumID = ALBUM.AlbumID
join ARTIST on ALBUM_ARTIST.ArtistID = ARTIST.ArtistID
	where ALBUM.AlbumID in 
    (select ALBUM_GENRE.AlbumID
    From ALBUM_GENRE
    where Genre ='Jazz');
    

