package org.cth.designPattern.interpreter;

public class DivNode extends SymbolNode{
    public DivNode(Node left,Node right){
        super(left,right);
    }

    public int interpret(){
        System.out.println(">>>" + left.interpret() + "/" + right.interpret());
        return left.interpret() / right.interpret();
    }
}
