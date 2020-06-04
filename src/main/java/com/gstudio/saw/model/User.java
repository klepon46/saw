package com.gstudio.saw.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"username","password"})
@ToString(of = {"username","password"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NotNull(message = "username harus diisi")
    @NotEmpty(message = "username harus diisi")
    private String username;

    @Column
    @NotNull(message = "password harus diisi")
    @NotEmpty(message = "password harus diisi")
    private String password;

    @Column
    private String role;
}
