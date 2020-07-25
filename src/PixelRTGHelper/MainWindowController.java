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
    private ImageMarkerController ImageMarkerTopLeftController;
    @FXML
    private ImageMarkerController ImageMarkerTopRightController;
    @FXML
    private ImageMarkerController ImageMarkerBottomLeftController;
    @FXML
    private ImageMarkerController ImageMarkerBottomRightController;

    private ArrayList<ImageMarkerController> imageMarkerControllers;

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
        imageMarkerControllers = new ArrayList<ImageMarkerController>();
        imageMarkerControllers.add(ImageMarkerTopLeftController);
        imageMarkerControllers.add(ImageMarkerTopRightController);
        imageMarkerControllers.add(ImageMarkerBottomLeftController);
        imageMarkerControllers.add(ImageMarkerBottomRightController);
    }
    private void setupSubcontrollersContext() {
        imageMarkerControllers.forEach((controller) -> controller.setContext(markPointContext));
        MarkPointTableController.setContext(markPointContext);
    }
}
