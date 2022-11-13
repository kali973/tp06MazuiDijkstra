package com.example.telecom.paris.maze.services;

import com.example.telecom.paris.maze.graph.Vertex;
import com.example.telecom.paris.maze.model.MazeBoxModel;

import java.io.PrintWriter;
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

        return maze.getSuccessors(this);
    }

    @Override
    public String getLabel() {

        return "(" + X + "," + Y + ")";
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    @Override
    public void setEmpty() {

        maze.createEmptyBox(X, Y);

    }

    @Override
    public boolean isWall() {

        return false;
    }

    @Override
    public void setWall() {

        maze.createWallBox(X, Y);

    }

    @Override
    public boolean isDeparture() {

        return false;
    }

    @Override
    public void setDeparture() {

        maze.createDepartureBox(X, Y);

    }

    @Override
    public boolean isArrival() {

        return false;
    }

    @Override
    public void setArrival() {

        maze.createArrivalBox(X, Y);
    }

    @Override
    public boolean belongsToShortestPath() {

        return this.maze.getshortestPaths().getShortestPath(maze.getDepartures(),
                maze.getarrival()).contains(this);
    }

    public abstract void writeCharTo(PrintWriter pw);
}