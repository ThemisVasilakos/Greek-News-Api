package net.vasilakos.externalapi.repository;

import net.vasilakos.externalapi.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface EmailRepository extends MongoRepository<Email,Long> {

    ArrayList<Email> findAll();
    Email findByEmail(String email);
    void deleteByEmail(String email);
}
