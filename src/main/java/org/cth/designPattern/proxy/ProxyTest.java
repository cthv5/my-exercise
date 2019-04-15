package org.cth.designPattern.proxy;

import org.cth.designPattern.decorator.Sourceable;

public class ProxyTest {
    public static void main(String[] args) {
        Sourceable sa = new Proxy();//代理模式
        sa.method();
    }
}
