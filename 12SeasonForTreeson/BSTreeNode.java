import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {
    
    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;
    private int counter;
    
    public BSTreeNode( T d ) {
	
	data = d;
	left = right = null;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }
    public int getCounter(){
	return counter;
    }
    
    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }
    public void setCounter(int count){
	counter=count;
    }

    public String toString(){
	return data.toString();
    }

    //below is just a lazy way to not type setCounter :P
    public void plus(){
	//counter++;
	setCounter(getCounter()+1);
    }
    public void minus(){
	//counter--;	
	setCounter(getCounter()-1);
    }
}