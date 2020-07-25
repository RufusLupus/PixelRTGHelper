package PixelRTGHelper;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collection;

public class ImageViewerController implements IMarkPointSharer {

    private MarkPointContext context;

    @FXML
    private Pane MarkPane;

    @FXML
    private ImageView ImageView;
    public void setImage(Image image){
        ImageView.setImage(image);
        MarkPane.setPrefSize(image.getWidth(), image.getHeight());
        MarkPane.setMaxSize(image.getWidth(), image.getHeight());
        MarkPane.setMinSize(image.getWidth(), image.getHeight());
    }

    @Override
    public void setContext(MarkPointContext context) {
        this.context = context;
        this.context.registerListener(new ListChangeListener() {
            @Override
            public void onChanged(Change change) {
                while(change.next()) {
                    if (change.wasAdded()) {
                        addPointCircle(context.getPoints().get(context.getPoints().size() - 1));
                    }
                    else if (change.wasRemoved()) {
                        Collection removedElements = change.getRemoved();
                        for (Object probablyMarkPoint : removedElements) {
                            if (probablyMarkPoint instanceof MarkPoint) {
                                MarkPoint markPoint = (MarkPoint)probablyMarkPoint;
                                removePointCircle(markPoint);
                            }
                        }
                    }
                }
            }
        });
    }

    private void addPoint(double x, double y) {
        System.out.println("pos: " + x + ", " + y);
        MarkPoint point = new MarkPoint("Some new point", x, y);
        context.getPoints().add(point);
    }

    private void addPointCircle(MarkPoint markPoint) {
        MarkPointCircle.Create(markPoint, MarkPane);
    }
    private void removePointCircle(MarkPoint markPoint) {
        // ugly way but works
        ArrayList<MarkPointCircle> pointsToRemove = new ArrayList<MarkPointCircle>();
        /*MarkPane.getChildren().forEach(child -> {
            MarkPointCircle markPointCircle = (MarkPointCircle)child;
            if (markPointCircle != null)
            {
                pointsToRemove.add(markPointCircle);
            }
        });*/
        MarkPane.getChildren().removeIf(node -> {
            if (node instanceof MarkPointCircle) {
                MarkPointCircle markPointCircle = (MarkPointCircle) node;
                if (markPointCircle.getMarkPoint() == markPoint)
                    return true;
                else
                    return false;
            }
            else
                return false;
        });
    }

    @FXML
    public void initialize() {
        ImageView.setOnMouseClicked( (e) -> {
            addPoint(e.getX(), e.getY());
        });
    }
}