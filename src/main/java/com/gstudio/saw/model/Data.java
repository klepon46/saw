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
    private float kriteria1;

    @Column
    private float kriteria2;

    @Column
    private float kriteria3;

    @Column
    private float kriteria4;

    @Column
    @Temporal(TemporalType.DATE)
    private Date periode;

}
