import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomepage extends BorderPane {

    //set the width and height of admin homepage
    public static final double WIDTH = 600, HEIGHT = 400;

    public AdminHomepage(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminHomepageUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((AdminHomepageController)fxmlLoader.getController()).setOldStage(stage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
