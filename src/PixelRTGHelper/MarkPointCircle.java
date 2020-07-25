package PixelRTGHelper;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MarkPointCircle extends Circle {

    private Pane parentPane;
    private MarkPoint markPoint;

    private MarkPointCircle() {
        super(0, 0, 2);
    }

    public static MarkPointCircle Create(MarkPoint markPoint, Pane parentPane) {
        MarkPointCircle markPointCircle = new MarkPointCircle();
        markPointCircle.markPoint = markPoint;
        markPointCircle.parentPane = parentPane;
        markPointCircle.centerXProperty().bindBidirectional(markPoint.getPositionXProperty());
        markPointCircle.centerYProperty().bindBidirectional(markPoint.getPositionYProperty());
        markPointCircle.parentPane = parentPane;
        parentPane.getChildren().add(markPointCircle);

        return markPointCircle;
    }

    private void removeItself() {
        parentPane.getChildren().remove(this);
    }
}
