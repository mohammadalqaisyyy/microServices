package com.services.mangoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnalysisDatabase extends MongoRepository<AnalysisData, String> {
}
