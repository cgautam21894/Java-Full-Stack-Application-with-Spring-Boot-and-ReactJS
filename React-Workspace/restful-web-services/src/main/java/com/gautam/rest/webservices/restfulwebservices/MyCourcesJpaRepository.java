package com.gautam.rest.webservices.restfulwebservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyCourcesJpaRepository extends JpaRepository<MyCourses, Long> {

    List<MyCourses> findByUsername(String username);
}
