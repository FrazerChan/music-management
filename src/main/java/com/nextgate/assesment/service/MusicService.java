package com.nextgate.assesment.service;

import com.nextgate.assesment.datatypes.Song;
import org.springframework.stereotype.Service;
import com.nextgate.assesment.models.Singer;
import com.nextgate.assesment.repositories.SingerRepository;
import com.nextgate.assesment.models.Album;
import com.nextgate.assesment.repositories.AlbumRepository;
import com.nextgate.assesment.models.User;
import com.nextgate.assesment.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieve a song by Id
     *
     * @param Id the song Id
     * @return Song
     */
    public Song getSongById(String Id) {
        return new Song("Test Song");
    }

    public Iterable<Singer> getAllSingers() {
        return singerRepository.findAll();
    }

    public Singer addSinger(Singer singer){
        if (singerRepository.existsByNameAndDobAndSexAndCompany(singer.getName(), singer.getDob(), singer.getSex(), singer.getCompany())){
            return null;
        }else{
            return singerRepository.save(singer);
        }
    }

    public Iterable<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album addAlbum(Album album){
        if (albumRepository.existsBySingerAndAlbumAndYearAndCompany(album.getSinger(), album.getAlbum(), album.getYear(), album.getCompany())){
            return null;
        }else{
            return albumRepository.save(album);
        }
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user){
        if (userRepository.existsByUser(user.getUser())){
            return null;
        }else{
            return userRepository.save(user);
        }
    }

    public HashMap<String, Object> searchAlbumsAndSingers(String query){
        Iterable<Album> albums = albumRepository.findByAlbumLikeOrSingerLikeOrderByAlbumAsc(query, query);
        Iterable<Singer> singers = singerRepository.findByNameLikeOrderByNameAsc(query);

        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("albums", albums);
        hmap.put("singers", singers);

        return hmap;
    }

}
