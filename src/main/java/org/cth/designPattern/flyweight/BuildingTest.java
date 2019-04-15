package org.cth.designPattern.flyweight;

public class BuildingTest {
    public static void main(String[] args) {
        Gym b1 = BuildingFactory.getGym("足球");
        Gym b2 = BuildingFactory.getGym("篮球");
        Gym b3 = BuildingFactory.getGym("足球");
        System.out.println("建筑池中的对象数量为："+BuildingFactory.getSize());
        b1.setName("中国体育馆");
        b1.setShape("圆形");
        b1.use();
        b2.setName("中国体育馆1");
        b2.setShape("圆形1");
        b2.use();
        b3.setName("中国体育馆2");
        b3.setShape("圆形2");
        b3.use();
        b1.use();
    }
}
