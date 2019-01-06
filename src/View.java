import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final GPAModel gpaModel;
    LabelPanel labelPanel;
    TopMenu topMenu;

    public View(GPAModel model, Stage stage) {
        this.stage = stage;
        this.gpaModel = model;
        initUI(stage);
    }

    private void initUI(Stage stage) {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);

        topMenu = new TopMenu();
        labelPanel = new LabelPanel(this);

        root.setLeft(new TermsPanel());
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
