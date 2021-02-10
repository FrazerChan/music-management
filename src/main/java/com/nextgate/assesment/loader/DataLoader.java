package com.nextgate.assesment.loader;

import com.nextgate.assesment.models.Album;
import com.nextgate.assesment.models.Singer;
import com.nextgate.assesment.models.User;
import com.nextgate.assesment.repositories.AlbumRepository;
import com.nextgate.assesment.repositories.SingerRepository;
import com.nextgate.assesment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.Example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private SingerRepository singerRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private UserRepository userRepository;

    private String filepath = "data/ng_music_data.txt";

    public void run(ApplicationArguments args) {
        // Load data from data file into database
        loadData();
    }

    private void loadData() {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			String line = reader.readLine();
			while (line != null) {
                String[] splitLine = line.split("\\|");

                if(splitLine[0].equals("A")){
                    parseAlbum(splitLine);
                }else if(splitLine[0].equals("S")){
                    parseSinger(splitLine);
                }else if(splitLine[0].equals("U")){
                    parseUser(splitLine);
                }else{
                    // Invalid
                }

                // read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void parseAlbum (String[] albumDetails){
        Album newAlbum = new Album(albumDetails[1].trim(), albumDetails[2].trim(), albumDetails[3].trim(), albumDetails[4].trim());
        if (albumRepository.existsBySingerAndAlbumAndYearAndCompany(albumDetails[1].trim(), albumDetails[2].trim(), albumDetails[3].trim(), albumDetails[4].trim())){
            System.out.println("Album already exists");
        }else{
            albumRepository.save(newAlbum);
        }
    }
    
    private void parseSinger (String[] singerDetails){
        Singer newSinger = new Singer(singerDetails[1].trim(), singerDetails[2].trim(), singerDetails[3].trim(), singerDetails[4].trim());
        if (singerRepository.existsByNameAndDobAndSexAndCompany(singerDetails[1].trim(), singerDetails[2].trim(), singerDetails[3].trim(), singerDetails[4].trim())){
            System.out.println("Singer already exists");
        }else{
            singerRepository.save(newSinger);
        }
    }
    
    private void parseUser (String[] userDetails){
        User newUser = new User(userDetails[1].trim(), userDetails[2].trim());
        if (userRepository.existsByUser(userDetails[1].trim())){
            System.out.println("User already exists");
        }else{
            userRepository.save(newUser);
        }
    }
}