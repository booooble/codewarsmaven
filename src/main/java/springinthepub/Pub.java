package springinthepub;

import java.util.ArrayList;
import java.util.List;

public class Pub {
    String pubName;
    int capacity = 0;
    static double beerLiterLimit;
    List<Beerman> visitors;
    static int maxCapacity = 50;

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
                beerLiterLimit -= visitor.getVol();
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
