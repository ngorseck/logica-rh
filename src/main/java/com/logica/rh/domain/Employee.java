package com.logica.rh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Enumeration gender;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String adress;
}
