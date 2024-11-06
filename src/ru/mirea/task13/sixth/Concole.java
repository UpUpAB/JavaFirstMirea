package ru.mirea.task13.sixth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Concole {
    private Scanner scanner;
    private List<String> list = new ArrayList<>();
    //private List<Character> firstSymbol = new ArrayList<>();
    //private List<Character> lastSymbol = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    public Concole(String name){
        getFile(name);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
            sb.append(" ");
        }
        StringTokenizer tokenizer = new StringTokenizer(sb.toString(), " \n\r\t,.;");
        while(tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        System.out.println(sb);
        checkForSame();
        System.out.println(list);
        sb.replace(0,sb.length(),"");
        makingFinalString();
        System.out.println(sb);
        System.out.println(list);


    }
    private void getFile(String name){
        try{
            scanner = new Scanner(new File(name));
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не было найдено, попробуйте указать полный путь до файла");
            System.out.println("Чтобы попробовать ещё раз перезапустите программу");
            System.exit(0);
        }
    }
    private void checkForSame(){
        for (int i =0;i<list.size();i++){
            for (int j = i+1;j< list.size();j++){
                if(list.get(i).equalsIgnoreCase(list.get(j))){
                    list.remove(j);
                }
            }
        }
    }
    /*private void fillFirstSymbolArr(){
        for (int i =0;i< list.size();i++){
            firstSymbol.add(list.get(i).toLowerCase().charAt(0));
        }
    }
    private void fillLastSymbolArr(){
        for (int i =0;i< list.size();i++){
            lastSymbol.add(list.get(i).toLowerCase().charAt(list.get(i).length()-1));
        }
    }
    private void makingFinalString(){
        fillFirstSymbolArr();
        fillLastSymbolArr();
        for(int i =0;i< list.size();i++){
            for(int j = i+1; j< list.size();j++){
                if (sb.isEmpty()){
                    if (lastSymbol.get(i)==firstSymbol.get(j)){
                        sb.append(list.get(i)).append(" ").append(list.get(j));
                        i++;
                        j++;
                    }
                } else {
                    if ()

                }
            }
        }
    }*/
    private void searchForBegining(){
        boolean goodStr = false;
        for (int i = 0;i< list.size();i++){
            for (int j = i + 1;j< list.size();j++){
                if(list.get(i).charAt(list.get(i).length()-1)==list.get(j).charAt(0)){
                    goodStr = true;
                    sb.append(list.get(i)).append(" ").append(list.get(j));
                    list.remove(j);
                    list.remove(i);

                    break;
                }
            }
            if (goodStr) break;
        }
    }
    private void makingFinalString(){
        searchForBegining();
        for(int i =0;i< list.size();i++){
            for (int j =0;j<list.size();j++){
                if(sb.charAt(sb.length()-1)==list.get(j).charAt(0)) {
                    sb.append(" ").append(list.get(j));
                    list.remove(j);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Concole concole = new Concole(args[0]);
    }
}
// в cd src: java ru/mirea/task13/sixth/Concole /Users/egor/IdeaProjects/JavaFirstMirea/src/ru/mirea/task13/sixth/words.txt
//javac ru/mirea/task13/sixth/Concole.java