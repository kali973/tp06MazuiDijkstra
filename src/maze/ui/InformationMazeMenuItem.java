package maze.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu item that shows useful informations on the current maze.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class InformationMazeMenuItem extends JMenuItem implements ActionListener {

    private final MazeEditor mazeEditor;

    public InformationMazeMenuItem(MazeEditor mazeEditor) {
        super("Informations about the maze");

        this.mazeEditor = mazeEditor;

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int numberOfRows = mazeEditor.getMaze().getHeigth();
        int numberOfColumns = mazeEditor.getMaze().getWidth();
        String messageDimension = "This maze has dimension : " + numberOfRows + " x " + numberOfColumns;
        int numberOfBoxes = mazeEditor.getMaze().getNumberOfBoxes();
        String messageNumberOfBoxes = "This maze contains " + numberOfBoxes + " boxes with this distribution: ";

        String[] messageArray = {messageDimension, messageNumberOfBoxes};

        JOptionPane.showMessageDialog(mazeEditor,
                messageArray,
                "Informations about the maze",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
