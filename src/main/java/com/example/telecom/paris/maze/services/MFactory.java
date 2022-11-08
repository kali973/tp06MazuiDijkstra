package com.example.telecom.paris.maze.services;


import com.example.telecom.paris.maze.model.MazeFactory;
import com.example.telecom.paris.maze.model.MazeModel;

public class MFactory implements MazeFactory {

    @Override
    public MazeModel createMazeModel(int height, int width) {
        // TODO Auto-generated method stub

        return new Maze(height, width);
    }

}
