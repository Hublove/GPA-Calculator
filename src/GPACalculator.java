import javafx.stage.Stage;
import javafx.application.Application;


public class GPACalculator extends Application{
    GPAModel model; // Model
    View view; // View + Controller

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        this.model = new GPAModel();
        this.view = new View(model, stage);
    }
}

