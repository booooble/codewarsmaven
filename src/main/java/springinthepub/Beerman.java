package springinthepub;

/**
 * Created by Администратор on 22.04.2016.
 */
public class Beerman {
    String name;
    int age;
    double vol;

    public Beerman(String name, int age, double vol) {
        this.name = name;
        this.age = age;
        this.vol = vol;
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

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }
}
