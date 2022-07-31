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
    public ResponseEntity<List<Student>> findAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        return studentService.addStudents(student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Object> updateStudents(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student){

        return studentService.updateStudents(studentId, student);
    }
}
