package org.cth.other;

public class PersonModel {
    public PersonModel(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    private String name = "";
    private int age = 0;
    private String sex = "";

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
