package com.nextgate.assesment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nextgate.assesment.models.Singer;

// This will be AUTO IMPLEMENTED by Spring into a Bean called singerRepository
// CRUD refers Create, Read, Update, Delete

public interface SingerRepository extends CrudRepository<Singer, Integer> {

    boolean existsByNameAndDobAndSexAndCompany(String name, String dob, String sex, String company);

}