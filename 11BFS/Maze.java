import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private int mode;
    MyDeque<Coordinate> nexts=new MyDeque<Coordinate>();
    MyDeque<Coordinate> temp=new MyDeque<Coordinate>();

    //Stuff for printing out maze
    private static final String clear = "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public Maze(String filename){ 
	startx = -1;
	starty = -1;
	String ans = "";
	maxx=0;
	maxy=0;
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

    /**TOSTRING methods*/
    //No funky character codes
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
    
    //Do the funk[y] character codes when animate is true
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


    /**COORDINATE class*/
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
    
    public boolean solveBFS(){
	return solveBFS(true);//change to false later; true only for testing purposes
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){   
	mode=0;
	boolean works=solve(animate,mode,startx,starty);
	if (works){
	    System.out.println(Arrays.toString(solutionCoordinates()));  
	}
	return works;	
    }
    
    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */    
    public boolean solveDFS(boolean animate){
	mode=1;
	boolean works=solve(animate,mode,startx,starty);
	if (works){
	    System.out.println(Arrays.toString(solutionCoordinates()));  
	}
	return works;	
    }

    private boolean solve(boolean animate,int mode,int x, int y){
	//1=DFS; 0=BFS
	//FOR BOTH
	if (animate){
	    System.out.println(toString(animate));
	    wait(20);
	}

	if (x<0 || y<0 || x>=maxx || y>=maxy){
	    return false;
	}
	if (maze[x][y]=='E'){
	    nexts.addLast(new Coordinate(x,y));
	    return true;
	}

	if (maze[x][y]==' ' || maze[x][y]=='S'){
	    if (maze[x][y]!='S'){
		maze[x][y]='o';
	    }
	    //If DFS
	    if (mode==1){
		if (solve(animate,mode,x+1,y) || solve(animate,mode,x,y+1) ||
		    solve(animate,mode,x-1,y) || solve(animate,mode,x,y-1)){
		    nexts.addLast(new Coordinate(x,y));
		    return true;
		}
		maze[x][y]='x';
	    }
	    
	    //If BFS
	    if (mode==0){
		boolean works=false;
		nexts.addLast(new Coordinate(x,y));
		if(solve(animate,mode,x+1,y)){
		    nexts.addLast(new Coordinate(x+1,y));		    
		    works=true;
		}
		if (solve(animate,mode,x,y+1)){
		    nexts.addLast(new Coordinate(x,y+1));
		    works=true;
		}
		if (solve(animate,mode,x-1,y)){
		    nexts.addLast(new Coordinate(x-1,y));
		    works=true;
		}
		if (solve(animate,mode,x,y-1)){
		    nexts.addLast(new Coordinate(x,y-1));
		    works=true;
		}
		if (works){
		    nexts.addLast(temp.removeFirst());
		    return true;
		}
		maze[x][y]='x';
	    }
	}
	
	return false;//by default the maze didn't get solved
    }
    
    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    public int[] solutionCoordinates(){
	int[] answer=new int[nexts.size()*2];
	int posn=0;
	while (posn<answer.length){
	    Coordinate out=new Coordinate();
	    if (mode==1){ //DFS
		out=nexts.removeLast();
	    }
	    if (mode==0){ //BFS
		out=nexts.removeFirst(); //temporary (need to check once BFS code works)
	    }
	    answer[posn]=out.getX();
	    posn++;
	    answer[posn]=out.getY();
	    posn++;
	}
	return answer;
    }

    public static void main(String[] args){
	//Maze test1=new Maze("data1.dat");
	Maze test2=new Maze("easy.dat");
	System.out.println(test2.solveBFS());
	//System.out.println(test1.solveDFS());
    }
}