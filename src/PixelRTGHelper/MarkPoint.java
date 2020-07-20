package PixelRTGHelper;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class MarkPoint {
    private String name;
    private Point2D position;
    private Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
