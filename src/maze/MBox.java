package maze;

import graph.Vertex;
import maze.model.MazeBoxModel;

import java.util.Set;


public abstract class MBox implements Vertex, MazeBoxModel {
    private int X;
    private int Y;
    private Maze maze;

    public MBox(int x, int y, Maze maze) {
        super();
        X = x;
        Y = y;
        this.maze = maze;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public Set<Vertex> getSuccessors() {
        // TODO Auto-generated method stub
        return maze.getSuccessors(this);
    }

    @Override
    public String getLabel() {
        // TODO Auto-generated method stub
        return "(" + X + "," + Y + ")";
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setEmpty() {
        // TODO Auto-generated method stub
        maze.createEmptyBox(X, Y);

    }

    @Override
    public boolean isWall() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setWall() {
        // TODO Auto-generated method stub
        maze.createWallBox(X, Y);

    }

    @Override
    public boolean isDeparture() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setDeparture() {
        // TODO Auto-generated method stub
        maze.createDepartureBox(X, Y);

    }

    @Override
    public boolean isArrival() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setArrival() {
        // TODO Auto-generated method stub
        maze.createArrivalBox(X, Y);
    }

    @Override
    public boolean belongsToShortestPath() {
        // TODO Auto-generated method stub
        return this.maze.getshortestPaths().getShortestPath(maze.getDepartures(),
                maze.getarrival()).contains(this);
    }
}