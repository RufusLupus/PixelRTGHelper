package PixelRTGHelper;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

public class MarkPointTableController {

    @FXML
    private TableColumn<MarkPoint, String> MarkPointTableName;
    @FXML
    private TableColumn<MarkPoint, Double > MarkPointTablePositionX;
    @FXML
    private TableColumn<MarkPoint, Double> MarkPointTablePositionY;

    @FXML
    public void initialize() {
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
    }
}
