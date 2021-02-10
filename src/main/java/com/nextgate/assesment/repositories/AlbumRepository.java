package com.nextgate.assesment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nextgate.assesment.models.Album;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface AlbumRepository extends CrudRepository<Album, Integer> {

    boolean existsBySingerAndAlbumAndYearAndCompany(String singer, String album, String year, String company);

}