package maze;

public class WBox extends MBox {


    public WBox(int x, int y, Maze maze) {
        super(x, y, maze);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isWall() {
        // TODO Auto-generated method stub
        return true;
    }

}