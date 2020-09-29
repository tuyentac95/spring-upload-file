package controller;

import model.Student;
import model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IStudentService;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private Environment environment;

    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/students/list");
        mav.addObject("students", studentService.findAll());
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("/students/edit");
        mav.addObject("student",studentService.findById(id));
        return mav;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("/students/edit");
        modelAndView.addObject("student",student);
        studentService.update(student);
        modelAndView.addObject("mess","Done");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/students/create");
        modelAndView.addObject("studentForm",new StudentForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute("studentForm") StudentForm studentForm){
        Student student = new Student(studentForm.getName(),studentForm.getAddress());
        MultipartFile file = studentForm.getImage();
        String image = file.getOriginalFilename();
        student.setImageID(image);
        String fileUpload = environment.getProperty("file_upload");
        try{
            FileCopyUtils.copy(file.getBytes(),new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentService.saveStudent(student);
        return new ModelAndView("/students/create","student",new StudentForm());
    }
}
