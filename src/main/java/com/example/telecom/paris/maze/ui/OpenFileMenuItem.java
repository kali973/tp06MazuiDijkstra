package com.example.telecom.paris.maze.ui;

import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenFileMenuItem extends JMenuItem implements ActionListener {

    public static int width = 10;
    public static int height = 10;
    private final MazeEditor mazeEditor;
    private File repertoireCourant;

    public OpenFileMenuItem(MazeEditor drawingMaze) {
        super("Open from file");

        this.mazeEditor = drawingMaze;

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
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        int returnVal = chooser.showOpenDialog(mazeEditor);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            System.out.println("Vous avez choisi ce fichier : " + file.getName());
        }
        mazeEditor.getMaze().initFromTextFile(file);
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Veuillez ressaisir le point de départ et d'arrivée");

    }
}

