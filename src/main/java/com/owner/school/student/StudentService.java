package com.owner.school.student;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private StudentRepository studentRepository;

    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
    }

    public ResponseEntity<Object> addStudents(Student student) {
        Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());

        if (existsEmail) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("That email " + student.getEmail() + " is taken. Try another.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }

    public ResponseEntity<String> deleteStudent(Long id){

        if (!studentRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students with id " + id + " does not exists. Try another.");
        }

        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student delete successfully");

    }

    public ResponseEntity<Object> updateStudents(Long id, Student student) {

        if (!studentRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students with id " + id + " does not exists. Try another.");
        }

        student.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(student));
    }
}
