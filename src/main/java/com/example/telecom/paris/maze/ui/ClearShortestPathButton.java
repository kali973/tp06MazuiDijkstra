package com.example.telecom.paris.maze.ui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This button clears the shortest path given by the Dijkstra algorithm.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class ClearShortestPathButton extends JButton implements ActionListener {

    private final MazeEditor mazeEditor;

    public ClearShortestPathButton(MazeEditor mazeEditor) {
        super("Clear Shortest Path");

        this.mazeEditor = mazeEditor;

        addActionListener(this);
    }

    @Override
    public final void actionPerformed(ActionEvent e) {
        mazeEditor.getMaze().clearShortestPath();

        mazeEditor.setModified(true);
    }
}
