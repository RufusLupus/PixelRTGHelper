package PixelRTGHelper;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewerController implements IMarkPointSharer {

    private MarkPointContext context;

    @FXML
    private ImageView ImageView;
    public void setImage(Image image){
        ImageView.setImage(image);
    }

    @Override
    public void setContext(MarkPointContext context) {
        this.context = context;
        this.context.registerListener(new ListChangeListener() {
            @Override
            public void onChanged(Change change) {

            }
        });
    }
    private void updateVisiblePoints() {

    }

    private void addPoint(double x, double y){
        System.out.println("pos: " + x + ", " + y);
    }

    @FXML
    public void initialize() {
        ImageView.setOnMouseClicked( (e) -> {
            addPoint(e.getX(), e.getY());
        });
    }
}