import java.util.*;
public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;

    private static final String clear =  "\033[2J";
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
	String mazeAnim="";
	if (animate){
	    String ans = ""+maxx+","+maxy+"\n";
	    for(int i=0;i<maxx*maxy;i++){
		if(i%maxx ==0 && i!=0){
		    ans+="\n";
		}
		ans += maze[i%maxx][i/maxx];
	    }
	    mazeAnim= hide()+invert()+go(0,0)+ans+"\n"+show();	
	}else{
	    mazeAnim=maze.toString();
	}
	return mazeAnim;
    }
    
    public boolean solveBFS(){
	return solveBFS(false);
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){   

    }
    
    public boolean solveDFS(){
	return solveDFS(false);
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
	    System.out.println(this);
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
	    maze[x][y]='.';
	}
	return false;//by default the maze didn't get solved
    }

    public static void main(String[] args){
	Maze test=new Maze();
	//System.out.println(test.solveBFS);
	System.out.println(test.solveDFS);
    }
}