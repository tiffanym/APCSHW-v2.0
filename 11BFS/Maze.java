import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private int mode;
    MyDeque<Coordinate> nexts=new MyDeque<Coordinate>();
    //MyDeque<Coordinate> tp=new MyDeque<Coordinate>();
    private int[][] checked;

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

	checked=new int[maze.length][maze[0].length];
	for (int i=0;i<maze.length;i++){
	    for (int j=0;i<maze.length;j++){
		if (i!=startx && j!=starty){
		    checked[i][j]=-1;
		}
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
	int level;
	Coordinate parent=null;
	
	public Coordinate(int x, int y, int level,Coordinate parent){
	    setX(x);
	    setY(y);
	    setLevel(level);
	    setParent(parent);
	}
	public Coordinate(int x, int y){
	    setX(x);
	    setY(y);
	    level=-1;
	}
	public Coordinate(){
	    setX(0);
	    setY(0);
	    level=-1;
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
	public int getLevel(){
	    return level;
	}
	public void setLevel(int level){
	    this.level=level;
	}
	public Coordinate getParent(){
	    return parent;
	}
	public void setParent(Coordinate parent){
	    this.parent=parent;
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
	//boolean works=solve(animate,mode,startx,starty);
	Coordinate start=new Coordinate(startx,starty);
	boolean works=solve(animate,start,0);
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



    //idea/ pseudo-code from www.alexanderuseche.com/search-algorithms-breadth-first-search/
    //temp (maybe?) method for BFS
    public boolean solve(boolean animate, Coordinate point, int currentLevel){ 
	point.setLevel(currentLevel);
	nexts.addLast(point); //queue: add to last; remove from first //starting point has level 0
	//stack:add to last;remove from last
	Coordinate parent=null;
	//boolean[][] checked=new boolean[maze.length][maze[0].length];
	int i=currentLevel+1;
	while (!nexts.isEmpty()){
	    if (animate){
		System.out.println(toString(animate));
		wait(20);
	    }
	    //while (!nexts.isEmpty()){ //for (Coordinate thing : nexts)
	    MyDeque<Coordinate> tp=new MyDeque<Coordinate>();
	    Coordinate temp=nexts.removeFirst();
	    int x=temp.getX();
	    int y=temp.getY();
	    int[][] connected={{x+1,y},{x,y+1},{x-1,y},{x,y-1}};
	    for (int[] spot:connected){
		if (spot[0]<0 || spot[1]<0 || spot[0]>=maxx || spot[1]>=maxy){
		    return false;
		    }
		if(checked[spot[0]][spot[1]]==-1){
		    //nexts.addLast(temp);
		    if (maze[spot[0]][spot[1]]=='E'){
			checked[spot[0]][spot[1]]=i; //currentLevel+1;
			nexts.addLast(new Coordinate(spot[0],spot[1],i,point));			
			return true;
		    }
		    if (maze[spot[0]][spot[1]]==' '|| maze[spot[0]][spot[1]]=='S'){
			checked[spot[0]][spot[1]]=i; //currentLevel+1;
			Coordinate p2=new Coordinate(spot[0],spot[1],i,point);
			//nexts.addLast(p2);
			tp.addLast(p2);
			//nexts.addLast(new Coordinate(spot[0],spot[1]));
		    }//else{
		    //	nexts.removeFirst();
		    //}
		}
	    }
	    tp=nexts;
	    i++;
		//}
	    
	    //checked[x][y]=true; //added
	}
	return false;
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
		//temp.addLast
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