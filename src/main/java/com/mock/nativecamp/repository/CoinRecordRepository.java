package com.mock.nativecamp.repository;

import com.mock.nativecamp.model.CoinRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRecordRepository extends MongoRepository<CoinRecord, String> {
}
