package maze;


import maze.model.MazeModel;
import maze.ui.MazeEditor;


public class main {
    public static void main(String[] args) {

        final MazeModel maze = new Maze(10, 10);

        new MazeEditor(maze);


    }
}
