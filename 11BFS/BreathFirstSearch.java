import java.util.*;
public class BreathFirstSearch{
    Queue<Coordinate> points=new Queue<Coordinate>(); //Do we use our queue or built in java queue?

    public class Coordinate{
	int x,y;

	public Coordinate(int x, int y){
	    setX(x);
	    setY(y);
	}
	public Coordinate(){
	    setX(0);
	    setY(0);
	}

	public int getX(){
	    return x;
	}
	public int setX(int x){
	    this.x=x;
	}
	public int getY(){
	    return y;
	}
	public int setY(int y){
	    this.y=y;
	}
    }

    public static void main(String[]args){

    }

}