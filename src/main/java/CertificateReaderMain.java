import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import storage.CertEntry;

public class CertificateReaderMain extends Application {

    static ListView<String> listView = new ListView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        Button buttonCreate = new Button("Create Certificate");
        Button buttonRead = new Button("Read Certificate");
        TextArea textAreaShow = new TextArea("Show Certificate");
        TextArea textAreaList = new TextArea("List Certificate");

        // Создание GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5); // Горизонтальный отступ между столбцами
        gridPane.setVgap(5);
        // Размещение TextArea в GridPane
        gridPane.add(textAreaList, 0, 0);
        gridPane.add(textAreaShow, 1, 0);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();

        // Определение относительных ширин столбцов
        column1.setPercentWidth(30);
        column2.setPercentWidth(70);

        gridPane.getColumnConstraints().addAll(column1, column2);

        RowConstraints row1 = new RowConstraints(); // Добавляем ограничение для строки
        row1.setVgrow(Priority.ALWAYS); // Размещаем кнопки в нижней части GridPane
        gridPane.getRowConstraints().add(row1);

        HBox hBoxButton = new HBox(buttonRead, buttonCreate);
        gridPane.add(hBoxButton, 0, 1, 2, 1); // Добавляем кнопки в дополнительную строку

        pane.setCenter(gridPane);

        buttonRead.setOnAction(e -> {
            textAreaShow.setText(CertificateReader.openCertificate(listView, primaryStage));
        });

        //настройки сцены
        Scene scene = new Scene(pane, 800, 800);
        primaryStage.setTitle("Certificate Reader");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        //primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
