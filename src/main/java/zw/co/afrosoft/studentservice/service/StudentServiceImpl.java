package zw.co.afrosoft.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.studentservice.domain.Student;
import zw.co.afrosoft.studentservice.domain.request.CreateStudentRequest;
import zw.co.afrosoft.studentservice.domain.response.StudentResponse;
import zw.co.afrosoft.studentservice.feignclients.AddressFeignClient;
import zw.co.afrosoft.studentservice.persistence.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repo;

    @Autowired
    private AddressFeignClient addressFeignClient;
    @Autowired
    private CommonService commonService;

    @Override
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());

        student.setAddressId(createStudentRequest.getAddressId());
        student = repo.save(student);

        StudentResponse studentResponse = new StudentResponse(student);

        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse;
    }

    @Override
    public StudentResponse getById(Long id) {
        Student student = repo.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> responseList = new ArrayList<>();
        List<Student> studentList = repo.findAll();

        studentList
                .stream()
                .forEach(student-> responseList.add(new StudentResponse(student)));

        return responseList;
    }
}
