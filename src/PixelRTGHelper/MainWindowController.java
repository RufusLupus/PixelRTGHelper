package PixelRTGHelper;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class MainWindowController {


    private MarkPointContext markPointContext;

    @FXML
    private MarkPointTableController MarkPointTableController;

    @FXML
    private ImageViewerController ImageViewerTopLeftController;
    @FXML
    private ImageViewerController ImageViewerTopRightController;
    @FXML
    private ImageViewerController ImageViewerBottomLeftController;
    @FXML
    private ImageViewerController ImageViewerBottomRightController;

    private ArrayList<ImageViewerController> imageViewerControllers;

    @FXML
    public void initialize() {
        markPointContext = new MarkPointContext();
        setupImageMarkerControllers();
        setupSubcontrollersContext();
    }

    @FXML
    private VBox MainView;

    public void openImage() {
        FileChooser filePicker = new FileChooser();
        filePicker.setTitle("Open image");
        File file = filePicker.showOpenDialog(MainView.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        markPointContext.setImage(image);
    }
    private void setupImageMarkerControllers() {
        imageViewerControllers = new ArrayList<ImageViewerController>();
        imageViewerControllers.add(ImageViewerTopLeftController);
        imageViewerControllers.add(ImageViewerTopRightController);
        imageViewerControllers.add(ImageViewerBottomLeftController);
        imageViewerControllers.add(ImageViewerBottomRightController);
    }
    private void setupSubcontrollersContext() {
        imageViewerControllers.forEach((controller) -> controller.setContext(markPointContext));
        MarkPointTableController.setContext(markPointContext);
    }
}
