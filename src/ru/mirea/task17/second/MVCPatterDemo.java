package ru.mirea.task17.second;

public class MVCPatterDemo {
    public static void main(String[] args) {


        Employee model = retriveEmployeeFromDatabase();

        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);
        controller.updateView();

        controller.setEmployeeName("Misha");
        System.out.println("After updating, Employee Details are as follows");
        controller.updateView();
    }
    private static Employee retriveEmployeeFromDatabase(){
        Employee employee = new Employee();
        employee.setName("Vova");
        employee.setProfession("Programmer");
        return employee;
    }
}
