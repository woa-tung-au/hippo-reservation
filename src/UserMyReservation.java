import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserMyReservation extends BorderPane {

    public static final double WIDTH = 600, HEIGHT = 400;

    public UserMyReservation(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserMyReservationUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((UserMyReservationController) fxmlLoader.getController()).setOldStage(stage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}