package com.lekayie;

public class Main {

    public static void main(String[] args) {
        //Test examples
        BST tree = new BST();
        tree.addNode(8);
        tree.addNode(5);
        tree.addNode(4);
        tree.addNode(10);
        System.out.println(tree.showAllNodeData(tree.root));
        System.out.println(tree.findValue(4));
        tree.deleteNode(4);
        System.out.println(tree.showAllNodeData(tree.root));
        System.out.println(tree.findValue(4));
    }
}
