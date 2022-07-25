package com.logica.rh.repository;

import com.logica.rh.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, String> {

    Optional<DepartmentEntity> findByNameIgnoreCase(String name);

}
