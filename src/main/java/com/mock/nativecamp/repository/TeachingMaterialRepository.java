package com.mock.nativecamp.repository;

import com.mock.nativecamp.model.TeachingMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingMaterialRepository extends MongoRepository<TeachingMaterial, String> {
}
