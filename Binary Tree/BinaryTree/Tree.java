package BinaryTree;
//Tree (root)
//Node (value, leftchild , rightchild)
//insert(value)
//find(value):boolen

public class Tree {
    private class Node{
        private int value;
        private  Node leftchild;
        private  Node rightchild;

        public Node(int value){
            this.value=value;
        }

        @Override
        public  String toString(){
            return  "Node=" +value;
        }
    }

    private Node root;

    public void insert(int value){
        var node = new Node(value);
        if(root == null){
            root = node;
            return;
        }

        var current = root;
        while (true){
            if (value<current.value) {
                if(current.leftchild==null) {
                    current.leftchild = node;
                    break;
                }
                current = current.leftchild;
            }
            else {
                if(current.rightchild==null){
                    current.rightchild = node;
                    break;
                }
                current = current.rightchild;
            }
        }
    }

    public boolean find(int value){
        var current = root;
        while (current !=null){
            if (value<current.value)
                current = current.leftchild;
            else if (value>current.value)
                current = current.rightchild;
            else
                return true;
        }

        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }


    private void traversePreOrder(Node root){
        //Base condition
        if(root==null)
            return;
        //root(print)
        System.out.println(root.value);
        //left
        traversePreOrder(root.leftchild);
        //right
        traversePreOrder(root.rightchild);
    }


    private void traverseInOrder(Node root){
        if(root==null)
            return;
        traverseInOrder(root.leftchild);
        System.out.println(root.value);
        traverseInOrder(root.rightchild);
    }

    private void  traversePostOrder(Node root){
        if(root==null)
            return;
        traversePostOrder(root.leftchild);
        traversePostOrder(root.rightchild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }

    private boolean is_leaf(Node node){
        return root.leftchild==null && root.rightchild==null;
    }

    private int height(Node root){
        if(root==null)
            return -1;
        if (is_leaf(root))
            return 0;
        // 1+ max(height(L) , height(R)) --> Height formula
        return 1 + Math.max(height(root.leftchild),
                height(root.rightchild));
    }

    public int min(){

        return min(root);

    }
    // O(logn)
    public int minOfBinarySearchTree(){
        if(root == null)
            throw  new IllegalStateException();
        var current= root;
        var last = current;
        while(current!=null){
            last=current;
            current= current.leftchild;
        }
        return last.value;
    }

    // O(n)
    private int min(Node root){
        if (is_leaf(root))
            return root.value;

        var left = min(root.leftchild);
        var right = min(root.rightchild);

        return  Math.min(Math.min(left,right), root.value);
    }


}
