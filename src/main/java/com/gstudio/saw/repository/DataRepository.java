package com.gstudio.saw.repository;

import com.gstudio.saw.model.Data;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DataRepository extends CrudRepository<Data, Integer> {

    Optional<List<Data>> findByKuartalAndYear(int kuartal, int year);
    Optional<List<Data>> findByYear(int year);
    Optional<List<Data>> findByKuartal(int year);

}
