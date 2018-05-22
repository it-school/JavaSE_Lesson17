package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Plot builder");

/*        primaryStage.setScene(new Scene(root, 800, 600));
        stage = primaryStage;
        primaryStage.show();
*/
        NumberAxis xAxis = new NumberAxis(-10, 10, 1);
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("Y");
        ScatterChart<String, Number> scatter = new ScatterChart(xAxis, yAxis);
        scatter.getXAxis().setLabel("X");
        scatter.getYAxis().setLabel("Y");
        scatter.setTitle("A*X^2 + Y");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("x");

        double a = 1, b = 2;

        for (double x = -10; x<=10; x+=0.5)
            series1.getData().add(new XYChart.Data(x, a*x*x+b));

        scatter.getData().add(series1);

        Scene scene  = new Scene(scatter, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
