package com.example.telecom.paris.maze.mazeReadingException;

public class MazeReadingException extends Exception {
    public MazeReadingException(String file, int lineNo, String errorMsg) {
        super("Error while reading Maze in" + file + "(" + lineNo + ")" + errorMsg);


    }


}
