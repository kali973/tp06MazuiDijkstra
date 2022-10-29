package maze.ui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

@SuppressWarnings("serial")
public class OpenFileMenuItem extends JMenuItem implements ActionListener {

    private final MazeEditor mazeEditor;

    public OpenFileMenuItem(MazeEditor drawingMaze) {
        super("Open from file");

        this.mazeEditor = drawingMaze;

        addActionListener(this);

        // TODO
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser(); //This class enable us to open a file explorer for a more ergonomic design.
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "text only", "txt");
        chooser.setFileFilter(filter);
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        int returnVal = chooser.showOpenDialog(mazeEditor);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("You chose to open this file: " + file.getName());

        }
    }
}
