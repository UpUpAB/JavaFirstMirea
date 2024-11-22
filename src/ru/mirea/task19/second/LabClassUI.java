package ru.mirea.task19.second;

import java.util.ArrayList;
import java.util.List;

public interface LabClassUI {
    List<Student> group = new ArrayList<>();
    public void findingStudent(String name);
    public void setGroup();
    public void sorting();
}
