package springinthepub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Pub {
    static final int maxCapacity = 50;
    String pubName;
    int currCapacity = 0;
    double beerLiterLimit;
    List<Beerman> visitors = new ArrayList<>();

    @Autowired
    public Pub(String pubName, double beerLiterLimit) {
        this.pubName = pubName;
        this.beerLiterLimit = beerLiterLimit;
    }

    public List<Beerman> getVisitors() {
        return visitors;
    }

    public void setVisitors(ArrayList<Beerman> visitors) {
        List<Beerman> temp = new ArrayList<>();
        for (Beerman visitor : visitors) {
            if (visitor.age > 18 && this.currCapacity <= maxCapacity && this.beerLiterLimit > 0) {
                temp.add(visitor);
                this.currCapacity++;
                this.beerLiterLimit -= visitor.getLitersToDrink();
                Beerman.beerManCount++;
//        temp = visitors.stream().filter((i)->i.age >= 18 && this.currCapacity <= maxCapacity
//                && this.beerLiterLimit > 0).collect(Collectors.toList());
//        temp = visitors.stream().filter(i-> i.age >= 18 && this.currCapacity <= maxCapacity
//                && this.beerLiterLimit > 0).collect(Collectors.toList());
                this.visitors = temp;
            }
        }
    }

    @Override
    public String toString() {
        return "Pub{" +
                "pubName='" + pubName + '\'' +
                ", capacity=" + currCapacity + "/" + maxCapacity +
                ", beerLiterLimit=" + beerLiterLimit +
                ", visitors=" + visitors +
                '}';
    }

    public String getPubName() {
        return pubName;
    }
    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public int getCurrCapacity() {
        return currCapacity;
    }

    public void setCurrCapacity(int currCapacity) {
        this.currCapacity = currCapacity;
    }

    public double getBeerLiterLimit() {
        return beerLiterLimit;
    }
    public void setBeerLiterLimit(double beerLiterLimit) {
        this.beerLiterLimit = beerLiterLimit;
    }

    public static void main(String[] args) {

//        Pub blueLagoon1 = new Pub("name", 500.0);
//        blueLagoon1.setVisitors(new Beerman("Jim", 40, 20.0));
//        blueLagoon1.setVisitors(new Beerman("Pol", 15, 20.0));
//        blueLagoon1.setVisitors(new Beerman("Dave", 45, 50.5));

//        System.out.println(blueLagoon1);

        ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
        Pub blueLagoon = (Pub) ac.getBean("pub");
        System.out.println(blueLagoon);
    }
}
