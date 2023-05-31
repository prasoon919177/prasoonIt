package in.prasoon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.prasoon.entity.StudentEntity1; 



public interface StudentRepository1 extends JpaRepository<StudentEntity1, Integer>
{

}
