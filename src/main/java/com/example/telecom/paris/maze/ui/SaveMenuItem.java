package com.example.telecom.paris.maze.ui;

import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This button allow the user to save the com.example.telecom.paris.maze directly in the file from which it has been initialized, if such a file exists.
 *
 * @author Idris DELSOL
 */
@SuppressWarnings("serial")
public class SaveMenuItem extends JMenuItem implements ActionListener {
    private final MazeEditor mazeEditor;
    private File repertoireCourant;

    public SaveMenuItem(MazeEditor mazeEditor) {
        super("Save");

        this.mazeEditor = mazeEditor;

        addActionListener(this);

        setEnabled(true);
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent evt) {
        repertoireCourant = new File(".").getCanonicalFile();
        JFileChooser chooser = new JFileChooser(repertoireCourant + "/data");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "text only", "txt");
        chooser.setFileFilter(filter);
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        int returnVal = chooser.showSaveDialog(mazeEditor);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("Le fichier de sauvegarde est : " + file.getName());
            try {
                mazeEditor.getMaze().saveToTextFile(file);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mazeEditor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
