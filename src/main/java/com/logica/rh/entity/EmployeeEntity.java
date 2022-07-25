package com.logica.rh.entity;

import com.logica.rh.domain.Enumeration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Enumeration gender;
    private String country;
    private String city;
    private String adress;

}
