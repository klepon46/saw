package com.gstudio.saw.repository;

import com.gstudio.saw.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
