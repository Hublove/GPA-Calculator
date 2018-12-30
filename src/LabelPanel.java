import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.util.ArrayList;

public class LabelPanel extends VBox implements EventHandler<ActionEvent> {
    private ArrayList<MarkPanel> marks = new ArrayList<>();
    private ArrayList<Label> labels = new ArrayList<>();

    public LabelPanel() {
        labels.add(new Label("Mark Name"));
        labels.add(new Label("Mark (%)") );
        labels.add(new Label("Credit") );
        marks.add(new MarkPanel());
        marks.add(new MarkPanel());
        marks.add(new MarkPanel());
        this.update();
    }

    public void update() {
        this.getChildren().clear();
        GridPane titles = new GridPane();
        int counter = 0;
        for(Label label: labels) {
            label.setScaleX(1);
            label.setScaleY(1);
            label.setMinWidth(150);
            titles.add(label, counter , 0);
            counter++;
        }
        this.getChildren().add(titles);
        for (MarkPanel mark: marks) {
            this.getChildren().add(mark);
        }
        Button addButton = new Button("Add Mark");
        addButton.setOnAction(event -> addMark());
        this.getChildren().add(addButton);
    }

    public void addMark() {
        marks.add(new MarkPanel());
        this.update();
    }

    public double calculateAvgMark() {
//        ArrayList<Double> numMarks = new ArrayList<>();
        double total = 0;
        int div = 0;
        for (MarkPanel mark: marks) {
           total += mark.getMark();
           div++;
        }

        return total / div;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
