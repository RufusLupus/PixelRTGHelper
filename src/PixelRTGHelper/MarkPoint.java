package PixelRTGHelper;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class MarkPoint {
    private StringProperty name;
    private DoubleProperty positionX;
    private DoubleProperty positionY;

    public MarkPoint() {
        this.name = new SimpleStringProperty("New point");
        this.positionX = new SimpleDoubleProperty(1.0);
        this.positionY = new SimpleDoubleProperty(1.0);
    }
    public MarkPoint(String name, double x, double y) {
        this.name = new SimpleStringProperty(name);
        this.positionX = new SimpleDoubleProperty(x);
        this.positionY = new SimpleDoubleProperty(y);
    }

    public StringProperty getNameProperty() {
        return name;
    }
    public DoubleProperty getPositionXProperty() {
        return positionX;
    }
    public DoubleProperty getPositionYProperty() {
        return positionY;
    }
}
