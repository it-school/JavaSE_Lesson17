package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
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
        NumberAxis yAxis = new NumberAxis(-100, 100, 10);
        yAxis.setLabel("Y");
        LineChart<String, Number> scatter = new LineChart(xAxis, yAxis);
        scatter.getXAxis().setLabel("X");
        scatter.getYAxis().setLabel("Y");
        scatter.setTitle("A*X^2 + Y");

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName("x");

        double a = 1, b = 2;

        for (double x = -10; x<=10; x+=0.5) {
            series1.getData().add(new XYChart.Data(x, a * x * x + b));
            series2.getData().add(new XYChart.Data(x, -a * x * x + b));
        }
        scatter.getData().addAll(series1, series2);
        //scatter.setStyle(".chart-legend-item{-fx-text-fill: #191970;");
        // Изменить стиль графика без исп. внешнего файла
        System.out.println(scatter.getStyle().toString());
        //  setStyle(".default-color0.chart-series-line { -fx-stroke: #FF0000; }");
        Scene scene  = new Scene(scatter, 800, 600);
        //scene.getStylesheets().add("sample/style.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
