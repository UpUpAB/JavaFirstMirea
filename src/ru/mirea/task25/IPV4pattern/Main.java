package ru.mirea.task25.IPV4pattern;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String[] ipAddresses = {"192.168.1.1", "255.255.255.0", "1300.6.7.8", "abc.def.gha.bcd"};
        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        for (String ip : ipAddresses) {
            if (Pattern.matches(regex, ip)) {
                System.out.println(ip + " - правильный IP адрес");
            } else {
                System.out.println(ip + " - неправильный IP адрес");
            }
        }

        String[] expressions = {"(3+5)*9", "((3+5)*9", "((3+5))*9*4"};

        String regex2 = "^(\\([^()]*\\)|[\\w\\s\\*\\+-/]*)*$";


        for (String expr : expressions) {
            if (Pattern.matches(regex2, expr)) {
                System.out.println(expr + " - правильное выражение");
            } else {
                System.out.println(expr + " - неправильное выражение");
            }
        }
    }
}