package com.project.facultymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.facultymapping.Model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>{

}
