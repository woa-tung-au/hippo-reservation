import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ResetPassword extends VBox {

	public static final double WIDTH = 461, HEIGHT = 185;

	public ResetPassword(String username) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResetPasswordUI.fxml"));
			this.getChildren().add(fxmlLoader.load());

			// 获得控制器对象,并把数据传给控制器对象
			((ResetPasswordController)fxmlLoader.getController()).setUsername(username);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

