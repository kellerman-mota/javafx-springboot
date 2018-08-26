package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ResourceBundle;

@SpringBootApplication
public class Main extends Application {

    private static String[] mainArgs;

    private ConfigurableApplicationContext springContext;

    @Autowired
    private SpringFXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = fxmlLoader.load("/fxml/sample.fxml");
        primaryStage.setTitle(ResourceBundle.getBundle("bundle").getString("app.title"));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Override
    public void init() {

        springContext = SpringApplication.run(Main.class, mainArgs);

        springContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {

        super.stop();

        springContext.close();
    }


    public static void main(String[] args) {

        mainArgs = args;

        launch(args);
    }
}
