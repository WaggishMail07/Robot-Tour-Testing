package robottour.course;

public class Course {
    private GridSquare[][] gridSquares = new GridSquare[4][4];
    private boolean[] distsGenerated = new boolean[5]; 



    // CONSTRUCTORS


    // no arg constructor
    public Course() {
        boolean[] newDistsGen = {false, false, false, false, false};
        distsGenerated = newDistsGen;
        for (int I = 0; I < 4; I++) {
            for (int i = 0; i < 4; I++) {
                gridSquares[I][i] = new GridSquare();
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
    public boolean generateDistsFromStart() {
        try {
            
        }
    }
    // calls all other generate methods to try and generate all distances in all grid squares
    public boolean generateAll() {
        try {

        } catch (Throwable e) {

        } finally {
            
        }
        return true;
    } 


}
