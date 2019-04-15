package org.cth.designPattern.interpreter;

public class ModNode extends SymbolNode{
    public ModNode(Node left,Node right){
        super(left,right);
    }

    public int interpret(){
        System.out.println(">>>" + left.interpret() + "%" + right.interpret());
        return left.interpret() % right.interpret();
    }
}