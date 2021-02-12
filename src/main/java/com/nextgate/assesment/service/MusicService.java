package com.nextgate.assesment.service;

import com.nextgate.assesment.datatypes.Song;
import org.springframework.stereotype.Service;
import com.nextgate.assesment.models.Singer;
import com.nextgate.assesment.repositories.SingerRepository;
import com.nextgate.assesment.models.Album;
import com.nextgate.assesment.repositories.AlbumRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * The Music service that will handle the CRUD operations
 *
 * TODO: Add more methods & link to a SQL database
 *
 * @author nextgate.employee
 */
@Service
public class MusicService {

    @Autowired
    private SingerRepository singerRepository;

    @Autowired
    private AlbumRepository albumRepository;

    /**
     * Retrieve a song by Id
     *
     * @param Id the song Id
     * @return Song
     */
    public Song getSongById(String Id) {
        return new Song("Test Song");
    }

    /**
     * Method to get all singers in the database
     * @return All singers in the database
     */
    public Iterable<Singer> getAllSingers() {
        return singerRepository.findAll();
    }

    /**
     * Method to add a new singer to the database
     * @param singer the new singer
     * @return The new singer if added, null if singer already exists
     */
    public Singer addSinger(Singer singer){
        if (singerRepository.existsByNameAndDobAndSexAndCompany(singer.getName(), singer.getDob(), singer.getSex(), singer.getCompany())){
            return null;
        }else{
            return singerRepository.save(singer);
        }
    }

    /**
     * Method to get all albums in the database
     * @return All albums in the database
     */
    public Iterable<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    /**
     * Method to add a new album to the database
     * @param album the new album
     * @return The new album if added, null if album already exists
     */
    public Album addAlbum(Album album){
        if (albumRepository.existsBySingerAndAlbumAndYearAndCompany(album.getSinger(), album.getAlbum(), album.getYear(), album.getCompany())){
            return null;
        }else{
            return albumRepository.save(album);
        }
    }

    /**
     * Method to get all singers and albums that match the query either as part of the singers name or the albums name
     * @param query the query string to match
     * @return A hash map containing two lists, one of albums and another of singers
     */
    public HashMap<String, Object> searchAlbumsAndSingers(String query){
        Iterable<Album> albums = albumRepository.findByAlbumLikeOrSingerLikeOrderByAlbumAsc(query, query);
        Iterable<Singer> singers = singerRepository.findByNameLikeOrderByNameAsc(query);

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("albums", albums);
        hmap.put("singers", singers);

        return hmap;
    }

}
