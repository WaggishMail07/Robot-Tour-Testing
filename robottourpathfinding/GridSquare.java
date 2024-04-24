package robottourpathfinding;


import java.util.Random;


public class GridSquare {
    // enum to select what to display in the grid square
    public enum interiorDisplaySelector{BASE, STARTGRAD, GATEAGRAD, GATEBGRAD, GATECGRAD, ENDGRAD, NONE};
    // array of all the grid squares in a course
    public static GridSquare[][] course = new GridSquare[4][4];
    // initialize variables 
    private enum directions {NORTH, SOUTH, EAST, WEST};
    private Random rand = new Random();
    private boolean[] barriers = new boolean[5]; // last is telling if the barriers have been properly set, not just set to default
    private int distanceToStart; // 
    private int distanceToGateA;
    private int distanceToGateB;
    private int distanceToGateC;
    private int distanceToEnd;
    private int[] location = new int[2];



    // CONSTRUCTORS


    // no argument constructor
    public GridSquare() {
        this(-1, -1);
        System.out.print("yo");
    }

    // location (array) only constructor
    public GridSquare(int[] newLocation) {
        this(newLocation[0], newLocation[1]);
    }

    // location (no array) only constructor
    public GridSquare(int newX, int newY) {
        this(false, false, false, false, -1, -1, -1, -1, -1, newX, newY);
        barriers[4] = false;
    }

    // full arg contructor with arrays
    public GridSquare(boolean[] newBarriers, int newDistToStart, int newDistToGateA, int newDistToGateB, int newDistToGateC, int newDistToEnd, int[] newLocation) {
        this(newBarriers[0], newBarriers[1], newBarriers[2], newBarriers[3], newDistToStart, newDistToGateA, newDistToGateB, newDistToGateC, newDistToEnd, newLocation[0], newLocation[1]);
    }

    // full arg constructor without arrays
    public GridSquare(boolean northBarrier, boolean southBarrier, boolean eastBarrier, boolean westBarrier, int newDistToStart, int newDistToGateA, int newDistToGateB, int newDistToGateC, int newDistToEnd, int newX, int newY) {
        barriers[0] = northBarrier;
        barriers[1] = southBarrier;
        barriers[2] = eastBarrier;
        barriers[3] = westBarrier;
        barriers[4] = true;
        distanceToEnd = newDistToEnd;
        distanceToGateA = newDistToGateA;
        distanceToGateB = newDistToGateB;
        distanceToGateC = newDistToGateC;
        distanceToStart = newDistToStart;
        location[0] = newX;
        location[1] = newY;
        if (!(0 <= newX && newX < 4 && 0 <= newY && newY < 4)) {

        }
    }



    // SETTERS AND GETTERS


    // setter for course
    public static void setCourse(GridSquare newSquare, int x, int y) {
        course[x][y] = newSquare;
    }
    // getter for course
    public static GridSquare[][] getCourse() {
        return course;
    }

    // setter for barriers (array)
    public void setBarriers(boolean[] newBarriers) {
        for (int i = 0; i < 10; i++) {
            System.out.println("yo?");
        }
        barriers[0] = newBarriers[0];
        barriers[1] = newBarriers[1];
        barriers[2] = newBarriers[2];
        barriers[3] = newBarriers[3];
    }
    // getter for barriers
    public boolean[] getBarriers() {
        return barriers;
    }
    // get north barrier
    public boolean hasNorthBarrier() {return barriers[0];}
    // get north barrier
    public boolean hasSouthBarrier() {return barriers[1];}
    // get north barrier
    public boolean hasEastBarrier() {return barriers[2];}
    // get north barrier
    public boolean hasWestBarrier() {return barriers[3];}

    // setter for distanceToStart 
    public void setDistanceToStart(int newDistanceToStart) {this.distanceToStart = newDistanceToStart;}
    // getter for distanceToStart 
    public int getDistanceToStart() {return distanceToStart;}

    // setter for distanceToGateA 
    public void setDistanceToGateA(int newDistanceToGateA) {this.distanceToGateA = newDistanceToGateA;} 
    // getter for distanceToGateA 
    public int getDistanceToGateA() {return distanceToGateA;}

    // setter for distanceToGateB 
    public void setDistanceToGateB(int newDistanceToGateB) {this.distanceToGateB = newDistanceToGateB;}
    // getter for distanceToGateB 
    public int getDistanceToGateB() {return distanceToGateB;}

    // setter for distanceToGateC 
    public void setDistanceToGateC(int newDistanceToGateC) {this.distanceToGateC = newDistanceToGateC;}
    // getter for distanceToGateC 
    public int getDistanceToGateC() {return distanceToGateC;}
    
    // setter for distanceToEnd 
    public void setDistanceToEnd(int newDistanceToEnd) {this.distanceToEnd = newDistanceToEnd;}
    // getter for distanceToEnd
    public int getDistanceToEnd() {return distanceToEnd;}

