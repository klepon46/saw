package com.gstudio.saw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NilaiDto {

    public NilaiDto(String nama, float kriteria1, float kriteria2, float kriteria3, float kriteria4) {
        this.nama = nama;
        this.kriteria1 = kriteria1;
        this.kriteria2 = kriteria2;
        this.kriteria3 = kriteria3;
        this.kriteria4 = kriteria4;
    }

    private String nama;
    private float kriteria1;
    private float kriteria2;
    private float kriteria3;
    private float kriteria4;
    private float total;

}
