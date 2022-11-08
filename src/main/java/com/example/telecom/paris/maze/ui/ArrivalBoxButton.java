package com.example.telecom.paris.maze.ui;


import com.example.telecom.paris.maze.model.MazeBoxModel;

import java.awt.event.ActionListener;

/**
 * If the user clicks a first type on the "ABoxButton", and then on a non-arrival box, the box will turn to an arrival box.
 * If he or she then click on an arrival Box, it will turn to an empty box.
 * If he or she click again on the "ABoxButton" and then on the com.example.telecom.paris.maze, nothing will happen.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class ArrivalBoxButton extends AbstractBoxTypeRadioButton implements ActionListener {
    public ArrivalBoxButton(final MazePanel mazePanel) {
        super("Arrival Box", mazePanel);
    }

    @Override
    public void setBoxModelType(final MazeBoxModel boxModel) {
        if (!boxModel.isArrival()) {
            boxModel.setArrival();

            setModified(true);
        }
    }
}
