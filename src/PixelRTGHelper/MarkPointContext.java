package PixelRTGHelper;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MarkPointContext {
    private ArrayList<MarkPoint> markPoints;
    private ObservableList<MarkPoint> observablePoints;

    public ObservableList<MarkPoint> getPoints() {
        return observablePoints;
    }

    public MarkPointContext() {
        markPoints = new ArrayList<MarkPoint>();
        observablePoints = FXCollections.observableList(markPoints);
    }

    public void registerListener(ListChangeListener listener){
        observablePoints.addListener(listener);
    }

    /*public void AddPoint(double x, double y)
    {
        MarkPoint point = new MarkPoint();
        point.setPosition(new Point2D(x, y));
        point.setName("Some point");
        point.setColor(Color.AQUA);
        markPoints.add(point);
    }*/
}
