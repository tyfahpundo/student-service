package zw.co.afrosoft.studentservice.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.studentservice.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
