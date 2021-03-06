import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminNotification extends BorderPane {

    public static final double WIDTH = 591, HEIGHT = 429;

    public AdminNotification(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminNotificationUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((AdminNotificationController)fxmlLoader.getController()).setOldStage(stage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
