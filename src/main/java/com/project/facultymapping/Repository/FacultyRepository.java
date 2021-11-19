package com.project.facultymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.facultymapping.Model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long>{

}
