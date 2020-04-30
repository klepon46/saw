package com.gstudio.saw.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
@Table(name = "tbl_nilai")
public class Nilai {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_karyawan")
    private int idKaryawan;

    @Column
    private float kriteria1;

    @Column
    private float kriteria2;

    @Column
    private float kriteria3;

    @Column
    private float kriteria4;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

}
