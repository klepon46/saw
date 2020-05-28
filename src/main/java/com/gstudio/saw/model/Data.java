package com.gstudio.saw.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tbl_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"nik","nama"})
@ToString(of = {"nik","nama"})
public class Data {

    @Id
    @Column
    @NotNull(message = "NIK harus diisi")
    private Integer nik;

    @Column
    @NotNull(message = "Nama harus diisi")
    @NotEmpty(message = "Nama harus diisi")
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
