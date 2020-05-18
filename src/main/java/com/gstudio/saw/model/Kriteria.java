package com.gstudio.saw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tbl_mst_kriteria")
public class Kriteria {

    @Id
    private int id;

    @Column
    private String kriteria1;

    @Column
    private String kriteria2;

    @Column
    private String kriteria3;

    @Column
    private String kriteria4;

}
