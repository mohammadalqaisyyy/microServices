package com.services.mySqlDB;

import org.springframework.data.repository.CrudRepository;

public interface NumberDatabase extends CrudRepository<Numbers, Integer> {

}
