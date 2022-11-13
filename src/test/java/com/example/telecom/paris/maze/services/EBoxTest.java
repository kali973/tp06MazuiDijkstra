package com.example.telecom.paris.maze.services;

import org.junit.Test;

public class EBoxTest {
    @Test
    public void EBox() {
        int x = 7;
        int y = 7;
        Maze maze = new Maze(5, 5);
        EBox actual = new EBox(x, y, maze);
    }
}
