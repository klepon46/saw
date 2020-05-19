package com.gstudio.saw.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nik")
@ToString(of = "nama")
public class Data {

    @Id
    @Column
    private int nik;

    @Column
    private String nama;

    @Column
    private Float kriteria1;

    @Column
    private Float kriteria2;

    @Column
    private Float kriteria3;

    @Column
    private Float kriteria4;

    @Column
    private Integer kuartal;

    @Column
    private Integer year;

}
