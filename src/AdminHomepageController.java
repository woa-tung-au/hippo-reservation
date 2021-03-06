
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;

public class AdminHomepageController {

    private Stage oldStage = null;

    @FXML
    private Button notificationButton;

    @FXML
    private Button reservationManagementButton;

    @FXML
    private Button memberOverviewButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Label adminNameLabel;

    @FXML
    void logOutClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new LogIn(stage), LogIn.WIDTH, LogIn.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("登录");
        stage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                // 对话框 Alert Alert.AlertType.CONFIRMATION
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                // 设置对话框标题
                alert.setTitle("退出");
                // 设置内容
                alert.setHeaderText("确定要退出吗？");
                // 显示对话框
                Optional<ButtonType> result = alert.showAndWait();
                // 如果点击OK
                if (result.get() == ButtonType.OK) {
                    // 关闭窗体
                    stage.close();
                    // 否则
                } else {
                    event.consume();
                }
            }
        });
        // 隐藏之前的窗体
        oldStage.hide();
    }

    @FXML
    void memberOverviewClick(ActionEvent event) {
        // 创建新的窗体
        Stage stage = new Stage();
        Scene scene = new Scene(new MemberOverview(stage), MemberOverview.WIDTH, MemberOverview.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("会员一览");
        stage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(event1 -> {
            // 对话框 Alert Alert.AlertType.CONFIRMATION
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            // 设置对话框标题
            alert.setTitle("退出");
            // 设置内容
            alert.setHeaderText("确定要退出吗？");
            // 显示对话框
            Optional<ButtonType> result = alert.showAndWait();
            // 如果点击OK
            if (result.get() == ButtonType.OK) {
                // 关闭窗体
                stage.close();
                // 否则
            } else {
                event1.consume();
            }
        });
        // 隐藏之前的窗体
        oldStage.hide();
    }

    @FXML
    void notificationClick(ActionEvent event) {
        // 创建新的窗体
        Stage stage = new Stage();
        Scene scene = new Scene(new AdminNotification(stage), AdminNotification.WIDTH, AdminNotification.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("消息通知");
        stage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(event1 -> {
            // 对话框 Alert Alert.AlertType.CONFIRMATION
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            // 设置对话框标题
            alert.setTitle("退出");
            // 设置内容
            alert.setHeaderText("确定要退出吗？");
            // 显示对话框
            Optional<ButtonType> result = alert.showAndWait();
            // 如果点击OK
            if (result.get() == ButtonType.OK) {
                // 关闭窗体
                stage.close();
                // 否则
            } else {
                event1.consume();
            }
        });
        // 隐藏之前的窗体
        oldStage.hide();
    }

    @FXML
    void reservationManagementClick(ActionEvent event) {
        // 创建新的窗体
        Stage stage = new Stage();
        Scene scene = new Scene(new ReservationManagement(stage), ReservationManagement.WIDTH, ReservationManagement.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("消息通知");
        stage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(event1 -> {
            // 对话框 Alert Alert.AlertType.CONFIRMATION
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            // 设置对话框标题
            alert.setTitle("退出");
            // 设置内容
            alert.setHeaderText("确定要退出吗？");
            // 显示对话框
            Optional<ButtonType> result = alert.showAndWait();
            // 如果点击OK
            if (result.get() == ButtonType.OK) {
                // 关闭窗体
                stage.close();
                // 否则
            } else {
                event1.consume();
            }
        });
        // 隐藏之前的窗体
        oldStage.hide();
    }

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

    @FXML
    void initialize() {
        assert notificationButton != null : "fx:id=\"notificationButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert reservationManagementButton != null : "fx:id=\"reservationManagementButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert memberOverviewButton != null : "fx:id=\"memberOverviewButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert adminNameLabel != null : "fx:id=\"adminNameLabel\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";

        adminNameLabel.setText(Main.currentMemberName);
    }
}
