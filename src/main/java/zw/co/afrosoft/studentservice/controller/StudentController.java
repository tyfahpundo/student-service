package zw.co.afrosoft.studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.studentservice.domain.request.CreateStudentRequest;
import zw.co.afrosoft.studentservice.domain.response.StudentResponse;
import zw.co.afrosoft.studentservice.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        StudentResponse response = studentService.createStudent(createStudentRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id){
        StudentResponse response = studentService.getById(id);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        List<StudentResponse> response = studentService.getAllStudents();
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}
