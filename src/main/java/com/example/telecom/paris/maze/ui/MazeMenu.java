package com.example.telecom.paris.maze.ui;

import javax.swing.*;

/**
 * This menu manages everything that has to do with the creation of mazes directly in the application.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class MazeMenu extends JMenu {

    public MazeMenu(MazeEditor drawingMaze) {
        super("Maze");

        add(new NewMazeMenuItem(drawingMaze));
        add(new ClearMazeMenuItem(drawingMaze));
        add(new InformationMazeMenuItem(drawingMaze));
        //add( new OQUEBEC(drawingMaze));
    }
}
