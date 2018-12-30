import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TermsPanel extends VBox implements EventHandler<ActionEvent>{
    public static int yearNum;
    private ArrayList<TreeItem> yearsItems = new ArrayList<TreeItem>();
    private ArrayList<TreeItem> termItems = new ArrayList<TreeItem>();
    private TreeItem<String> root = new TreeItem<String>();
    private TreeView<String> treeView = new TreeView<>(root);

    HBox buttons = new HBox();

    public TermsPanel() {
        treeView.setShowRoot(false);
        //Control Buttons

        Button add = new Button("Add");
        add.setOnAction(this);
        Button remove = new Button("Remove");
        remove.setOnAction(event -> this.output());
        Button moveUp = new Button("Move Up");
        Button moveDown= new Button("Move Down");
        buttons.getChildren().addAll(add, remove, moveUp, moveDown);
        this.getChildren().addAll(buttons);

        this.addYear();
        this.addYear();

        this.update();
    }

    public void output() {
        for (TreeItem<String> year: root.getChildren()) {
            System.out.println(year);
            for (TreeItem<String> term: year.getChildren()) {
                System.out.println(term);
            }
        }
    }

    public void update() {
        this.getChildren().clear();
        root.getChildren().clear();
        this.getChildren().add(buttons);

        for (TreeItem<String> year: yearsItems) {
            int index = this.yearsItems.indexOf(year);
            year.setValue("Year: " + (index + 1));
            this.updateTerm(year);
            root.getChildren().add(year);
        }

        this.getChildren().add(treeView);
    }

    public void updateTerm(TreeItem<String> year) {
        termItems.clear();
        for (TreeItem<String> term: year.getChildren()) {
            termItems.add(term);

        }
        for (TreeItem<String> term2: termItems) {
            int index = this.termItems.indexOf(term2);
            term2.setValue("Term: " + (index + 1));


        }
    }

    public void addYear() {

        TreeItem<String> year = new TreeItem<String> ("Year: ");
        this.yearsItems.add(year);

        this.update();
    }

    public void addTerm(TreeItem year) {
        TreeItem<String> term = new TreeItem<String>("Term: ");
        year.getChildren().add(term);
        this.update();
    }



    @Override
    public void handle(ActionEvent event) {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

        if (item instanceof TreeItem) {
            for (TreeItem<String> year : yearsItems) {
                if (year == item) {
                    System.out.println(4);
                    this.addTerm(item);
                    yearsItems.set(yearsItems.indexOf(year), item);
                }
            }
        }
        else {
            this.addYear();
        }
    }
}

