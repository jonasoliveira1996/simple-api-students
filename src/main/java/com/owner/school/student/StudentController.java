package com.owner.school.student;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(Student student) {
        return studentService.getAllStudents(student);
    }

    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        return studentService.addStudents(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Object> updateStudents(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student){

        return studentService.updateStudents(studentId, student);
    }
}
