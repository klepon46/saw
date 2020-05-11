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

    public Nilai(int idKaryawan, float kriteria1, float kriteria2, float kriteria3, float kriteria4) {
        this.idKaryawan = idKaryawan;
        this.kriteria1 = kriteria1;
        this.kriteria2 = kriteria2;
        this.kriteria3 = kriteria3;
        this.kriteria4 = kriteria4;
    }

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
