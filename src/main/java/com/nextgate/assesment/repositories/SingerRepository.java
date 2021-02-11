package com.nextgate.assesment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.nextgate.assesment.models.Singer;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called singerRepository
// CRUD refers Create, Read, Update, Delete

public interface SingerRepository extends CrudRepository<Singer, Integer> {

    boolean existsByNameAndDobAndSexAndCompany(String name, String dob, String sex, String company);

    @Query("select u from Singer u where u.name like %?1%")
    List<Singer> findByNameLike(String nameLike);

}