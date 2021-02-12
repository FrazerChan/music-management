package com.nextgate.assesment.rest;

import com.nextgate.assesment.datatypes.Song;
import com.nextgate.assesment.service.AuthService;
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
import org.springframework.http.HttpStatus;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import com.nextgate.assesment.models.Singer;
import com.nextgate.assesment.models.Album;
import com.nextgate.assesment.models.User;

import java.util.HashMap;

import com.nextgate.assesment.service.JwtUserDetailsService;
import com.nextgate.assesment.jwt.JwtTokenUtil;
import com.nextgate.assesment.models.JwtRequest;
import com.nextgate.assesment.models.JwtResponse;

/**
 * A REST controller for managing the music catalogue via the Music service
 *
 *
 * @author nextgate.employee
 */
@CrossOrigin
@RestController
public class MusicRestController {
    
    @Autowired
    private AuthService authService;

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
    public @ResponseBody ResponseEntity<Singer> addNewSinger (@RequestBody Singer singer) {
        Singer newSinger = musicSerivce.addSinger(singer);

        if (newSinger == null){
            return new ResponseEntity<>(newSinger, HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(newSinger);
        }
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
    public @ResponseBody ResponseEntity<Album> addNewAlbum (@RequestBody Album album) {
        Album newAlbum = musicSerivce.addAlbum(album);

        if (newAlbum == null){
            return new ResponseEntity<>(newAlbum, HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(newAlbum);
        }
    }

    /**
     * GET method to get all users
     * @return List of users
     */
    @GetMapping("users")
    public Iterable<User> users() {
        return authService.getAllUsers();
    }

    /**
     * POST method to add a new user 
     * @return new user object
     */
    @PostMapping(value="add_user")
    public @ResponseBody ResponseEntity<User> addNewUser (@RequestBody User user) {
        User newUser = authService.addUser(user);

        if (newUser == null){
            return new ResponseEntity<>(newUser, HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(newUser);
        }
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

    @Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

    /**
     * POST method to authenticate a user and return a JWT if valid
     */
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

    /**
     * Method to authenticate a user based on credentials or throw an exception
     */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
    
}
