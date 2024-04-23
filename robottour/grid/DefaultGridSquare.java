package robottour.grid;
import robottour.grid.*;
public class DefaultGridSquare extends GridSquare {
    private static final int[][] keyPoints = {{1, 0}, {0, 1}, {3, 1}, {2, 3}, {1, 3}};
    
    
    
    // CONSTRUCTOR


    // "constructor" to create the default grid
    public static void createDefaultGrid() {
        DefaultGridSquare[][] defaultGrid = new DefaultGridSquare[4][4];
        for (int I = 0; I < 4; I++) {
            for (int i = 0; i< 4; i++) {
                defaultGrid[I][i] = new DefaultGridSquare(I, i);
            }
        }
        course = defaultGrid;
    }
    // real constructor
    private DefaultGridSquare(int x, int y) {
        super(
        hasNorthBarrier(y, x), // set true if it has a north barrier, false if not
        hasSouthBarrier(y, x), // set true if it has a south barrier, false if not
        hasEastBarrier(y, x), // set true if it has a east barrier, false if not
        hasWestBarrier(y, x), // set true if it has a west barrier, false if not
        keyPoint(x, y, 0),
        keyPoint(x, y, 1),
        keyPoint(x, y, 2),
        keyPoint(x, y, 3),
        keyPoint(x, y, 4),
        x,
        y
        );
    }



    // SETTERS AND GETTERS


    // getter for all key points
    public int[][] getKeyPoints() {
        return keyPoints;
    } 
    // getter for start point location
    public int[] getStartPoint() {
        return keyPoints[0];
    }
    // getter for gate A location
    public int[] getGateALocation() {
        return keyPoints[1];
    }
    // getter for gate B location
    public int[] getGateBLocation() {
        return keyPoints[2];
    }
    // getter for gate C location
    public int[] getGateCLocation() {
        return keyPoints[3];
    }
    // getter for end point location
    public int[] getEndPoint() {
        return keyPoints[5];
    }



    // STATIC DATA VALIDATION


    // key point checker
    private static int keyPoint(int x, int y, int keyPointNum) {
        if (x == keyPoints[keyPointNum][0] && y == keyPoints[keyPointNum][1]) {return 0;}
        else {return -1;}
    }
    // checks if a square has a "north" barrier
    private static boolean hasNorthBarrier(int x, int y) {
        if (x==0 && 1==y) {return true;}
        else if (x==1 && 0==y) {return true;}
        else if (x==1 && 2==y) {return true;}
        else if (x==2 && 1==y) {return true;}
        else if (x==3 && 0==y) {return true;}
        else {return false;}
    }

    // checks if a square has a "south" barrier
    private static boolean hasSouthBarrier(int x, int y) {
        if (x==0 && 2==y) {return true;}
        else if (x==1 && 1==y) {return true;}
        else if (x==1 && 3==y) {return true;}
        else if (x==2 && 2==y) {return true;}
        else if (x==3 && 1==y) {return true;}
        else {return false;}
    }

    // checks if a square has an "east" barrier
    private static boolean hasEastBarrier(int x, int y) {
        if (x==1 && 1==y) {return true;}
        else if (x==1 && 3==y) {return true;}
        else if (x==2 && 3==y) {return true;}
        else {return false;}
    }

    // checks if a square has an "west" barrier
    private static boolean hasWestBarrier(int x, int y) {
        if (x==2 && 1==y) {return true;}
        else if (x==2 && 3==y) {return true;}
        else if (x==3 && 3==y) {return true;}
        else {return false;}
    }

    // checks if a square has a barrier
    private static boolean hasBarrier(int x, int y) {
        if (hasNorthBarrier(x,y) || hasSouthBarrier(x,y) || hasEastBarrier(x,y) || hasWestBarrier(x,y)) {
            return true;
        } else {
            return false;
        }
    }



    // SPECIALS


    // print info

}
