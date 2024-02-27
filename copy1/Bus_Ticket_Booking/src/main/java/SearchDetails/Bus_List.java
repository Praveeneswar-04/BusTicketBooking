package SearchDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import BusDetails.*;

interface Search {
    void sortByName(List<Bus> values);
    void sortByPrice(List<Bus> values);
    void filterByPriceRange(List<Bus> values, double minPrice, double maxPrice);
    void filterBySeatsAvailable(List<Bus> values, int minSeatsAvailable);
    void view(List<Bus> values);
}

public class Bus_List implements Search {

    static Scanner sc = new Scanner(System.in);
    static List<Bus> values = BusOperations.DbtoList();

    @Override
    public void sortByPrice(List<Bus> values) {
        Collections.sort(values, new Comparator<Bus>() {
            @Override
            public int compare(Bus bus1, Bus bus2) {
                return Double.compare(bus1.getPrice(), bus2.getPrice());
            }
        });
        System.out.println("Sorted buses by price:");
        for (Bus bus : values) {
            System.out.println(bus);
        }
    }

    @Override
    public void sortByName(List<Bus> values) {
        List<Bus> sort = values.stream().sorted(Comparator.comparing(Bus::getBus_Name)).collect(Collectors.toList());
        sort.forEach(System.out::println);
    }

    public void filterByPriceRange(List<Bus> values, double minPrice, double maxPrice) {
        List<Bus> filter = new ArrayList<>();
        for (Bus bus : values) {
            if (bus.getPrice() >= minPrice && bus.getPrice() <= maxPrice) {
                filter.add(bus);
            }
        }
        filter.forEach(System.out::println);
    }

    public void filterBySeatsAvailable(List<Bus> buses, int minSeatsAvailable) {
        List<Bus> filter = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getSeat() >= minSeatsAvailable) {
                filter.add(bus);
            }
        }
    }

    public void searchByName(List<Bus> values, String name) {
        System.out.println("Executed");
        String busName = name.toLowerCase(); // Convert to lower case for case-insensitive comparison
        values.stream()
                .filter(Bus -> Bus.getBus_Name().equalsIgnoreCase(busName)).forEach(System.out::println);
    }

    public void searchByPlace(List<Bus> values, String name) {
        String placeName = name.toLowerCase(); // Convert to lower case for case-insensitive comparison
        values.stream().filter(Bus -> Bus.getBus_Name().equalsIgnoreCase(placeName)).forEach(System.out::println);
    }

    public void view(List<Bus> values) {
        values.stream()// Ensure distinct details are printed
                .forEach(System.out::println); // Print each detail
    }
}
