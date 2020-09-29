package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void saveStudent(Student student);

    Student findById(Long id);

    void update(Student student);

    void remove(Long id);
}
