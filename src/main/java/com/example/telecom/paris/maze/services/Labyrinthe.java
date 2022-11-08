package com.example.telecom.paris.maze.services;


import com.example.telecom.paris.maze.model.MazeModel;
import com.example.telecom.paris.maze.ui.MazeEditor;

public class Labyrinthe {
    public static void main(String[] args) {

        final MazeModel maze = new Maze(10, 10);

        new MazeEditor(maze);


    }
}
