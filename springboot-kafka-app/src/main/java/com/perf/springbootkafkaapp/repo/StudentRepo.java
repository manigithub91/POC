package com.perf.springbootkafkaapp.repo;


import com.perf.springbootkafkaapp.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {



}
