package org.cth.designPattern.command;

public class Test {
    public static void main(String[] args) {
        Receiver rc = new Receiver();
        Command cd = new MyCommand(rc);
        Invoker ik = new Invoker(cd);
        ik.action();
    }
}
