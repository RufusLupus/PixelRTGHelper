package PixelRTGHelper;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewerController {
    @FXML
    private ImageView ImageView;
    public void setImage(Image image){
        ImageView.setImage(image);
    }
}
