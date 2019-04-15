package org.cth.designPattern.adapter;

/**
 * 对象的适配器模式
 */
public class Adapter1 implements Targetable {
    private Source sc ;

    public Adapter1(Source sc) {
        this.sc = sc;
    }

    public void a(){
        System.out.println("ceshiceshiceshi");
    }

    @Override
    public void method1() {
        System.out.println("this is the targetable override method");
    }

    @Override
    public void method2() {
        sc.method1();
    }
}
