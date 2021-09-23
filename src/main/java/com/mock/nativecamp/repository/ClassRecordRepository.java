package com.mock.nativecamp.repository;

import com.mock.nativecamp.model.ClassRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRecordRepository extends MongoRepository<ClassRecord, String> {
}
