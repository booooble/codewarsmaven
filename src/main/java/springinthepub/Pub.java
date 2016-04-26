package springinthepub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Pub {
    static final int maxCapacity = 50;
    String pubName;
    int currCapacity = 0;
    public double beerLiterLimit;
    public double initialBeerLimit;
    List<Beerman> visitors = new ArrayList<>();

    @Autowired
    public Pub(String pubName, double beerLiterLimit) {
        this.pubName = pubName;
        this.beerLiterLimit = beerLiterLimit;
    }

    public Pub() {

    }

    public List<Beerman> getVisitors() {
        return visitors;
    }

    public void setVisitors(ArrayList<Beerman> visitors) {
        initialBeerLimit = this.getBeerLiterLimit();
        List<Beerman> temp = new ArrayList<>();
        for (Beerman visitor : visitors) {
            boolean isEnoughBeer = this.beerLiterLimit - visitor.getLitersToDrink() >= 0;
            if (!isEnoughBeer) {
                try {
                    boolean isOrdered = makeAnOrder();
                    isEnoughBeer = isOrdered;
                    sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            if (visitor.age >= 18 && this.currCapacity <= maxCapacity && isEnoughBeer) {
                System.out.println(visitor.getName() + " came in");
                temp.add(visitor);
                this.currCapacity++;
                this.beerLiterLimit -= visitor.getLitersToDrink();
                Beerman.beerManCount++;
            } else {
                System.out.print(visitor.getName() + " was rejected ");
                if (visitor.getAge() < 18) {
                    System.out.println("(" + visitor.getAge() + "years old)");
                } else {
                    System.out.println("No beer - no fun, man...");
                }
            }
//        temp = visitors.stream().filter((i)->i.age >= 18 && this.currCapacity <= maxCapacity
//                && this.beerLiterLimit > 0).collect(Collectors.toList());
//        temp = visitors.stream().filter(i-> i.age >= 18 && this.currCapacity <= maxCapacity
//                && this.beerLiterLimit > 0).collect(Collectors.toList());
        }
        this.visitors = temp;
    }

    public boolean makeAnOrder() {
        System.out.println("The beerlimit has been ended. Composing the order...");
        double toOrder = this.initialBeerLimit * 0.2;
        System.out.println("The order for " + toOrder + " liters was sent to the provider...");
        boolean isOrderReceived = Provider.sendOrder(toOrder);
        if (isOrderReceived) {
            System.out.println("We ordered " + toOrder + " liters successfully. The party is going on!");
            this.beerLiterLimit += toOrder;
            return true;
        } else {
            System.out.println("The order has been rejected. The party is over...");
            return false;
        }
    }

    public class Delivery extends Thread {
        @Override
        public void run() {
            System.out.println("Waiting for the delivery...");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("We have got the delivery!");
        }
    }

    @Override
    public String toString() {
        return "Pub{" +
                "pubName='" + pubName + '\'' +
                ", capacity=" + currCapacity + "/" + maxCapacity +
                ", beerLiterLimit=" + beerLiterLimit +
                ", \n\tvisitors=" + visitors +
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
