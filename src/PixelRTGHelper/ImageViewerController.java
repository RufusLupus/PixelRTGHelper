package PixelRTGHelper;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewerController {
    @FXML
    private ImageView ImageViewMain;
    public void setImage(Image image){
        ImageViewMain.setImage(image);
    }
}
