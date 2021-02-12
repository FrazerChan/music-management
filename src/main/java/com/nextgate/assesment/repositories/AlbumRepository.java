package com.nextgate.assesment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.nextgate.assesment.models.Album;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called albumRepository
// CRUD refers Create, Read, Update, Delete

public interface AlbumRepository extends CrudRepository<Album, Integer> {

    boolean existsBySingerAndAlbumAndYearAndCompany(String singer, String album, String year, String company);

    @Query("select u from Album u where u.album like %?1% or u.singer like %?2% order by u.album asc")
    List<Album> findByAlbumLikeOrSingerLikeOrderByAlbumAsc(String albumLike, String singerLike);

}