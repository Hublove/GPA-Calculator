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
    public View view;

    public LabelPanel(View view) {
        this.view = view;
        labels.add(new Label("Mark Name"));
        labels.add(new Label("Mark (%)") );
        labels.add(new Label("Weight") );
        marks.add(new MarkPanel(view));
        marks.add(new MarkPanel(view));
        marks.add(new MarkPanel(view));
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
        this.calculateAvgMark();
        this.calculateTotalWeight();
    }

    public void addMark() {
        marks.add(new MarkPanel(this.view));
        this.update();
    }

    public void removeMark(MarkPanel mark) {
        marks.remove(mark);
        mark.update();
        mark.getChildren().clear();
    }

    public double calculateAvgMark() {
        double total = 0;

        if (marks.isEmpty())
            return 0;

        for (MarkPanel mark: marks) {
            if (mark.getMark() != null && mark.getWeight() != null) {
                total += mark.getMark() * (mark.getWeight() / 100);
            }
        }

        return total;
    }

    public double calculateTotalWeight() {
        double totalWeight = 0;

        if (marks.isEmpty())
            return 0;

        for (MarkPanel mark: marks) {
            if (mark.getMark() != null && mark.getWeight() != null) {
                totalWeight += mark.getWeight();
            }
        }

        return totalWeight;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
