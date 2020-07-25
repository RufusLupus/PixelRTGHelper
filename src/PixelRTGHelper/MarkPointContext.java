package PixelRTGHelper;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class MarkPointContext {

    private ArrayList<MarkPoint> markPoints;
    private ObservableList<MarkPoint> observablePoints;
    private ListProperty<MarkPoint> markPointsProperty;

    private List<IImageListener> imageListeners;
    private Image currentImage;

    public ObservableList<MarkPoint> getPoints() {
        return observablePoints;
    }

    public MarkPointContext() {
        markPoints = new ArrayList<MarkPoint>();
        observablePoints = FXCollections.observableList(markPoints);
        markPointsProperty = new SimpleListProperty<MarkPoint>(observablePoints);
        imageListeners = new ArrayList<IImageListener>();
    }

    public void registerListener(ListChangeListener listener) {
        observablePoints.addListener(listener);
    }
    public void registerImageListener(IImageListener listener) {
        imageListeners.add(listener);
    }

    public ListProperty<MarkPoint> markPointsProperty() {
        return markPointsProperty;
    }

    public ObservableList getMarkPointsProperty() {
        return markPointsProperty.get();
    }

    public void setImage(Image image) {
        // theoretically java should dispose image after all references are gone
        currentImage = image;
        imageListeners.forEach(listener -> {
            listener.ImageChanged(currentImage);
        });
    }

    public Image getCurrentImage() {
        return currentImage;
    }
}
