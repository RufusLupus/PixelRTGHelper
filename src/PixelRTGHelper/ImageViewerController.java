package PixelRTGHelper;

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
    }
}