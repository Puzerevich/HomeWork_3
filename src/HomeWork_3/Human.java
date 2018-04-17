package HomeWork_3;

/**
 * Created by Konstantin on 12.04.2018.
 */
public class Human {


    private String name;
    private String surname;
    private int    age;
    private boolean    sex;

    public Human() {
        this.name = "No Name";
        this.surname = "No Surname";
        this.age = 0;
        this.sex = true;
    }

    public Human(String name, String surname, int age, boolean sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex=" + sex +" ";
    }

}
