package com.example.telecom.paris.maze.services;

import java.io.PrintWriter;

public class ABox extends MBox {


    public ABox(int x, int y, Maze maze) {
        super(x, y, maze);

    }

    @Override
    public boolean isArrival() {

        return true;
    }

    @Override
    public void writeCharTo(PrintWriter pw) {

    }

}
