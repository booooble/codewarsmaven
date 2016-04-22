package springinthepub;

import java.util.ArrayList;
import java.util.List;

public class Pub {
    static final int maxCapacity = 50;
    String pubName;
    int capacity = 0;
    double beerLiterLimit;
    List<Beerman> visitors;

    public Pub(String pubName, double beerLiterLimit) {
        this.pubName = pubName;
        this.beerLiterLimit = beerLiterLimit;
        this.visitors = new ArrayList<>();
    }

    public List<Beerman> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Beerman> visitors) {
        for (Beerman visitor : visitors) {
            if (visitor.age > 18 && capacity <= maxCapacity) {
                this.visitors.add(visitor);
                capacity--;
                beerLiterLimit -= visitor.getLitersToDrink();
                Beerman.beerManCount++;
            }
        }
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getBeerLiterLimit() {
        return beerLiterLimit;
    }

    public void setBeerLiterLimit(double beerLiterLimit) {
        this.beerLiterLimit = beerLiterLimit;
    }
}
