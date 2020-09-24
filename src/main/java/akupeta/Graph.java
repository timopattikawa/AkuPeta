package akupeta;

import java.util.List;
import java.util.Map;

public abstract class Graph {
    protected int source, destination, INFINITY = 9999, NILL = -1;
    protected final int TotCity = 8;
    protected List<City> city = List.of(
            new City("jogja", 0),
            new City("klaten", 1),
            new City("solo", 2),
            new City("boyolali", 3),
            new City("salatiga", 4),
            new City("ambarawa", 5),
            new City("semarang", 6),
            new City("magelang", 7)
    );

    protected int[][] MAPGraph = new int[][] {
            {0, 39, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 46},
            {39, 0, 36, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY},
            {INFINITY, 36, 0, 29, INFINITY, INFINITY, INFINITY, INFINITY},
            {INFINITY, INFINITY, 39, 0, 24, INFINITY, INFINITY, INFINITY},
            {INFINITY, INFINITY, INFINITY, 24, 0, 19, INFINITY, INFINITY},
            {INFINITY, INFINITY, INFINITY, INFINITY, 19, 0, 16, 40},
            {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 16, 0,INFINITY},
            {46, INFINITY, INFINITY, INFINITY, INFINITY, 40, INFINITY, 0}};

    public Graph(String source, String destination) {
        this.source = getCityWithName(source);
        this.destination = getCityWithName(destination);
    }


    public abstract void searchPath();

    public abstract void printPath();


    public int getCityWithName(String s) {
        for(int i=0; i<city.size(); i++) {
            if(city.get(i).getCityName().equals(s)) {
                return i;
            }
        }
        return -1;
    }


    public City getCityWithCode(int n) {
        for(int i=0; i<city.size(); i++) {
            if(city.get(i).getCityCode() == n) {
                return city.get(i);
            }
        }
        System.out.println("Tidak Menemukan Kota");
        return null;
    }

    public boolean thereIsaCity() {
        return destination == -1 || source == -1;
    }
}

