package com.lekayie;

public class Main {

    public static void main(String[] args) {
        //Test examples
        BST tree = new BST();
        tree.addNode(8);
        tree.addNode(5);
        tree.addNode(4);
        tree.addNode(10);
        tree.addNode(2);
        tree.addNode(6);
        tree.addNode(15);
        tree.addNode(9);
        System.out.println("Inorder: "+tree.inorderTraversal(tree.root));
        System.out.println("Pre-order: "+tree.preOrderTraversal(tree.root));
        System.out.println("Post-order: "+tree.postOrderTraversal(tree.root));
        System.out.println("Tree height: "+tree.getTreeHeight(tree.root));
        System.out.println(tree.findValue(4));
        tree.deleteNode(4);
        System.out.println("Inorder: "+tree.inorderTraversal(tree.root));
        System.out.println(tree.findValue(4));
        System.out.println("Tree height: "+tree.getTreeHeight(tree.root));

    }
}
