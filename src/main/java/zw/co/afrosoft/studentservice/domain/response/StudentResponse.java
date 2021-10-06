package zw.co.afrosoft.studentservice.domain.response;

import zw.co.afrosoft.studentservice.domain.Student;

public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;

    public StudentResponse(Student student){
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }
}
