package com.example.telecom.paris.maze.services;

import java.io.PrintWriter;

public class DBox extends MBox {

    public DBox(int x, int y, Maze maze) {
        super(x, y, maze);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isDeparture() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void writeCharTo(PrintWriter pw) {

    }

}
