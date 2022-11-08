package com.example.telecom.paris.maze.model;

import com.example.telecom.paris.maze.services.MBox;

import java.io.File;
import java.util.List;

/**
 * Interface providing various methods required for displaying a com.example.telecom.paris.maze in a com.example.telecom.paris.maze editor.
 *
 * @author Dominique Blouin
 */
public interface MazeModel {

    /**
     * Returns this com.example.telecom.paris.maze's width.
     *
     * @return The number of columns of this com.example.telecom.paris.maze.
     */
    int getWidth();

    /**
     * Returns this com.example.telecom.paris.maze's height.
     *
     * @return The number of rows of this com.example.telecom.paris.maze.
     */
    int getHeigth();

    /**
     * Returns the com.example.telecom.paris.maze box located at the specified coordinates.
     *
     * @param rowIndex The index of the row of required com.example.telecom.paris.maze box. The the index starts at 0 located on the top of the com.example.telecom.paris.maze and must be less than the com.example.telecom.paris.maze's height.
     * @param colIndex The index of the column of required com.example.telecom.paris.maze box. The the index starts at 0 located on the left of the com.example.telecom.paris.maze and must be less than the com.example.telecom.paris.maze's width.
     * @return The required com.example.telecom.paris.maze box model. <code>null</code> if the specified coordinates are invalid.
     */
    MazeBoxModel getMazeBox(int rowIndex,
                            int colIndex);

    /**
     * Returns the total number of boxes of this com.example.telecom.paris.maze.
     *
     * @return The heigth * width value
     */
    int getNumberOfBoxes();

    /**
     * Turns all the boxes of this com.example.telecom.paris.maze to empty boxes.
     */
    void clearMaze();

    /**
     * Erases the com.example.telecom.paris.maze's shortest path as computed when method <code>solve</code> was invoked on this com.example.telecom.paris.maze.
     */
    void clearShortestPath();

    /**
     * Computes the shortest path of this com.example.telecom.paris.maze and stores that information within this com.example.telecom.paris.maze.
     *
     * @return <code>true</code> if a solution path was found for this com.example.telecom.paris.maze, <code>false</code> otherwise.
     */
    boolean solve();

    /**
     * Check if this com.example.telecom.paris.maze is valid for being solved; there should be only one departure and arrival box.
     *
     * @return A list of error messages for each invalid property of this com.example.telecom.paris.maze. <code>null</code> or an empty list if this com.example.telecom.paris.maze is valid.
     */
    List<String> validate();

    /**
     * Returns a <code>MazeFactory</code> object responsible for instantiating com.example.telecom.paris.maze models. This is required when the dimensions of the
     * com.example.telecom.paris.maze should be changed so that the com.example.telecom.paris.maze editor can create a new com.example.telecom.paris.maze.
     *
     * @return A <code>MazeFactory</code> object
     */
    MazeFactory getMazeFactory();

    /**
     * Adds an observer (typically a com.example.telecom.paris.maze editor) to this com.example.telecom.paris.maze model so that it can be notified when this com.example.telecom.paris.maze changes to refresh the editor display.
     *
     * @param observer A <code>ModelObserver</code> object
     */
    void addObserver(ModelObserver observer);

    /**
     * Removes an observer (typically a com.example.telecom.paris.maze editor) to this com.example.telecom.paris.maze model. This observer will no longer be notified when this com.example.telecom.paris.maze changes.
     *
     * @param observer A <code>ModelObserver</code> object
     * @return <code>true</code> if this observer was actually removed, false otherwise.
     */
    boolean removeObserver(ModelObserver observer);

    void saveToTextFile(File file);

    MBox[][] initFromTextFile(File file);
}
