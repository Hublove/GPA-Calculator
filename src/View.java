import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final GPAModel gpaModel;

    public View(GPAModel model, Stage stage) {
        this.stage = stage;
        this.gpaModel = model;
        initUI(stage);
    }

    private void initUI(Stage stage) {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);

        TopMenu topMenu = new TopMenu();
        LabelPanel labelPanel = new LabelPanel();

        root.setLeft(new TermsPanel());
        topMenu.updateGPA(labelPanel);
        root.setCenter(labelPanel);
        root.setTop(topMenu);
        stage.setScene(scene);
        stage.setTitle("GPA Calculator");
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        
    }
}
