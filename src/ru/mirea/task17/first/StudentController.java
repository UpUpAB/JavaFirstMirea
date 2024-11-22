package ru.mirea.task17.first;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void setStudentRollNo(String rollNo) {
        this.model.setRollNo(rollNo);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentName(String name) {
        this.model.setName(name);
    }



    public void updateView(){
        view.printStudentDetails(model.getRollNo(), model.getName());
    }
}
