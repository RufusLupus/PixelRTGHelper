package PixelRTGHelper;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
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
    private ListProperty<MarkPoint> markPointsProperty;

    public ObservableList<MarkPoint> getPoints() {
        return observablePoints;
    }

    public MarkPointContext() {
        markPoints = new ArrayList<MarkPoint>();
        observablePoints = FXCollections.observableList(markPoints);
        markPointsProperty = new SimpleListProperty<MarkPoint>(observablePoints);
    }

    public void registerListener(ListChangeListener listener) {
        observablePoints.addListener(listener);

    }

    public ListProperty<MarkPoint> getMarkPointsProperty() {
        return markPointsProperty;
    }
}
