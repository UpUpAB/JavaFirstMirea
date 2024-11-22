package ru.mirea.task17.second;

public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }
    private String getEmployeeName(){
        return model.getName();
    }
    public void setEmployeeName(String name){
        model.setName(name);
    }

    public String getEmployeeProfession(){
        return model.getProfession();
    }
    public void setEmployeeProfession(String profession){
        model.setProfession(profession);
    }
    public void updateView(){
        view.printViewDetails(model.getName(),model.getProfession());
    }
}
