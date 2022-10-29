package maze.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This button allow the user to save the maze directly in the file from which it has been initialized, if such a file exists.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class SaveMenuItem extends JMenuItem implements ActionListener {
    private final MazeEditor mazeEditor;

    public SaveMenuItem(MazeEditor mazeEditor) {
        super("Save");

        this.mazeEditor = mazeEditor;

        addActionListener(this);

        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }
}