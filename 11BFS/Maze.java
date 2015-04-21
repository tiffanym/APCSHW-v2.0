import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private int[] solutionAR=new int[0];

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
	}catch(Exception e){
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
	return mazeAnim+"Path: "+solution(); //added to show frontier
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public boolean solveBFS(){
	return solveBFS(true);
    }

    public boolean solveDFS(){
	return solveDFS(true);
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){   
	boolean works=solve(animate,0);
	if (works){
	    System.out.println(Arrays.toString(solutionArray()));
	}
	return works;
    }
    
    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */    
    public boolean solveDFS(boolean animate){
	boolean works=solve(animate,1);
	if (works){
	    System.out.println(Arrays.toString(solutionArray()));
	}
	return works;
    }


    private static final int BFS=0;
    private static final int DFS=1;
    private boolean solve(boolean animate,int mode){
	//1=DFS; 0=BFS
	Frontier rest = new Frontier(mode);
	Point start = new Point(startx,starty);
	
	rest.add(start);//put the start into the Frontier 
	
	boolean solved = false;
	while(!solved && rest.hasNext()){
	    if(animate && !solved){
		System.out.println(toString(true));
		//System.out.println("Frontier: "+rest.toString());
		wait(100);
	    }
	    Point next = rest.remove();
	    
	    //check if solved
	    if (maze[next.getX()][next.getY()]=='E'){
		solved = true;
		addCoordinatesToSolutionArray(next);
	    }
	    else{
		//not solved, so add neighbors to Frontier and mark the floor with x.
		if (maze[next.getX()][next.getY()]!='S'){
		    maze[next.getX()][next.getY()]='.';
		}
		ArrayList<Point> neighbors= getNeighbors(next);
		maze[next.getX()][next.getY()]='x';
		for(Point p : neighbors){
		    rest.add(p);
		    //addCoordinatesToSolutionArray(p);
		}

		if (mode==DFS){
		    //Point 
		}

		
	    }	    
	}
	return solved;
    }

    public void addCoordinatesToSolutionArray(Point next){
	//Point copy=next;
	while (next!=null){
	    int[]temp=new int[solutionAR.length+2];
	    for (int i=0;i<solutionAR.length;i++){
		temp[i]=solutionAR[i];
	    }
	    temp[temp.length-2]=next.getX();
	    temp[temp.length-1]=next.getY();
	    next=next.getParent();
	    solutionAR=temp;
	}
    }

    public ArrayList<Point> getNeighbors(Point next){
	ArrayList<Point> temp=new ArrayList<Point>();
	int x=next.getX();
	int y=next.getY();
	int[][] connected={{x+1,y},{x,y+1},{x-1,y},{x,y-1}};
	for(int[] spot:connected){
	    if (spot[0]>=0 && spot[1]>=0 && spot[0]<maxx && spot[1]<maxy){
		if (maze[spot[0]][spot[1]]==' ' || maze[spot[0]][spot[1]]=='E'){
		    temp.add(new Point(spot[0],spot[1]));
		}
	    }
	}
	return temp;
    }
    
    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    public int[] solutionArray(){
	return solutionAR;
    }

    public String solution(){
	String ans="[";
	for (int i=0;i<solutionAR.length;i++){
	    if (i%2==0){
		ans+="("+solutionAR[i]+",";
	    }else{
		ans+=solutionAR[i]+")";
		if (i!=solutionAR.length-1){
		    ans+=",";
		}
	    }
	}
	ans+="]";
	return ans;
    }

    public boolean solveBest(){
    	return solveBest(true);
    }

    public boolean solveAStar(){
    	return solveAStar(true);
    }
    
    public boolean solveBest(boolean animate){
    	return false; //add stuff
    }
    
    public boolean solveAStar(boolean animate){
    	return false; //add stuff
    }

    public static void main(String[] args){
	Maze test1=new Maze("data1.dat");
	Maze test2=new Maze("easy.dat");
	Maze test3=new Maze("emptyMaze.dat");
	//System.out.println(test3.solveBFS());
	System.out.println(test1.solveDFS());
	//System.out.println(test3.solveBest());
	//System.out.println(test3.solveAStar());
    }
}
