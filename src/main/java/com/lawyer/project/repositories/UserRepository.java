package com.lawyer.project.repositories;

import java.util.List;
import java.util.Optional;

import com.lawyer.project.models.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    List<Users> findAll();

    Optional<Users> findById(Long id);

}