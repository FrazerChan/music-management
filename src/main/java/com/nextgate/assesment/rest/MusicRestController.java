package com.nextgate.assesment.rest;

import com.nextgate.assesment.datatypes.Song;
import com.nextgate.assesment.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nextgate.assesment.models.Singer;
import com.nextgate.assesment.models.Album;
import com.nextgate.assesment.models.User;

/**
 * A REST controller for managing the music catalogue via the Music service
 *
 * TODO: Add more methods
 *
 * @author nextgate.employee
 */
@RestController
public class MusicRestController {
    
    @Autowired
    private MusicService musicSerivce;

    @GetMapping("singers")
    public Iterable<Singer> singers() {
        return musicSerivce.getAllSingers();
    }

    @PostMapping(value="add_singer")
    public @ResponseBody Singer addNewSinger (@RequestBody Singer singer) {
        return musicSerivce.addSinger(singer);
    }

    @GetMapping("albums")
    public Iterable<Album> albums() {
        return musicSerivce.getAllAlbums();
    }

    @PostMapping(value="add_album")
    public @ResponseBody Album addNewAlbum (@RequestBody Album album) {
        return musicSerivce.addAlbum(album);
    }

    @GetMapping("users")
    public Iterable<User> users() {
        return musicSerivce.getAllUsers();
    }

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
    
}
