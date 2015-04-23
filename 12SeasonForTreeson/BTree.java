import java.util.*;
public class BTree<T>{
    TreeNode<T> parent;//,childLeft,childRight;
    private static final int LEFT=0;
    private static final int RIGHT=1;
   
    public BTree(T data,TreeNode<T> left,TreeNode<T> right){	
	parent=new TreeNode<T>(data,left,right);
	//childLeft=parent.getLeft();
	//childRight=parent.getRight();
    }

    public BTree(T data){
	parent=new TreeNode<T>(data);
	//childLeft=parent.getLeft();
	//childRight=parent.getRight();
    }

    public void add(T value){
	add(parent,value);
    }

    public void add(TreeNode<T> parent, T data){
	if (parent==null){
	    parent=new TreeNode<T>(data);
	}else{
	    Random r=new Random();
	    int side=r.nextInt(2);
	    if (side==LEFT){
		//add(parent.getLeft(),data);
		parent.setLeft(new TreeNode<T>(data));
	    }if (side==RIGHT){
		//add(parent.getRight(),data);
		parent.setRight(new TreeNode<T>(data));
	    }
	}	
    }

    public String toString(int mode){
	return parent.toString(mode,parent);
    }

    public static void main(String[] args){
	BTree<Integer> test=new BTree<Integer>(new Integer(5));
	System.out.println(test.toString(2));
	test.add(6);
	System.out.println(test.toString(2));
	test.add(7);
	System.out.println(test.toString(2));
	test.add(8); //doesn't start new level
	System.out.println(test.toString(2));
    }
}