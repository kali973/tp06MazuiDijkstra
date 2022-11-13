package com.example.telecom.paris.maze.services;

import org.junit.Test;

import java.io.PrintWriter;

public class MBoxTest {
    @Test
    public void MBox() {
        int x = 4;
        int y = 5;
        Maze maze = new Maze(5, 5);
        MBox expected = new MBox(x, y, maze) {
            @Override
            public void writeCharTo(PrintWriter pw) {

            }
        };
        Maze mazeTwo = new Maze(5, 5);
        MBox actual = new MBox(x, y, mazeTwo) {
            @Override
            public void writeCharTo(PrintWriter pw) {

            }
        };
    }
}
