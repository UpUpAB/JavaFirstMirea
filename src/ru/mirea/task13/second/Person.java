package ru.mirea.task13.second;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private StringBuffer  representation;

    public Person(String surname) {
        this.surname = surname;
        represent();
    }

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        represent();
    }

    private void represent(){
        representation = new StringBuffer(surname);
        if (name==null){
            if(patronymic!=null){
                representation.append(" "+patronymic.charAt(0)+".");
            }
        } else {
            if(patronymic!=null){
                representation.append(" "+name.toUpperCase().charAt(0)+"."+patronymic.toUpperCase().charAt(0)+".");
            } else {
                representation.append(" "+name.toUpperCase().charAt(0)+".");
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "representation=" + representation +
                '}';
    }

    public static void main(String[] args) {
        String surname = "Putin";
        String name = "Vladimir";
        String patronymic = "Vladimirovich";
        Person person = new Person(surname,name,patronymic);
        System.out.println(person.toString());
    }
}
