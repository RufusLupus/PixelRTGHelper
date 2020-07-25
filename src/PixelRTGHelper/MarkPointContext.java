package PixelRTGHelper;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.omg.CORBA.Current;
import sun.plugin.com.event.ListenerProxy;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MarkPointContext {

    private ArrayList<MarkPoint> markPoints;
    private ObservableList<MarkPoint> observablePoints;
    private ListProperty<MarkPoint> markPointsProperty;

    private List<ImageListener> imageListeners;
    private Image currentImage;

    public ObservableList<MarkPoint> getPoints() {
        return observablePoints;
    }

    public MarkPointContext() {
        markPoints = new ArrayList<MarkPoint>();
        observablePoints = FXCollections.observableList(markPoints);
        markPointsProperty = new SimpleListProperty<MarkPoint>(observablePoints);
        imageListeners = new ArrayList<ImageListener>();
    }

    public void registerListener(ListChangeListener listener) {
        observablePoints.addListener(listener);
    }
    public void registerImageListener(ImageListener listener) {
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
