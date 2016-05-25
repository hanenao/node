package akahane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n.akahane on 2016/05/25.
 */
public class Point {

    private String id = null;
    private List<Point> adjoinPoint = new ArrayList<>();
    private int totalCost = -1;
    private boolean done = false;
    private Point previousPoint = null;

    public Point(String id){
        this.id = id;
    }

    public void addPoint(Point to){
        this.adjoinPoint.add(to);
    }

    public List<Point> getAdjoinPoint() {
        return adjoinPoint;
    }

    public void setAdjoinPoint(List<Point> adjoinPoint) {
        this.adjoinPoint = adjoinPoint;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Point getPreviousPoint() {
        return previousPoint;
    }

    public void setPreviousPoint(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
