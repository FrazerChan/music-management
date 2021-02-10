package com.nextgate.assesment.service;

import com.nextgate.assesment.datatypes.Song;
import org.springframework.stereotype.Service;
import com.nextgate.assesment.models.Singer;
import com.nextgate.assesment.repositories.SingerRepository;
import com.nextgate.assesment.models.Album;
import com.nextgate.assesment.repositories.AlbumRepository;
import com.nextgate.assesment.models.User;
import com.nextgate.assesment.repositories.UserRepository;
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
        return singerRepository.save(singer);
    }

    public Iterable<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

}
