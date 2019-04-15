package org.cth.designPattern.interpreter;

public class ValueNode implements Node {
    private int value;

    public ValueNode(int value)
    {
        this.value=value;
    }

    public int interpret()
    {
        System.out.println(">>>value: " + value);
        return this.value;
    }
}
