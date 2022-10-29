package maze;

public class EBox extends MBox {


    public EBox(int x, int y, Maze maze) {
        super(x, y, maze);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String toString() {
        return getLabel() + " " + "Empty" + " ";
    }

}
