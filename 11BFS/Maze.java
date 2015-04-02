import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;

    private static final String clear = "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    /** Same constructor as before...*/
    public Maze(String filename){ 
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    
	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}

    }

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
	public void setX(int x){
	    this.x=x;
	}
	public int getY(){
	    return y;
	}
	public void setY(int y){
	    this.y=y;
	}
    }

    private class Frontier{//is a deque
	int mode;
	MyDeque<Coordinate> pile = new MyDeque<Coordinate>();
	//queue-->BFS =0
	//stack-->DFS =1
	public Frontier (int mode){
	    this.mode=mode;
	}

	public void add(Coordinate next){
	    pile.addLast(next);
	}

	public void remove(){
	    if (mode==1){ //DFS=stack
		pile.removeLast();
	    }else if (mode==0){ //BFS=queue
		pile.removeFirst();
	    }
	}
    }


    //do not do the funky character codes
    public String toString(){
	String ans = "";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return ans;	
    }
    
    //do the funky character codes when animate is true
    public String toString(boolean animate){
	String mazeAnim=clear+"";
	if (animate){
	    String ans = clear+""+maxx+","+maxy+"\n";
	    for(int i=0;i<maxx*maxy;i++){
		if(i%maxx ==0 && i!=0){
		    ans+="\n";
		}
		ans += maze[i%maxx][i/maxx];
	    }
	    mazeAnim= hide+go(0,0)+ans+"\n"+show;	
	}else{
	    mazeAnim=maze.toString();
	}
	return mazeAnim;
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public boolean solveBFS(){
	return solveBFS(false);
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){   
	return false; //change later
    }
    
    public boolean solveDFS(){
	return solveDFS(true);
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){  
	return solve(maze,startx,starty,animate);
    }
    
    public boolean solve(char[][]maze,int x,int y, boolean animate){
	if (animate){
	    //System.out.println(this);
	    System.out.println(toString(animate));
	    wait(20);
	}
	if (maze[x][y]=='E'){
	    return true;
	}
	if (maze[x][y]==' ' || maze[x][y]=='S'){
	    if (maze[x][y]!='S'){
		maze[x][y]='o';
	    }
	    if (solve(maze,x+1,y,animate) || solve (maze,x,y+1,animate) ||
		solve (maze,x-1,y,animate) || solve (maze,x,y-1,animate)){
		return true;
	    }
	    maze[x][y]='x';
	}
	return false;//by default the maze didn't get solved
    }

    //method?
    private boolean solve(boolean animate, int mode){
	Frontier nexts=new Frontier(mode);
	//1=DFS; 0=BFS
	return true;
    }



    //prints out final coordinates of shortest path [x1,y1,x2,y2,x3,y3]
    public int[] solutionArray(){
	return null;
    }

    public static void main(String[] args){
	//Maze test=new Maze("data1.dat");
	Maze test2=new Maze("easy.dat");
	//System.out.println(test.solveBFS());
	System.out.println(test2.solveDFS());
    }
}