package com.mypack.repository;

import com.mypack.entity.Docter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Docter,Long> {

}
