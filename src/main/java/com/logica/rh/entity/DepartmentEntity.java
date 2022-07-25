package com.logica.rh.entity;

import com.logica.rh.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity implements Serializable {

    @Id
    private String name;
    @OneToOne
    private EmployeeEntity responsable;

}