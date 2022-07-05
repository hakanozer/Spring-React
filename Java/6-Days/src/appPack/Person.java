package appPack;

public class Person {

    private String name;
    private String surname;
    private int age;
    private int tc;

    public Person() {

    }

    public Person(String name, String surname, int age, int tc) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.tc = tc;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", tc=" + tc +
                '}';
    }

}
