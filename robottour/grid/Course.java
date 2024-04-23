package robottour.grid;


import robottour.grid.DefaultGridSquare;
import robottour.grid.GridSquare;


public class Course {
    public Course(boolean defaultGrid) {

    }
}











// ARTIFACT
/*
package robottour.course;


import robottour.course.GridSquare;


public abstract class Course {
    private GridSquare[][] gridSquares = new GridSquare[4][4];
    private boolean[] distsGenerated = new boolean[5]; 
    private int[][] keyPoints = new int[5][2]; // start, Gate A, Gate B, Gate C, End


    // CONSTRUCTORS


    // no arg constructor
    public Course() {
        boolean[] newDistsGen = {false, false, false, false, false};
        distsGenerated = newDistsGen;
        for (int I = 0; I < 4; I++) {
            System.out.println(I);
            for (int i = 0; i < 4; i++) {
                try {
                    gridSquares[I][i] = new GridSquare();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.printf("%s%d%s%d%s%d%s%d%s%n%n", "I=", I, " i=", i, " length=[", gridSquares.length, "][", gridSquares[I%4].length, "]");
                }
            }
        }
    }



    // SETTERS AND GETTERS


    // get for a grid square
    public GridSquare getGridSquare(int xLocation, int yLocation) {
        if ((0 <= xLocation && xLocation < 4) || (0 <= yLocation && yLocation < 4)) {
            return gridSquares[xLocation][yLocation];
        } else {
            throw new IllegalArgumentException("grid square location must be 0-3");
        }
    }

    // getter for gridSquares (full Array)
    public GridSquare[][] getGridSquares() {return gridSquares;}
    
    
    // getter for distsGenerated (full Array)
    public boolean[] getDistsGenerated() {return distsGenerated;}

    // methods to generate distances
    
    // generates distance from start in all GridSquare objects, boolean tells if successfull
    public boolean generateDistsFromStart(boolean[] viableDirections, int[] coords, int newValue) {
        try {
            // data validation
            if (viableDirections.length != 4 && viableDirections.length != 5) {throw new IllegalArgumentException("path finder array 'viables' was incorrect length, it must be 4 or 5");}if (!(coords.length == 2 && (0 <= coords[0] && coords[0] < 4) && (0 <= coords[0] && coords[0] < 4))) {throw new IllegalArgumentException("coords were invalid in pathfinder");}
            // go north
            if (viableDirections[0]) {boolean[] newDirections = viableDirections;newDirections[1] = false;generateDistsFromStart(, coords, newValue)}
            // go south
            // go east
            // go west
        } catch (IllegalArgumentException e) {return false;}}

    // calls all other generate methods to try and generate all distances in all grid squares
    public boolean generateAll() {return true;} 



    // SPECIALS


    // to string method
    @Override
    public String toString() {
        return String.format("", "");
    }
}
*/