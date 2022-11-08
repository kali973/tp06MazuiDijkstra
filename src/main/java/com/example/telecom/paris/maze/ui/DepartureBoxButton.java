package com.example.telecom.paris.maze.ui;


import com.example.telecom.paris.maze.model.MazeBoxModel;

/**
 * If the user clicks a first time on the "DBoxButton", and then on a non-departure box, the box will turn to a departure box.
 * If he or she then click on the departure box, it will turn to an empty box.
 * If he or she click again on the "DBoxButton" and then on the com.example.telecom.paris.maze, nothing will happen.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class DepartureBoxButton extends AbstractBoxTypeRadioButton {

    public DepartureBoxButton(MazePanel mazeDrawingPanel) {
        super("Departure Box", mazeDrawingPanel);
    }

    @Override
    public void setBoxModelType(final MazeBoxModel boxModel) {
        if (!boxModel.isDeparture()) {
            boxModel.setDeparture();

            setModified(true);
        }
    }
}
