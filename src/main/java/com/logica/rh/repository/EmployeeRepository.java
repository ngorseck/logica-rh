package com.logica.rh.repository;

import com.logica.rh.entity.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findById(Long id);
}