package ru.mirea.task19.second;

public class LabClass implements LabClassUI{
    public LabClass() {
        setGroup();
        sorting();
        findingStudent("ASD");
    }

    @Override
    public void findingStudent(String name) {
        boolean match = false;
        for(int i=0;i<group.size();i++){
            if(group.get(i).getFullName().equals(name)){
                match = true;
                System.out.println(group.get(i));
            }
        }
        if(!match) throw new StudentNotFoundExeption();
    }

    @Override
    public void setGroup() {
        group.add(new Student("Zyablicov A.V.",5));
        group.add(new Student("Vorobushkin D.I.",3));
        group.add(new Student("Russki E.A.",4.7));
        group.add(new Student("Selov A.V.",3.5));
        //group.add(new Student("   ",5));
        System.out.println(group);
    }

    @Override
    public void sorting() {
        group.sort(Student::compareTo);
        System.out.println(group);
    }

    public static void main(String[] args) {
        new LabClass();
    }
}
