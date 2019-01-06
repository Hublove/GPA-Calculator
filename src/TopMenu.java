import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class TopMenu extends HBox implements EventHandler<ActionEvent> {
    Label Name, gpa;

    public TopMenu() {
        this.createTopMenu();
        this.update();
    }

    public void createTopMenu() {
        MenuBar menuBar = new MenuBar();
        Menu menu;
        MenuItem menuItem;

        // A menu for File

        menu = new Menu("File");

        menuItem = new MenuItem("New");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menuItem = new MenuItem("Open");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menuItem = new MenuItem("Save");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menu.getItems().add(new SeparatorMenuItem());

        menuItem = new MenuItem("Exit");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menuBar.getMenus().add(menu);

        // Another menu for Edit

        menu = new Menu("Edit");

        menuItem = new MenuItem("Cut");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menuItem = new MenuItem("Copy");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menuItem = new MenuItem("Paste");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menu.getItems().add(new SeparatorMenuItem());

        menuItem = new MenuItem("Undo");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menuItem = new MenuItem("Redo");
        menuItem.setOnAction(this);
        menu.getItems().add(menuItem);

        menuBar.getMenus().add(menu);
        this.getChildren().add(menuBar);

        this.Name = new Label();
        this.gpa = new Label();

        this.getChildren().addAll(Name, gpa);
    }

    public void updateGPA(LabelPanel panel) {
        this.gpa.setText(Double.toString(panel.calculateAvgMark()) + ": " + Double.toString(panel.calculateTotalWeight()));
    }

    public void update() {
        this.getChildren().clear();
        this.createTopMenu();

    }

    @Override
    public void handle(ActionEvent event) {

    }

}
