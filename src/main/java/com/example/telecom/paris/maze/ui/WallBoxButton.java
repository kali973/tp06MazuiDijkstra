package com.example.telecom.paris.maze.ui;


import com.example.telecom.paris.maze.model.MazeBoxModel;

/**
 * If the user clicks a first type on the "WBoxButton", and then on a non-wall box, the box will turn to a wall box.
 * If he or she then click on a wall box, it will turn to an empty box.
 * If he or she click again on the "WBoxButton" and then on the com.example.telecom.paris.maze, nothing will happen.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class WallBoxButton extends AbstractBoxTypeRadioButton {

    public WallBoxButton(MazePanel mazePanel) {
        super("Wall Box", mazePanel);
    }

    @Override
    public void setBoxModelType(final MazeBoxModel boxModel) {
        if (!boxModel.isWall()) {
            boxModel.setWall();

            setModified(true);
        }
    }
}
