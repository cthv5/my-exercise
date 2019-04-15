package org.cth.designPattern.composite;

import java.util.Enumeration;

public class Tree {
    TreeNode root = null;

    public Tree(String name){
        root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tr = new Tree("A");
        TreeNode nd1 = new TreeNode("B");
        TreeNode nd2 = new TreeNode("C");
        nd1.add(nd2);
        tr.root.add(nd1);
        Enumeration<TreeNode> vt = nd1.getChildren();
        while (vt.hasMoreElements()){
            System.out.println(vt.nextElement().getName());
        }
    }
}
