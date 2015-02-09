public class Maze{
    public char[][] mazeSolve(char[][] maze){
	int x=0;
	int y=0;
	char[][] mazeCopy=new char[maze.length][maze[0].length];
	for (int i=0;i<maze.length;i++){
	    for (int j=0;j<maze[0].length;j++){
		mazeCopy[i][j]=maze[i][j];
		if (maze[i][j].equalsIgnoreCase('S')){
		    x=i;
		    y=j;
		}
	    }
	}
	return mazeHelp(copy,x,y);
    }

    public char[][] mazeHelp(char[][] copy,int x,int y){

    }

}