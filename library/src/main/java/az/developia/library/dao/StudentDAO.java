package az.developia.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.library.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
}
