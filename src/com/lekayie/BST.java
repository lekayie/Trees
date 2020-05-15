package com.lekayie;

public class BST {
    public Node root;
    public int treeHeight=0;

    public BST() {
        this.root = null;
    }

    /**
     * using inorder traversal
     * @param showNode
     * @return
     */
    public String showAllNodeData(Node showNode){
        if (showNode==null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(showAllNodeData(showNode.left));
        sb.append(showNode.data);
        sb.append(" ");
        sb.append(showAllNodeData(showNode.right));
        return sb.toString();
    }

    /**
     * Add new Node to the tree
     * @param number
     */
    public void addNode(int number){
        Node newNode = new Node();
        newNode.data =number;
        if(root ==null){
            root = newNode;
            return;
        }
        Node currentNode=root;
        while(true){
            if (number <currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }
    public boolean findValue(int number){
        Node currentNode = root;
        while(currentNode.data!=number){
            if(currentNode.data>number){
                currentNode = currentNode.left;
            }else{
                currentNode = currentNode.right;
            }
            if(currentNode ==null){
                return false;
            }
        }
        return true;
    }
    public boolean deleteNode(int id){
        Node parentNode = root;
        Node currentNode = root;
        boolean isLeftChild = false;
        //Lets find the node with the value we intend to delete
        while(currentNode.data!=id){
            parentNode = currentNode;
            if(currentNode.data>id){
                isLeftChild = true;
                currentNode = currentNode.left;
            }else{
                isLeftChild = false;
                currentNode = currentNode.right;
            }
            if(currentNode ==null){
                return false;
            }
        }

        if(currentNode.left==null && currentNode.right==null){
            //If this node , has no children:
            if(currentNode==root){
                // if this node is the root node, we set root to null
                root = null;
            }
            if(isLeftChild){
                //if this was the left child, set the parent's reference to it to null.
                parentNode.left = null;
            }else{
                // if it is the right child set the parent's reference to it to null.
                parentNode.right = null;
            }
        }

        else if(currentNode.right==null){
            //if this node only has one child, the left child
            if(currentNode==root){
                //if the node is the root node. make its left child the root
                root = currentNode.left;
            }else if(isLeftChild){
                //if the node is a left child, set the parent's reference to the left child to  reference the current node's reference to the left child
                parentNode.left = currentNode.left;
            }else{
                // if the node is a right child, reference the parent's reference to the left child to reference the current node's reference to its left child.
                parentNode.right = currentNode.left;
            }
        }
        else if(currentNode.left==null){
            // If this node only had one child, the right child
            if(currentNode==root){
                //if the node is the root node. make its right child the root
                root = currentNode.right;
            }else if(isLeftChild){
                // if the node is a left child, reference the parent's reference to the left child to reference the current node's reference to its right child.
                parentNode.left = currentNode.right;
            }else{
                //if the node is a right child, set the parent's reference to the right child to  reference the current node's reference to the right child
                parentNode.right = currentNode.right;
            }
        }else if(currentNode.left!=null && currentNode.right!=null){
            //if the node has two children, left and right, determine which node will succeed(successor) as the parent node
            Node successor	 = getSuccessorNode(currentNode);
            if(currentNode==root){
                //if the node to deleted is the root, set successor node to root
                root = successor;
            }else if(isLeftChild){
                //if the node is the left child, set the parents reference to the left child to the successor node.
                parentNode.left = successor;
            }else{
                //if the node is the right child, set the parents reference to the right child to the successor node.
                parentNode.right = successor;
            }
            //Finally set the successor reference to left child to the current node's reference to the left child.
            successor.left = currentNode.left;
        }
        return true;
    }
    public Node getSuccessorNode(Node deleteNode){
        //Create a Successor node variable and a node variable holding the successor's parent
        Node successor =null;
        Node successorParentNode =null;
        // Set the the current node to point to the right node of the node to be deleted
        Node current = deleteNode.right;
        // loop through to the left most node of this sub-tree
        while(current!=null){
            successorParentNode = successor;
            successor = current;
            current = current.left;
        }
       //Check if the left most node of the subtree has a right child
        //if it does, set the riht child reference of the successor node to the left child reference f its parent.
        if(successor!=deleteNode.right){
            successorParentNode.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }
}
