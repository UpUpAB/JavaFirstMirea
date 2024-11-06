package ru.mirea.task13.fourth;

public class Phonenumber {
    private String number;
    private StringBuffer sb;



    public Phonenumber(String number) {
        this.number = number;

        redo();
    }
    private void redo(){
        sb = new StringBuffer(number);
        if (number.startsWith("+")) sb.deleteCharAt(0);
        number = "+<"+sb.substring(0,sb.length()-10)+"><"+sb.substring(sb.length()-10,sb.length()-7)+">-<"+sb.substring(sb.length()-7,sb.length()-4)+">-<"+sb.substring(sb.length()-4,sb.length())+">";
    }

    @Override
    public String toString() {
        return "Phonenumber{" +
                "number='" + number + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String number = "+79172641324";
        Phonenumber pn = new Phonenumber(number);
        System.out.println(pn.toString());
    }
}
