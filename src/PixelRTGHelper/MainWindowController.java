package PixelRTGHelper;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;

public class MainWindowController {

    private Image CurrentImage;

    @FXML
    private ImageViewerController ImageViewerTopLeftController;
    @FXML
    private ImageViewerController ImageViewerTopRightController;
    @FXML
    private ImageViewerController ImageViewerBottomLeftController;
    @FXML
    private ImageViewerController ImageViewerBottomRightController;

    @FXML
    private VBox MainView;
    public void openImage() {
        FileChooser filePicker = new FileChooser();
        filePicker.setTitle("Open image");
        File file = filePicker.showOpenDialog(MainView.getScene().getWindow());
        if (CurrentImage != null) {
            // TODO: dispose
        }
        CurrentImage = new Image(file.toURI().toString());
        ImageViewerTopLeftController.setImage(CurrentImage);
        ImageViewerTopRightController.setImage(CurrentImage);
        ImageViewerBottomLeftController.setImage(CurrentImage);
        ImageViewerBottomRightController.setImage(CurrentImage);
    }
}
