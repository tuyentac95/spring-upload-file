package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    private static ArrayList<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1L,"Tuyen","Ha Noi","tuyen.jpg"));
        students.add(new Student(2L,"Mai","Nam Dinh","mai.png"));
        students.add(new Student(3L,"Linh","Yen Bai","linh.png"));
    }

    @Override
    public List<Student> findAll(){
        return students;
    }

    @Override
    public void saveStudent(Student student){
        Long stt = students.size() + 1L;
        student.setId(stt);
        students.add(student);
    }

    @Override
    public Student findById(Long id) {
        for (Student student : students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student student) {
        for (Student student1 : students){
            if(student1.getId().equals(student.getId())){
                student.setName(student.getName());
                student.setAddress(student.getAddress());
                student.setImageID(student.getImageID());
            }
        }
    }

    @Override
    public void remove(Long id) {

    }
}
