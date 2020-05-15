package com.gstudio.saw.controller;

import com.gstudio.saw.dto.NilaiDto;
import com.gstudio.saw.model.Data;
import com.gstudio.saw.model.Nilai;
import com.gstudio.saw.model.Person;
import com.gstudio.saw.repository.DataRepository;
import com.gstudio.saw.repository.NilaiRepository;
import com.gstudio.saw.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ListData")
public class ListDataRestController {

    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private NilaiRepository nilaiRepository;

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/getAllData")
    public List<Data> getAllDAta(){
        return (List<Data>) dataRepository.findAll();
    }

    @GetMapping("/getAllNilai")
    public List<NilaiDto>  getAllNilai(){
        List<Nilai> nilais = (List<Nilai>) nilaiRepository.findAll();

        List<NilaiDto> dtos = nilais.stream().map(item -> {
            NilaiDto dto = new NilaiDto(item.getPerson().getNama(),
                    item.getKriteria1(),item.getKriteria2(), item.getKriteria3(), item.getKriteria4());
            return dto;
        }).collect(Collectors.toList()) ;
        return dtos;
    }

    @GetMapping("/getDataByNik")
    public ResponseEntity<Data> getDataByNik(int nik){
        Optional<Data> data = dataRepository.findById(nik);
        return new ResponseEntity<>(data.get(), HttpStatus.OK);
    }

    @PostMapping("/deleteData")
    public ResponseEntity<Integer> deleteData(int nik){
        dataRepository.deleteById(nik);
        return new ResponseEntity<>(nik, HttpStatus.OK);
    }
}
