package ru.mirea.task13.third;

import java.util.StringTokenizer;

public class Addresses {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String corp;
    private String apartment;

    public Addresses(String country, String region, String city, String street, String house, String corp, String apartment) {
        this.country = country.trim();
        this.region = region.trim();
        this.city = city.trim();
        this.street = street.trim();
        this.house = house.trim();
        this.corp = corp.trim();
        this.apartment = apartment.trim();
    }

    public static Addresses Split(String addressString) {
        String[] parts = addressString.split(",");
        return new Addresses(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }

    public static Addresses Tokenizer(String addressString) {
        StringTokenizer tokenizer = new StringTokenizer(addressString, " ,.;");
        String[] parts = new String[7];
        for (int i = 0; i < parts.length && tokenizer.hasMoreTokens(); i++) {
            parts[i] = tokenizer.nextToken();
        }
        return new Addresses(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", corp='" + corp + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String address1 = "afdg, qwer, ewr, sdfg, 7, 1, 5";
        String address2 = "ik, uj, Los yh, tg, ty, a, hfg";
        String address3 = "adf, dfg; dfg;,  , dfg, 1, 1, 1";
        String address4 = "j; f; g. g, 1, 1; 1";

        System.out.println("split");
        System.out.println(Addresses.Split(address1));
        System.out.println(Addresses.Split(address2));

        System.out.println("\nStringTokenizer:");
        System.out.println(Addresses.Tokenizer(address3));
        System.out.println(Addresses.Tokenizer(address4));

    }
}