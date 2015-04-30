public class TreeNode<T>{
    T data;
    TreeNode<T> left,right;
    private static final int preORDER=0;
    private static final int postORDER=1;
    private static final int inORDER=2;

    public TreeNode(T data,TreeNode<T> left,TreeNode<T> right){	
	setData(data);
	setLeft(left);
	setRight(right);
    }
    public TreeNode(T data){
	setData(data);
	setLeft(null);
	setRight(null);
    }
/*
    public String toString(int order,TreeNode<T> parent){
	return toString(order,parent,"");
    }

    public String toString(int order,TreeNode<T> parent,String ans){
	if (parent==null){
	    ans+="";
	}else{
	    if (order==preORDER){//V left right
		ans+=""+parent.getData()+
		    toString(order,parent.getLeft(),ans)+
		    toString(order,parent.getRight(),ans); 
	    }else if(order==postORDER){// left right V
		ans+= ""+toString(order,parent.getLeft(),ans)+
		    toString(order,parent.getRight(),ans)+ 
		    parent.getData();
	    }else if(order==inORDER){// left V right
		ans+= ""+toString(order,parent.getLeft(),ans)+
		    parent.getData()+		    
		    toString(order,parent.getRight(),ans); 
	    }
	}
	return ans;
    }
*/
    public T getData(){
	return data;
    }
    public void setData(T data){
	this.data=data;
    }
    public TreeNode<T> getLeft(){
	return left;
    }
    public void setLeft(TreeNode<T> left){
	this.left=left;
    }
    public TreeNode<T> getRight(){
	return right;
    }
    public void setRight(TreeNode<T> right){
	this.right=right;
    }

    public static void main(String[] args){
	TreeNode<Integer> test=new TreeNode<Integer>(new Integer(5));
	test.setLeft(new TreeNode<Integer>(new Integer(6)));
	test.getLeft().setLeft(new TreeNode<Integer>(new Integer(8)));
	test.getLeft().setRight(new TreeNode<Integer>(new Integer(9)));
	test.setRight(new TreeNode<Integer>(new Integer(7)));
	test.getRight().setLeft(new TreeNode<Integer>(new Integer(1)));
	test.getRight().setRight(new TreeNode<Integer>(new Integer(2)));
//	System.out.println(test.toString(2,test));
    }
}
