package com.gstudio.saw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
@Table(name = "tbl_person")
public class Person {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @JsonManagedReference
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Nilai> nilais;

}
