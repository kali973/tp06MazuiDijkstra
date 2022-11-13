package com.example.telecom.paris.maze.services;

import com.example.telecom.paris.maze.graph.*;
import com.example.telecom.paris.maze.graph.impl.BasicMinDistance;
import com.example.telecom.paris.maze.graph.impl.BasicShortestPaths;
import com.example.telecom.paris.maze.graph.impl.BasicVertexesSet;
import com.example.telecom.paris.maze.mazeReadingException.MazeReadingException;
import com.example.telecom.paris.maze.model.MazeBoxModel;
import com.example.telecom.paris.maze.model.MazeFactory;
import com.example.telecom.paris.maze.model.MazeModel;
import com.example.telecom.paris.maze.model.ModelObserver;
import lombok.SneakyThrows;

import javax.swing.*;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.telecom.paris.maze.ui.OpenFileMenuItem.height;

public class Maze implements Graph, MazeModel, Distance {
    private final Set<ModelObserver> observers;
    MBox[][] maze;
    private BufferedReader bufferRead;
    private MFactory mfactory;
    private ShortestPaths shortestPaths;
    private int length;
    private int width;
    private DBox departure;
    private ABox arrival;

    public Maze(int length, int width) {

        this.shortestPaths = new BasicShortestPaths();
        this.mfactory = new MFactory();
        this.observers = new HashSet<>();
        this.length = length;
        this.width = width;

        maze = new MBox[this.length][this.width];

        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {

                MBox Box = new EBox(i, j, this);
                maze[i][j] = Box;
            }
        }
    }

    @Override
    public Set<Vertex> getVertexes() {


        Set<Vertex> listVertex = new HashSet<Vertex>();
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                listVertex.add((Vertex) maze[i][j]);

            }

        }
        return listVertex;
    }

    @Override
    public Vertex getVertex(String label) {


        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; ) {
                if (maze[i][j].getLabel().equals(label)) ;
                notifyObservers();
                return (Vertex) maze[i][j];
            }
        }
        return null;
    }

    @Override
    public Set<Vertex> getSuccessors(Vertex vertex) {

        Set<Vertex> SuccVertex = new HashSet<Vertex>();
        MBox box = (MBox) vertex;

        int X = box.getX();
        int Y = box.getY();
        boolean fix;

        if ((X == 0) && (Y == 0)) {
            if (!(maze[X + 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X + 1][Y]);
            }
        }

        if ((X == 0) && (Y == 0)) {
            if (!(maze[X][Y + 1] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X][Y + 1]);
            }
        }

        if ((X == 0) && (Y == this.width)) {
            if (!(maze[X + 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X + 1][Y]);
            }
        }

        if ((X == 0) && (Y == this.width)) {
            if (!(maze[X][Y - 1] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X][Y - 1]);
            }
        }

        if ((X == this.width) && (Y == 0)) {
            if (!(maze[X][Y + 1] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X][Y + 1]);
            }
        }

        if ((X == this.width) && (Y == 0)) {
            if (!(maze[X - 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X - 1][Y]);
            }
        }

        if ((X == this.length) && (Y == this.width)) {
            if (!(maze[X - 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X - 1][Y]);
            }
        }

        if ((X == this.length) && (Y == this.width)) {
            if (!(maze[X][Y - 1] instanceof WBox)) {
                SuccVertex.add((Vertex) (maze[X][Y - 1]));
            }
        }

        for (int i = 1; i <= this.width - 1; i++) {
            if ((X == i) && (Y == 0) && (Y <= this.width)) {
                if (!(maze[i][Y] instanceof WBox)) {
                    SuccVertex.add((Vertex) maze[X - 1][Y]);
                    fix = (Y == 0) ? SuccVertex.add((Vertex) maze[X][Y]) : SuccVertex.add((Vertex) maze[X + 1][Y]);
                    SuccVertex.add((Vertex) maze[X][Y + 1]);
                }
            }
        }

        for (int i = 1; i <= this.length - 1; i++) {
            if ((X == 0) && (Y == i)) {
                if (!(maze[X][i] instanceof WBox)) {
                    fix = (Y == 0) ? SuccVertex.add((Vertex) maze[X][Y - 1]) : SuccVertex.add((Vertex) maze[X][Y]);
                    SuccVertex.add((Vertex) maze[X + 1][Y]);
                    fix = (Y == this.length) ? SuccVertex.add((Vertex) maze[X][Y + 1]) : SuccVertex.add((Vertex) maze[X][Y]);
                }
            }
        }

        for (int i = 1; i <= this.width - 1; i++) {
            if ((X == i) && (Y == this.length)) {
                if (!(maze[i][Y] instanceof WBox)) {
                    SuccVertex.add((Vertex) maze[X - 1][Y]);
                    SuccVertex.add((Vertex) maze[X][Y - 1]);
                    SuccVertex.add((Vertex) maze[X + 1][Y]);
                }
            }
        }

        for (int i = 1; i <= this.length - 1; i++) {
            if ((X == this.length) && (Y == i)) {
                if (!(maze[X][i] instanceof WBox)) {
                    SuccVertex.add((Vertex) maze[X][Y - 1]);
                    SuccVertex.add((Vertex) maze[X - 1][Y]);
                    SuccVertex.add((Vertex) maze[X][Y + 1]);
                }
            }
        }

        for (int i = 1; i <= this.length; i++) {
            for (int j = 1; j <= this.width; j++) {
                if ((X == i) && (Y == j)) {
                    if (!(maze[i][j] instanceof WBox)) {
                        fix = (Y == 0) ? SuccVertex.add((Vertex) maze[X][Y]) : SuccVertex.add((Vertex) maze[X][Y - 1]);
                        fix = (X == this.length - 1) ? SuccVertex.add((Vertex) maze[X][Y]) : SuccVertex.add((Vertex) maze[X + 1][Y]);
                        fix = (Y == this.length - 1) ? SuccVertex.add((Vertex) maze[X][Y]) : SuccVertex.add((Vertex) maze[X][Y + 1]);
                        fix = (X == 0) ? SuccVertex.add((Vertex) maze[X][Y]) : SuccVertex.add((Vertex) maze[X - 1][Y]);
                    }
                }
            }
        }
        return SuccVertex;
    }

    @Override
    public int getWidth() {

        return this.width;
    }

    @Override
    public int getHeigth() {

        return this.length;
    }

    @Override
    public MazeBoxModel getMazeBox(int rowIndex, int colIndex) {


        return this.maze[rowIndex][colIndex];

    }

    @Override
    public int getNumberOfBoxes() {

        return (this.length * this.width);
    }

    @Override
    public void clearMaze() {

        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {

                MBox Box = new EBox(i, j, this);
                maze[i][j] = Box;

            }
        }
        notifyObservers();
    }

    @Override
    public void clearShortestPath() {


        this.shortestPaths = new BasicShortestPaths();

        notifyObservers();
    }

    public boolean solve() {


        this.shortestPaths = Dijkstra.findShortestPaths(this, this.departure, this.arrival, new BasicVertexesSet(),
                new BasicMinDistance(), this);
        notifyObservers();

        if (shortestPaths.getShortestPath(departure, arrival).size() > 1) {
            notifyObservers();
            return true;
        } else {
            notifyObservers();
            return false;
        }
    }

    @Override
    public List<String> validate() {

        int departures = 0;
        int arrivals = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                if (maze[i][j].isDeparture()) {
                    departures++;
                }

                if (maze[i][j].isArrival()) {
                    arrivals++;
                }
            }
        }
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String mazeId) {

    }

    @Override
    public MazeFactory getMazeFactory() {


        return (MazeFactory) this.mfactory;
    }


    @Override
    public void addObserver(ModelObserver observer) {

        observers.add(observer);
    }

    @Override
    public boolean removeObserver(ModelObserver observer) {
        return observers.remove(observer);
    }

    @SneakyThrows
    @Override
    public void saveToTextFile(File file) {

        PrintWriter pw = null;

        JFrame jFrame = null;
        try {
            pw = new PrintWriter(file);
            jFrame = new JFrame();
            for (int lineNo = 0; lineNo < height; lineNo++) {
                MBox[] line = maze[lineNo];

                for (int colNo = 0; colNo < width; colNo++)
                    line[colNo].writeCharTo(pw);
                pw.println();
            }

            JOptionPane.showMessageDialog(jFrame, "Sauvegarde effectuée");

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jFrame, "Fichier non trouvé");
            System.err.println("Error class Maze,saveToTextFile:file not found \"" + file + "\"");

        } catch (SecurityException e) {
            JOptionPane.showMessageDialog(jFrame, "Probléme d'autorisations requises pour accéder à une ressource");
            System.err.println("error class Maze,saveToextFile: secrit exception \"" + file + "\"");


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jFrame, "Error : unknown error.");
            System.err.println("Error : unknown error.");
            ex.printStackTrace(System.err);

        } finally {
            if (pw != null) try {
                pw.close();
            } catch (Exception e) {
            }
        }
    }


    protected void notifyObservers() {
        for (final ModelObserver observer : observers) {
            observer.modelStateChanged();

        }

    }

    public void createEmptyBox(int i, int j) {
        this.maze[i][j] = new EBox(i, j, this);

        notifyObservers();
    }

    public void createWallBox(int i, int j) {
        this.maze[i][j] = new WBox(i, j, this);

        notifyObservers();
    }

    public void createDepartureBox(int i, int j) {
        this.departure = new DBox(i, j, this);
        this.maze[i][j] = departure;

        notifyObservers();

    }

    public void createArrivalBox(int i, int j) {
        this.arrival = new ABox(i, j, this);
        this.maze[i][j] = arrival;
        notifyObservers();

    }

    @Override
    public int getDistance(Vertex vertex1, Vertex vertex2) {

        if (vertex1.getSuccessors().contains(vertex2)) {
            notifyObservers();
            return 1;
        } else {
            notifyObservers();
            return 0;
        }
    }

    public ShortestPaths getshortestPaths() {

        return shortestPaths;
    }

    public DBox getDepartures() {

        return departure;

    }

    public ABox getarrival() {
        // TODO Auto-generated method
        return arrival;
    }

    @SneakyThrows
    public void initFromTextFile(File file) {
        FileInputStream fstream = new FileInputStream(file);
        bufferRead = new BufferedReader(new InputStreamReader(fstream));

        int heightLineNo = 0;
        String line = bufferRead.readLine();
        if (line != null) {
            width = line.length();
        }
        while (line != null) {
            line = bufferRead.readLine();
            heightLineNo++;
        }
        height = heightLineNo;
        JFrame jFrame = new JFrame();

        if (height == 0) {
            JOptionPane.showMessageDialog(jFrame, "labyrinthe sans solution résultat");
        }

        fstream.getChannel().position(0);
        bufferRead = new BufferedReader(new InputStreamReader(fstream));

        for (int lineNo = 0; lineNo < height; lineNo++) {
            line = bufferRead.readLine();

            if (line == null) {
                JOptionPane.showMessageDialog(jFrame, "Pas assez de ligne");
                throw new MazeReadingException(file.getName(), lineNo, "Pas assez de ligne");
            }
            if (line.length() < width) {
                JOptionPane.showMessageDialog(jFrame, "Ligne trop courte");
                throw new MazeReadingException(file.getName(), lineNo, "ligne trop court");
            }
            if (line.length() > width) {
                JOptionPane.showMessageDialog(jFrame, "Ligne trop longue");
                throw new MazeReadingException(file.getName(), lineNo, "ligne trop longue");
            }

            for (int colNo = 0; colNo < width; colNo++) {
                switch (line.charAt(colNo)) {
                    case 'D':
                        maze[lineNo][colNo] = new DBox(lineNo, colNo, this);
                        break;
                    case 'A':
                        maze[lineNo][colNo] = new ABox(lineNo, colNo, this);
                        break;
                    case 'W':
                        maze[lineNo][colNo] = new WBox(lineNo, colNo, this);
                        break;
                    case 'E':
                        maze[lineNo][colNo] = new EBox(lineNo, colNo, this);
                        break;
                    default:
                        JOptionPane.showMessageDialog(jFrame, "Caractére inconnu => mauvais fichier");
                        throw new MazeReadingException(file.getName(), lineNo, "Caractére inconnu" + maze[lineNo][colNo] + "'");

                }
            }
        }
        notifyObservers();
    }
}