package com.mock.nativecamp.repository;

import com.mock.nativecamp.model.Teachers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends MongoRepository<Teachers, String>{
    Teachers findByUserId(String id);
}
