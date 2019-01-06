import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MarkPanel extends HBox implements EventHandler<ActionEvent> {
    Mark mark;
    TextField markVal, assignmentName, weight;
    View view;

    public MarkPanel(View view) {
        this.mark = new Mark();
        this.view = view;

        //ADD ASSIGNMENT WORTH FEATURES
        assignmentName = new TextField();
        markVal = new TextField();
        weight = new TextField();
        markVal.setOnKeyReleased(e -> {
            if (!this.markVal.getText().equals("")) {
                this.mark.setMark(Double.valueOf(this.markVal.getText()));
                this.update();
                this.view.labelPanel.update();
            }
        });
        weight.setOnKeyReleased(e -> {
            if (!this.markVal.getText().equals("")) {
                this.mark.setWeight(Double.valueOf(this.weight.getText()));
                this.update();
                this.view.labelPanel.update();
            }
        });

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> this.view.labelPanel.removeMark(this));

        this.getChildren().addAll(assignmentName, markVal, weight, removeButton);
    }

    public void update() {
        this.view.topMenu.updateGPA(this.view.labelPanel);
    }

    public Double getMark() {
        return this.mark.getMark();
    }

    public Double getWeight() {
        return this.mark.getWeight();
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
