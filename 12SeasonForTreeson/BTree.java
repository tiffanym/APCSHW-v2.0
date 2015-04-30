/*========== BTree.java ==========
  Lab: Complete
  1. TreeNode.java
  2. add()
  3. pre/post/in Order()
  4. getHeight
  5. getLevel
  6. toString

  Basic binary tree.
  Uses TreeNode
  Stolen from DW.
=========================*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private static final int LEFT=0;
    private static final int RIGHT=1; //cuz I'm too lazy to type the number...

    Random r=new Random();

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( E d ) {
	TreeNode<E> tmp = new TreeNode<E>(d);
	if (root == null) {
		root = tmp;
	} else {
		add(root , tmp);
	}
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<E> curr, TreeNode<E> bn ) {
	if (curr == null){
	    curr = bn;
	} else {
	    int side=r.nextInt(2);
	    //System.out.print("Adding to ");

	    if (side==LEFT){
		//System.out.println("left");
		//add(curr.getLeft(),data);
		//curr.setLeft(new TreeNode<T>(data));
		if ( curr.getLeft() == null )
		    curr.setLeft(bn);
		else
		    add(curr.getLeft(),bn);
		//System.out.println("Added "+bn.getData());
	    }else{
		//System.out.println("right");
		//add(curr.getRight(),data);
		//curr.setRight(new TreeNode<T>(data));
		if ( curr.getRight() == null )
		    curr.setRight(bn);
		else
		    add(curr.getRight(),bn);
		//System.out.println("Added "+bn.getData());
	    }
	}
    }

    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    System.out.println(preOrder(root,""));
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public String preOrder( TreeNode<E> curr, String ans ) {
	if (curr != null){
	    ans+=curr.getData()+preOrder(curr.getLeft(),ans)+
		preOrder(curr.getRight(),ans);
	}
	return ans;
	/*
	if (curr!=null){
	    //System.out.println("Adding "+curr.getData()+" then "+curr.getLeft().getData()+" and finally "+curr.getRight().getData());
	    //String ans=""+curr.getData()+
	    //curr.getLeft()+curr.getRight();
	    System.out.println("Current: "+curr.getData());
	    System.out.print(curr.getData());
	    if (curr.getLeft()!=null){
		System.out.println("Left: "+curr.getRight().getData());
		preOrder(curr.getLeft());
	    }
	    if (curr.getRight()!=null){
		System.out.println("Right: "+curr.getRight().getData());
		preOrder(curr.getRight());
	    }
	}
	*/
    }

    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<E> curr ) {
	if (curr!=null){
	    String ans=""+curr.getLeft()+
		curr.getData()+curr.getRight();
	    System.out.println(ans);
	}
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    

      ====================*/
    public void postOrder( TreeNode<E> curr ) {
	if (curr!=null){
	    String ans=""+curr.getLeft()+
		curr.getRight()+curr.getData();
	    System.out.println(ans);
	}	
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr ) {
	if (curr==null){
	    return 0;
	}else{
	    return 1+Math.max(getHeight(curr.getLeft()),
			      getHeight(curr.getRight()));
	}
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	return "";
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0

          1      2

            3  4   5

      ====================*/
    public String toString() {
	return "";
    }

    public void setSeed(long seed){
	r.setSeed(seed);
    }

    public static void main( String[] args ) {
	BTree<Integer> t = new BTree<Integer>();
	if (args.length==1){
	    t.setSeed(Integer.parseInt(args[0]));
	}else{
	    t.setSeed(0);
	}

	for ( int i=0; i < 8; i++ ) {
	    t.add( i ); //debugging shows add works
	}
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );
	
	System.out.println( t );
    }
}
