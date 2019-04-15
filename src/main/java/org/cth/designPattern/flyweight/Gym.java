package org.cth.designPattern.flyweight;

public class Gym implements Building {
    private String name;
    private String shape;
    private String sport;

    public Gym(String sport) {
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public void use() {
        System.out.println("该体育馆被使用来召开奥运会" + "  运动为：" + sport + "  形状为：" + shape + "  名称为：" + name);
    }
}
