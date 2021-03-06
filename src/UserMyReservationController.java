import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UserMyReservationController {
    ResultSet reservationRS;

    private Stage oldStage = null;
    @FXML
    private ResourceBundle resources;
    @FXML
    private TableColumn<MyReservation,String> number;

    @FXML
    private TableColumn<MyReservation,Date> date;

    @FXML
    private TableColumn<MyReservation,String> time;

    @FXML
    private TableColumn<MyReservation,String> situation;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private Button revokeButton;

    @FXML
    private TableView<MyReservation> myReservationTable;

    @FXML
    void returnClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new UserHomepage(stage), UserHomepage.WIDTH, UserHomepage.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("用户主页");
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
    void revokeClick(ActionEvent event) {
        myReservationTable.setOnMouseClicked(e->{
            myReservationTable.setEditable(true);
            int index=myReservationTable.getSelectionModel().getSelectedIndex();
            if(index!=-1){
                myReservationTable.getItems().remove(index);
            }
        });
    }

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert  number != null : "fx:id=\"Number\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert  date != null : "fx:id=\"Date\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert  time != null : "fx:id=\"Time\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert  situation != null : "fx:id=\"Situation\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert revokeButton != null : "fx:id=\"revokeButton\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert myReservationTable != null : "fx:id=\"myReservationTable\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        String time;
        int number;
        Date date;
        reservationRS = null;
        try {
            reservationRS = Main.statement.executeQuery("SELECT * FROM reservation");
            while(reservationRS.next()){
                time=reservationRS.getString("time");
                date=reservationRS.getDate("date");
                number=reservationRS.getInt("gym_number");
                ObservableList<MyReservation> obsList = FXCollections.observableArrayList();
                obsList.add(new MyReservation(number,date,time));
                myReservationTable.setItems(obsList);
                this.number.setCellValueFactory(new PropertyValueFactory<MyReservation, String>("number"));
                this.date.setCellValueFactory(new PropertyValueFactory<MyReservation, Date>("date"));
                this.time.setCellValueFactory(new PropertyValueFactory<MyReservation, String>("time"));
            }
            reservationRS.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
