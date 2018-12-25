import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class GPACalculator {
    GPAModel model; // Model
    View view; // View + Controller

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.model = new GPAModel();

        // View + Controller
        this.view = new View(model, stage);
    }
}
}
