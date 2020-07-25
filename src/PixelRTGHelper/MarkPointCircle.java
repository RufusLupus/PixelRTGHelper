package PixelRTGHelper;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
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
        markPointCircle.centerXProperty().bindBidirectional(markPoint.positionXProperty());
        markPointCircle.centerYProperty().bindBidirectional(markPoint.positionYProperty());

        markPointCircle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                markPointCircle.setPosition(e.getX(), e.getY());
            }
        });

        parentPane.getChildren().add(markPointCircle);

        return markPointCircle;
    }


    private void setPosition(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);
    }

    public MarkPoint getMarkPoint() {
        return markPoint;
    }
}
