package maze.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This item shall enable the user to set the type of all the boxes of the maze to EBox
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class ClearMazeMenuItem extends JMenuItem implements ActionListener {

    private final MazeEditor mazeEditor;

    public ClearMazeMenuItem(final MazeEditor mazeEditor) {
        super("Clear the present maze");

        this.mazeEditor = mazeEditor;

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        mazeEditor.getMaze().clearMaze();

        mazeEditor.setModified(true);
    }
}
