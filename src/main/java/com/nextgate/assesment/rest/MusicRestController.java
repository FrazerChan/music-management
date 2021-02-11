package com.nextgate.assesment.rest;

import com.nextgate.assesment.datatypes.Song;
import com.nextgate.assesment.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

import com.nextgate.assesment.models.Singer;
import com.nextgate.assesment.models.Album;
import com.nextgate.assesment.models.User;

import java.util.HashMap;

/**
 * A REST controller for managing the music catalogue via the Music service
 *
 * TODO: Add more methods
 *
 * @author nextgate.employee
 */
@CrossOrigin
@RestController
public class MusicRestController {
    
    @Autowired
    private MusicService musicSerivce;

    /**
     * GET method to get all singers
     * @return List of singers
     */
    @GetMapping("singers")
    public Iterable<Singer> singers() {
        return musicSerivce.getAllSingers();
    }

    /**
     * POST method to add a new singer 
     * @return new singer object
     */
    @PostMapping(value="add_singer")
    public @ResponseBody Singer addNewSinger (@RequestBody Singer singer) {
        return musicSerivce.addSinger(singer);
    }

    /**
     * GET method to get all albums
     * @return List of albums
     */
    @GetMapping("albums")
    public Iterable<Album> albums() {
        return musicSerivce.getAllAlbums();
    }

    /**
     * POST method to add a new album 
     * @return new album object
     */
    @PostMapping(value="add_album")
    public @ResponseBody Album addNewAlbum (@RequestBody Album album) {
        return musicSerivce.addAlbum(album);
    }

    /**
     * GET method to get all users
     * @return List of users
     */
    @GetMapping("users")
    public Iterable<User> users() {
        return musicSerivce.getAllUsers();
    }

    /**
     * POST method to add a new user 
     * @return new user object
     */
    @PostMapping(value="add_user")
    public @ResponseBody User addNewUser (@RequestBody User user) {
        return musicSerivce.addUser(user);
    }
    
    /**
     * GET method to retrieve a song via an Id
     * @param songId the song Id
     * @return Song
     */
    @GetMapping("song/{songId}")
    public Song song(@PathVariable("songId") String songId) {
        return musicSerivce.getSongById(songId);
    }

    /**
     * GET method to retrieve all albums related to the query
     * @param query the string to match the albums too
     * @return List of albums
     */
    @GetMapping("searchAlbumsAndSingers/{query}")
    public ResponseEntity<HashMap<String, Object>> searchAlbumnsAndSingers(@PathVariable("query") String query) {
        HashMap<String, Object> result = musicSerivce.searchAlbumsAndSingers(query);
        return ResponseEntity.ok(result);
    }
    
}
