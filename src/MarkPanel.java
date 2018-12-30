import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MarkPanel extends HBox implements EventHandler<ActionEvent> {
    Mark mark;
    TextField markVal, assignmentName;

    public MarkPanel() {
        this.mark = new Mark();

        assignmentName = new TextField();
        markVal = new TextField();
        ObservableList<String> creditOptions = FXCollections.observableArrayList("0.5", "1.0");
        ComboBox creditsBox = new ComboBox(creditOptions);
        creditsBox.setValue("0.5");
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> this.getChildren().clear());

        this.getChildren().addAll(assignmentName, markVal, creditsBox, removeButton);
    }

    public double getMark() {
        return this.mark.getMark();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == mark) {
            this.mark.setMark(Double.valueOf(this.markVal.getText()));
        }
    }
}
