package ru.mirea.task4.seasons;

public class SeasonEnum {
    public enum Seasons {
        SUMMER(20),
        AUTEMN(5),
        WINTER(-15),
        SPRING(10)
        ;

        private final int seasonsCode;
        Seasons (int seasonsCode){
            this.seasonsCode=seasonsCode;
        }

        public int getSeasonsCode() {
            return seasonsCode;
        }

        public void loveSeason(Seasons seasons){
            switch (seasons){
                case SUMMER:
                    System.out.println("I love Summer");
                case AUTEMN:
                    System.out.println("I love Autemn");
                case WINTER:
                    System.out.println("I love Winter");
                case SPRING:
                    System.out.println("I love Spring");

            }
        }
        public String getDescription(){
            switch (seasonsCode){
                case 20:
                    return  "Тёплое время года";
                case 5:
                    return  "Мокрое и прохладное время года";
                case -15:
                    return  "Холодное время года";
                case 10:
                    return  "Счастливое время года";

            }
            return "Промазал";
        }
    }

    public static void main(String[] args) {
        for (Seasons seasons:Seasons.values()){
            System.out.println(seasons.name());
            Seasons sn = Seasons.valueOf(seasons.name());
            sn.loveSeason(sn);
            System.out.print("Средняя температура в этом сезоне: ");
            System.out.println(seasons.getSeasonsCode());
            System.out.println(seasons.getDescription());


        }
        Seasons season = Seasons.SPRING;
        season.loveSeason(season);
    }
}
