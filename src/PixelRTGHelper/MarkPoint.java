package PixelRTGHelper;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MarkPoint {
    private StringProperty name;
    private DoubleProperty positionX;
    private DoubleProperty positionY;
    private ObjectProperty<Color> color;

    public MarkPoint() {
        this.name = new SimpleStringProperty("New point");
        this.positionX = new SimpleDoubleProperty(1.0);
        this.positionY = new SimpleDoubleProperty(1.0);
        this.color = new SimpleObjectProperty<>(Color.ALICEBLUE);
    }

    public MarkPoint(String name, double x, double y, Color color) {
        this.name = new SimpleStringProperty(name);
        this.positionX = new SimpleDoubleProperty(x);
        this.positionY = new SimpleDoubleProperty(y);
        this.color = new SimpleObjectProperty<>(color);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public DoubleProperty positionXProperty() {
        return positionX;
    }

    public DoubleProperty positionYProperty() {
        return positionY;
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        name.set(str);
    }

    public double getPositionX() {
        return positionX.get();
    }

    public void setPositionX(double x) {
        positionX.set(x);
    }

    public double getPositionY() {
        return positionY.get();
    }

    public void setPositionY(double y) {
        positionY.set(y);
    }

    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

}
