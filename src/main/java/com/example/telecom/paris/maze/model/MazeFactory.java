package com.example.telecom.paris.maze.model;

/**
 * Interface providing a method to create a new <code>MazeModel</code>. Required by the com.example.telecom.paris.maze editor when the com.example.telecom.paris.maze dimensions must be changed.
 *
 * @author Dominique Blouin
 */
public interface MazeFactory {

    /**
     * Create a new com.example.telecom.paris.maze model object of the given height and width.
     *
     * @param height The number of rows of the new com.example.telecom.paris.maze.
     * @param width  The number of columns of the new com.example.telecom.paris.maze.
     * @return The newly created com.example.telecom.paris.maze model object. <code>null</code> if any of the parameters is less than 1.
     */
    MazeModel createMazeModel(int height, int width);
}
	