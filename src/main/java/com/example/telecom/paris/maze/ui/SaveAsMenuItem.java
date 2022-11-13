package com.example.telecom.paris.maze.ui;

import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

@SuppressWarnings("serial")
public class SaveAsMenuItem extends JMenuItem implements ActionListener {

    private final MazeEditor mazeEditor;
    private File repertoireCourant;

    public SaveAsMenuItem(MazeEditor mazeEditor) {
        super("Save As...");
        this.mazeEditor = mazeEditor;

        addActionListener(this);

        // TODO
        setEnabled(true);
    }

    @SneakyThrows
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
