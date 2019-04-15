package org.cth.designPattern.interpreter;


public class MulNode extends SymbolNode {
    public MulNode(Node left, Node right) {
        super(left, right);
    }

    public int interpret() {
        System.out.println(">>>" + left.interpret() + "*" + right.interpret());
        return left.interpret() * right.interpret();
    }
}
