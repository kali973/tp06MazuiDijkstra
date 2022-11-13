package com.example.telecom.paris.maze.services;

import com.example.telecom.paris.maze.model.MazeModel;
import com.example.telecom.paris.maze.ui.MazeEditor;
import org.junit.jupiter.api.Test;

class LabyrintheTest {

    @Test
    void main() {
        final MazeModel maze = new Maze(10, 10);

        new MazeEditor(maze);
    }
}