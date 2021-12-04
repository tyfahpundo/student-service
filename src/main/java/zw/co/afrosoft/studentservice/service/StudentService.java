package zw.co.afrosoft.studentservice.service;

import zw.co.afrosoft.studentservice.domain.request.CreateStudentRequest;
import zw.co.afrosoft.studentservice.domain.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(CreateStudentRequest createStudentRequest);

    StudentResponse getById(Long id);

    List<StudentResponse> getAllStudents();
}
