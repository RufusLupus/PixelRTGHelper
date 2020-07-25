package PixelRTGHelper;

import javafx.beans.property.*;

public class MarkPoint {
    private StringProperty nameProperty;
    private DoubleProperty positionXProperty;
    private DoubleProperty positionYProperty;

    public MarkPoint() {
        this.nameProperty = new SimpleStringProperty("New point");
        this.positionXProperty = new SimpleDoubleProperty(1.0);
        this.positionYProperty = new SimpleDoubleProperty(1.0);
    }

    public MarkPoint(String name, double x, double y) {
        this.nameProperty = new SimpleStringProperty(name);
        this.positionXProperty = new SimpleDoubleProperty(x);
        this.positionYProperty = new SimpleDoubleProperty(y);
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public DoubleProperty getPositionXProperty() {
        return positionXProperty;
    }

    public DoubleProperty getPositionYProperty() {
        return positionYProperty;
    }

    public String getName() {
        return nameProperty.get();
    }

    public void setName(String str) {
        nameProperty.set(str);
    }

    public double getPositionX() {
        return positionXProperty.get();
    }

    public void setPositionX(double x) {
        positionXProperty.set(x);
    }

    public double getPositionY() {
        return positionYProperty.get();
    }

    public void setPositionY(double y) {
        positionYProperty.set(y);
    }

}
