package com.example.telecom.paris.maze.services;

import java.io.PrintWriter;

public class EBox extends MBox {


    public EBox(int x, int y, Maze maze) {
        super(x, y, maze);

    }

    @Override
    public boolean isEmpty() {

        return true;
    }

    @Override
    public void writeCharTo(PrintWriter pw) {

    }

    @Override
    public String toString() {
        return getLabel() + " " + "Empty" + " ";
    }

}
