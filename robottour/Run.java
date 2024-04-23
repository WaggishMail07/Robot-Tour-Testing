package robottour;


import robottour.grid.DefaultGridSquare;
import robottour.grid.GridSquare;


public class Run {
    public static void main(String[] args) {
        try {
            DefaultGridSquare.createDefaultGrid();
    } catch (IllegalAccessError e) {
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println(e.getStackTrace());
    }
    }
}