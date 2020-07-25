package PixelRTGHelper;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class MainWindowController {

    private Image CurrentImage;
    private MarkPointContext markPointContext;

    @FXML
    private TableView MarkPointTable;
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
    public void initialize(){
        imageViewerControllers = new ArrayList<ImageViewerController>();
        imageViewerControllers.add(ImageViewerTopLeftController);
        imageViewerControllers.add(ImageViewerTopRightController);
        imageViewerControllers.add(ImageViewerBottomLeftController);
        imageViewerControllers.add(ImageViewerBottomRightController);
        markPointContext = new MarkPointContext();
        imageViewerControllers.forEach((controller) -> controller.setContext(markPointContext));
        MarkPointTable.setItems(markPointContext.getPoints());
        //MarkPointTable.itemsProperty().bindBidirectional(markPointContext.getPoints());
    }

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
        imageViewerControllers.forEach((controller) -> controller.setImage(CurrentImage));
    }
}
