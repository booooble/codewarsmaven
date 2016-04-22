package springinthepub;

/**
 * Created by Администратор on 22.04.2016.
 */
public class Beerman {
    String name;
    int age;
    double litersToDrink;
    static int beerManCount = 0;

    public Beerman(String name, int age, double litersToDrink) {
        this.name = name;
        this.age = age;
        this.litersToDrink = litersToDrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getLitersToDrink() {
        return litersToDrink;
    }

    public void setLitersToDrink(double litersToDrink) {
        this.litersToDrink = litersToDrink;
    }
}
