package zw.co.afrosoft.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import zw.co.afrosoft.studentservice.domain.Student;
import zw.co.afrosoft.studentservice.domain.request.CreateStudentRequest;
import zw.co.afrosoft.studentservice.domain.response.AddressResponse;
import zw.co.afrosoft.studentservice.domain.response.StudentResponse;
import zw.co.afrosoft.studentservice.persistence.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repo;

    @Autowired
    private WebClient webClient;

    @Override
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());

        student.setAddressId(createStudentRequest.getAddressId());
        student = repo.save(student);

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.getAddressResponse(getAddressById(student.getAddressId()));
        return studentResponse;
    }

    @Override
    public StudentResponse getById(Long id) {
        Student student = repo.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.getAddressResponse(getAddressById(student.getAddressId()));
        return new StudentResponse(student);
    }

    public AddressResponse getAddressById(Long addressId){
        Mono<AddressResponse> addressResponse =
                webClient.get().uri("/getById" + addressId)
                .retrieve().bodyToMono(AddressResponse.class);

        return addressResponse.block();
    }
}
