package br.edu.ifpb.pdist.back.repository;

import  br.edu.ifpb.pdist.back.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    
    Optional<User> findByUsername(String string);

    


}
