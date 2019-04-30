package org.cth.dsaa;

public class Start {
    public static void main(String[] args){
        Maze demo = new Maze();
//        demo.init();
//        demo.findPath();

        int[][] maze = {{0,0,1,0,0,0,1,0},
                        {1,0,1,0,0,0,1,0},
                        {0,0,0,1,0,1,1,0},
                        {1,1,0,1,1,0,0,1},
                        {1,0,0,0,1,0,0,0},
                        {0,0,1,0,0,0,1,0},
                        {1,0,1,1,1,1,0,0},
                        {1,1,1,0,0,1,0,1},
                        {1,1,1,0,0,0,0,0}};
        int row = 9;
        int col = 8;
        demo.init(row,col,maze);
        demo.findPath();
    }
}
