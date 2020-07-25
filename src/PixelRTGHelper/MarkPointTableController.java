package PixelRTGHelper;

import com.sun.javafx.css.converters.ColorConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.converter.DoubleStringConverter;

public class MarkPointTableController implements IMarkPointSharer {

    private MarkPointContext context;

    @FXML
    private TableView<MarkPoint> MarkPointTable;

    @FXML
    private TableColumn<MarkPoint, String> MarkPointTableName;
    @FXML
    private TableColumn<MarkPoint, Double> MarkPointTablePositionX;
    @FXML
    private TableColumn<MarkPoint, Double> MarkPointTablePositionY;
    @FXML
    private TableColumn<MarkPoint, Color> MarkPointTableColor;


    @FXML
    private ContextMenu MarkPointContextMenu;
    @FXML
    private MenuItem MarkPointContextMenuRemove;

    @FXML
    public void initialize() {
        setupTable();
        setupContextMenu();
    }
    private void setupTable() {
        MarkPointTableName.setCellValueFactory(new PropertyValueFactory<MarkPoint, String>("name"));
        MarkPointTableName.setCellFactory(TextFieldTableCell.forTableColumn());
        MarkPointTableName.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });
        MarkPointTableName.setEditable(true);

        MarkPointTablePositionX.setCellValueFactory(new PropertyValueFactory<MarkPoint, Double>("positionX"));
        MarkPointTablePositionX.setCellFactory(TextFieldTableCell.<MarkPoint, Double>forTableColumn(new DoubleStringConverter()));
        MarkPointTablePositionX.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPositionX(e.getNewValue());
        });
        MarkPointTablePositionX.setEditable(true);

        MarkPointTablePositionY.setCellValueFactory(new PropertyValueFactory<MarkPoint, Double>("positionY"));
        MarkPointTablePositionY.setCellFactory(TextFieldTableCell.<MarkPoint, Double>forTableColumn(new DoubleStringConverter()));
        MarkPointTablePositionY.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPositionY(e.getNewValue());
        });
        MarkPointTablePositionY.setEditable(true);

        MarkPointTableColor.setCellValueFactory(new PropertyValueFactory<MarkPoint, Color>("color"));
    }
    private void setupContextMenu() {
        MarkPointContextMenuRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MarkPointTable.getItems().remove(MarkPointTable.getSelectionModel().getSelectedItem());
            }
        });
    }

    @Override
    public void setContext(MarkPointContext context) {
        this.context = context;
        setBindings();
    }

    private void setBindings() {
        MarkPointTable.itemsProperty().bindBidirectional(context.markPointsProperty());
    }
}
