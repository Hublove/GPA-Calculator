import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        this.gpaPanel = new GPAPanel(this.GPAModel);
        this.shapeChooserPanel = new ShapeChooserPanel(this);

        BorderPane root = new BorderPane();
        root.setTop(createMenuBar());
        root.setCenter(this.paintPanel);
        root.setLeft(this.shapeChooserPanel);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        
    }
}
