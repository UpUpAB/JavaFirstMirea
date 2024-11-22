package ru.mirea.task17.first;

public class MVCPatterDemo {
    public static void main(String[] args) {


        Student model = retriveStudentFromDatabase();

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();

        controller.setStudentName("Misha");
        System.out.println("After updating, Student Details are as follows");
        controller.updateView();
    }
    private static Student retriveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Vova");
        student.setRollNo("1");
        return student;
    }

}

