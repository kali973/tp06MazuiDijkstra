package maze;


import maze.model.MazeModel;
import maze.ui.MazeEditor;


public class main {
    public static void main(String[] args) {

        //Maze maze = new Maze(3,3);

        final MazeModel maze = new Maze(10, 10);


        new MazeEditor(maze);


    }
}
