/**POINT class*/
public class Point{
    int x,y;
    Point parent=null;
    
    public Point(int x, int y, Point parent){
	setX(x);
	setY(y);
	setParent(parent);
    }
    public Point(int x, int y){
	setX(x);
	setY(y);
	setParent(null);
    }
    public Point(){
	setX(0);
	setY(0);
    }

    public int getX(){
	return x;
    }
    public void setX(int x){
	this.x=x;
    }
    public int getY(){
	return y;
    }
    public void setY(int y){
	this.y=y;
    }
    public Point getParent(){
	return parent;
    }
    public void setParent(Point parent){
	this.parent=parent;
    }
}