    // getter for location
    public int[] getLocation() {return location;}
    // getter for x locaiton
    public int getX() {return location[0];}
    // getter for y locaiton
    public int getY() {return location[1];}
    
    // getter for edges
    public boolean[] getEdges() {
        boolean[] output = {false, false, false, false};
        
        // check if "west" edge
        if (location[0] == 0) {
            output[3] = true;
        }
        
        // check if "east" edge
        if (location[0] == 3) {
            output[2] = true;
        }

        // check if "north" edge
        if (location[1] == 3) {
            output[1] = true;
        }

        // check if "south" edge
        if (location[1] == 0) {
            output[2] = true;
        }

        return output;
    }
    // getter for north edge
    public boolean isNorthEdge() {return getEdges()[0];}
    // getter for south edge
    public boolean isSouthEdge() {return getEdges()[1];}
    // getter for east edge
    public boolean isEastEdge() {return getEdges()[2];}
    // getter for west edge
    public boolean isWestEdge() {return getEdges()[3];}
    


    // STATIC DATA VALIDATION


    // check if inputted location is valid
    public boolean isValidLocation(int[] newLocation) {
        if (0 <= newLocation[0] && newLocation[0] < 4 && 0 <= newLocation[1] && newLocation[1] < 4) {
            return true;
        } else {
            throw new IllegalArgumentException("location must be 0 <= location && location < 4");
        }
    }
    // check is field "location" is valid
    private boolean validLocation() {return isValidLocation(location);}



    // DISTANCE GENERATORS


    // generates distance for all

    // starting method for generating distance to start
        // generates the distance from the start for all grid squares
        public static void generateDistFromStart() {
            boolean generatingDistances = true;
            int distancesGenerated = 0;
            do {
                distancesGenerated = 0;
                for (int x = 0; x < 4; x++) { // goes through x coords
                    for (int y = 0; y < 4; y++) { // goes through y coords
                        if (!(course[x][y].isNorthEdge())) { // checks to make sure that accessing a north square will not cause an error
                            if (
                               // checks that course[x][y] does not have a north barrier and that the GridSquare to the north does not have the default dist value
                               (!(course[x][y].hasNorthBarrier()) && course[x][y+1].getDistanceToStart() != -1) &&
                               // checks that course[x][y] is at the default dist value or has a higher dist value then the GridSquare to the north
                               (course[x][y].getDistanceToStart() == -1 || course[x][y+1].getDistanceToStart() < course[x][y].getDistanceToStart())
                            ) {
                                course[x][y].setDistanceToStart(course[x][y+1].getDistanceToStart() + 1);
                            }
                            
                        }
    
    
                        // LAST STEPS
                        // check if the current GridSquare has gotten its distance value (-1 = default, no distance)
                        if (course[x][y].getDistanceToStart() != -1) {
                            distancesGenerated += 1; // add 1 to distancesGenerated to show that another square has had its distance set
                            // checks to see if distances generated has reached 16
                            if (16 <= distancesGenerated) {
                                // sets generating Distances to false to show that it is done
                                generatingDistances = false;
                                
                            }
                        }
    
                    }
                }
            } while (generatingDistances);
        }

    // helper method for generating distance from start
    protected boolean generateDistFromStart(directions cameFrom) {
        if (cameFrom != directions.SOUTH && !(barriers[0])) {

        }
        return false;
    }
    


    // SPECIAL


    // returns a string to display the grid square 
    public static String printGridDisplay(interiorDisplaySelector displaySelection) {
        String outputToPrint = "";
        String[] outputLines = new String[5];
        // each object has to be evaluated for east and north borders, col 0 also need west borders, row 0 also needs south borders, all must be be evalutated for distances, if 0, mark as [S]tart, Gate [A], Gate [B], Gate [V], [E]nd  
        for (int I = 3; I > -1; I--) {
            outputToPrint = String.format("%s%n%s", outputToPrint, "+   +   +   +");
            for (int i = 0; i < 4; i++) {
                if (course[I][i].distanceToStart == 0) {
                    outputToPrint = String.format("%s%s", " S ");
                } else if (course[I][i].distanceToStart == 0) {

                } else if (course[I][i].distanceToStart == 0) {
                    
                } else if (course[I][i].distanceToStart == 0) {
                    
                } else if (course[I][i].distanceToStart == 0) {
                    
                } else {

                }
            }
            outputToPrint = String.format("%s%n%s", outputToPrint, "+   +   +   +");
        }

        
        
        
        String displayOutput = "";
        String southBorder = "     ";
        String eastBorder = "     ";
        if (location[0] == 0) {
            southBorder = "|---|";
        }
        if (location[1] == 3) {
            eastBorder =  "|";
        }

        return String.format("%s%",
        "");
    }
}
