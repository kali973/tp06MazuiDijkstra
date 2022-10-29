package maze;

import graph.*;
import graph.impl.BasicMinDistance;
import graph.impl.BasicShortestPaths;
import graph.impl.BasicVertexesSet;
import maze.model.MazeBoxModel;
import maze.model.MazeFactory;
import maze.model.MazeModel;
import maze.model.ModelObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maze implements Graph, MazeModel, Distance {

    private final Set<ModelObserver> observers;
    MBox[][] maze;
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
                System.out.print(maze[i][j] + "\t");
            }

            System.out.println();
        }
    }

    @Override
    public Set<Vertex> getVertexes() {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        Set<Vertex> SuccVertex = new HashSet<Vertex>();
        MBox box = (MBox) vertex;

        int X = box.getX();
        int Y = box.getY();
        boolean fix;

        if ((X == 0) && (Y == 0)) {
            MBox closeBox = maze[X + 1][Y];
            if (!(maze[X + 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X + 1][Y]);
            }
        }

        if ((X == 0) && (Y == 0)) {
            MBox closeBox = maze[X][Y + 1];
            if (!(maze[X][Y + 1] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X][Y + 1]);
            }
        }

        if ((X == 0) && (Y == this.width)) {
            MBox closeBox = maze[X + 1][Y];
            if (!(maze[X + 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X + 1][Y]);
            }
        }

        if ((X == 0) && (Y == this.width)) {
            MBox closeBox = maze[X][Y - 1];
            if (!(maze[X][Y - 1] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X][Y - 1]);
            }
        }

        if ((X == this.width) && (Y == 0)) {
            MBox closeBox = maze[X][Y + 1];
            if (!(maze[X][Y + 1] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X][Y + 1]);
            }
        }

        if ((X == this.width) && (Y == 0)) {
            MBox closeBox = maze[X - 1][Y];
            if (!(maze[X - 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X - 1][Y]);
            }
        }

        if ((X == this.length) && (Y == this.width)) {
            MBox closeBox = maze[X - 1][Y];
            if (!(maze[X - 1][Y] instanceof WBox)) {
                SuccVertex.add((Vertex) maze[X - 1][Y]);
            }
        }

        if ((X == this.length) && (Y == this.width)) {
            MBox closeBox = maze[X][Y - 1];
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

        for (int i = 1; i <= this.length - 1; i++) { // right side
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
    } // fin getSuccessors

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return this.width;
    }

    @Override
    public int getHeigth() {
        // TODO Auto-generated method stub
        return this.length;
    }

    @Override
    public MazeBoxModel getMazeBox(int rowIndex, int colIndex) {
        // TODO Auto-generated method stub

        return this.maze[rowIndex][colIndex];

    }

    @Override
    public int getNumberOfBoxes() {
        // TODO Auto-generated method stub
        return (this.length * this.width);
    }

    @Override
    public void clearMaze() {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub

        this.shortestPaths = new BasicShortestPaths();

        notifyObservers();
    }

    public boolean solve() {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        List<String> msgErreur = new ArrayList<>();
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

        if (departures == 1 && arrivals == 1) {
            return msgErreur;
        }
        if (departures > 1 && arrivals == 1) {
            msgErreur.add("Renseigner 1 seule départ");
        }
        if (departures == 1 && arrivals > 1) {
            msgErreur.add("Renseigner 1 seule arrivée");
        }

        if (departures > 1 && arrivals > 1) {
            msgErreur.add("Renseigner 1 départ et 1 arrivée");
        }

        if (departures == 0 && arrivals == 0) {
            msgErreur.add("Renseigner 1 départ et 1 arrivée");
        }

        if (departures == 0 && arrivals > 1) {
            msgErreur.add("Renseigner 1 départ et 1 arrivée");
        }

        if (departures > 1 && arrivals == 0) {
            msgErreur.add("Renseigner 1 départ et 1 arrivée");
        }

        if (departures == 1 && arrivals == 0) {
            msgErreur.add("Renseigner 1 arrivée");
        }

        if (departures == 0 && arrivals == 1) {
            msgErreur.add("Renseigner 1 depart");
        }

        return msgErreur;
    }

    @Override
    public MazeFactory getMazeFactory() {
        // TODO Auto-generated method stub

        return (MazeFactory) this.mfactory;
    }


    @Override
    public void addObserver(ModelObserver observer) {


        observers.add(observer);

    }

    @Override
    public boolean removeObserver(ModelObserver observer) {


        return observers.remove(observer);
        // return false;
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
        // TODO Auto-generated method stub
        if (vertex1.getSuccessors().contains(vertex2)) {
            notifyObservers();
            return 1;
        } else {
            notifyObservers();
            return 0;
        }
    }

    public ShortestPaths getshortestPaths() {
        // TODO Auto-generated method stub
        return shortestPaths;
    }

    public DBox getDepartures() {
        // TODO Auto-generated method stub
        return departure;

    }

    public ABox getarrival() {
        // TODO Auto-generated method
        return arrival;
    }
}