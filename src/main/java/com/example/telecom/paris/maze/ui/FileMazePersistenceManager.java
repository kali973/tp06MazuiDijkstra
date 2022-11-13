package com.example.telecom.paris.maze.ui;

import com.example.telecom.paris.maze.model.MazeModel;
import com.example.telecom.paris.maze.model.MazePersistenceManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileMazePersistenceManager implements MazePersistenceManager {

    private final char BOX_DEPARTURE = 'D';
    private final char BOX_ARRIVAL = 'A';
    private final char BOX_WALL = 'W';
    private final char BOX_EMPTY = 'E';
    private final FileNameExtensionFilter filter;
    private Component editor;

    public FileMazePersistenceManager() {
        this.editor = null;
        filter = new FileNameExtensionFilter("Maze files only (*.maze)", "maze");
    }

    public void setEditor(Component editor) {
        this.editor = editor;
    }

    @Override
    public MazeModel read(String mazeId)
            throws IOException {
        if (mazeId == null || mazeId.isEmpty()) {
            final JFileChooser chooser = new JFileChooser(); //This class enable us to open a file explorer for a more ergonomic design.
            chooser.setFileFilter(filter);
            chooser.setDialogType(JFileChooser.OPEN_DIALOG);

            final int returnVal = chooser.showOpenDialog(editor);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                final File file = chooser.getSelectedFile();
                mazeId = file.getPath();
            } else {
                throw new IOException("No file selected!");
            }
        }

        return doRead(mazeId);
    }


    protected MazeModel doRead(final String mazeId)
            throws IOException {
        // TODO: Implement
        return null;
    }

    @Override
    public void persist(final MazeModel mazeModel)
            throws IOException {
        String mazeId = mazeModel.getId();

        if (mazeId == null || mazeId.isEmpty()) {
            mazeId = newMazeId();

            if (mazeId == null || mazeId.isEmpty()) {
                throw new IOException("No file path was choosen!");
            }

            mazeModel.setId(mazeId);
        }

        doPersist(mazeModel);
    }

    protected void doPersist(final MazeModel mazeModel)
            throws IOException {
        // TODO: Implement
    }

    @Override
    public boolean delete(MazeModel mazeModel)
            throws IOException {
        return new File(mazeModel.getId()).delete();
    }

    private String newMazeId() {
        final JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        final int returnVal = chooser.showSaveDialog(editor);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final File file = chooser.getSelectedFile();

            return file.getPath();
        }

        return null;
    }
}
