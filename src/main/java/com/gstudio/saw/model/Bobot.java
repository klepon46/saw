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
@Table(name = "tbl_bobot")
public class Bobot {

    @Id
    @Column(name = "bobot_1")
    private float bobot1;

    @Column(name = "bobot_2")
    private float bobot2;

    @Column(name = "bobot_3")
    private float bobot3;

    @Column(name = "bobot_4")
    private float bobot4;


}
