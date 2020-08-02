package SchoolSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application
{

    public static Integer screen_width = 1200;
    public static Integer screen_height = 900;

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("MainPage/main_page_design.fxml"));

        primaryStage.setResizable(false);

        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setScene(new Scene(root, screen_width, screen_height));

        primaryStage.show();

    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
