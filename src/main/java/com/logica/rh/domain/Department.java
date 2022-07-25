package com.logica.rh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    @NotNull
    private String name;
    @NotNull
    private Employee responsable;
}
