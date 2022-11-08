package com.example.telecom.paris.maze.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This menu item shall enable the user to generate a new com.example.telecom.paris.maze.
 * The user will have to prompt the dimensions of the com.example.telecom.paris.maze in a dialogue box
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class NewMazeMenuItem extends JMenuItem implements ActionListener {

    private final MazeEditor mazeEditor;

    public NewMazeMenuItem(MazeEditor drawingMaze) {
        super("Create a new  com.example.telecom.paris.maze");

        this.mazeEditor = drawingMaze;

        addActionListener(this);
    }


    @Override
    public final void actionPerformed(ActionEvent e) {
        mazeEditor.newMaze();
    }
}
