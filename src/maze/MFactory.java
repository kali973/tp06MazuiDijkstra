package maze;


import maze.model.MazeFactory;
import maze.model.MazeModel;

public class MFactory implements MazeFactory {

    @Override
    public MazeModel createMazeModel(int height, int width) {
        // TODO Auto-generated method stub

        return new Maze(height, width);
    }


}
