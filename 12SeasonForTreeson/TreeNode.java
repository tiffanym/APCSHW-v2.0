public class TreeNode<T>{
    T data;
    TreeNode<T> left,right;
    private static final int preORDER=0;
    private static final int postORDER=1;
    private static final int inORDER=2;

    public TreeNode(){

    }

    public String toString(int order){
	if (order==preORDER){//V left right

	}else if(order==postORDER){// left right V

	}else if(order==inORDER){// left V right

	}	
    }

}