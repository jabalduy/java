package block2.Prac13;

import java.util.StringTokenizer;

public class Address {

    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public void parseWithSplit(String address) {
        String[] parts = address.split(",");

        country = parts[0].trim();
        region = parts[1].trim();
        city = parts[2].trim();
        street = parts[3].trim();
        house = parts[4].trim();
        building = parts[5].trim();
        apartment = parts[6].trim();
    }

    public void parseWithTokenizer(String address) {
        StringTokenizer tokenizer =
                new StringTokenizer(address, ",.;");

        country = tokenizer.nextToken().trim();
        region = tokenizer.nextToken().trim();
        city = tokenizer.nextToken().trim();
        street = tokenizer.nextToken().trim();
        house = tokenizer.nextToken().trim();
        building = tokenizer.nextToken().trim();
        apartment = tokenizer.nextToken().trim();
    }

    public void printAddress() {
        System.out.println("Country: " + country);
        System.out.println("Region: " + region);
        System.out.println("City: " + city);
        System.out.println("Street: " + street);
        System.out.println("House: " + house);
        System.out.println("Building: " + building);
        System.out.println("Apartment: " + apartment);
        System.out.println();
    }
}
