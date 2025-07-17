import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import java.util.*;

public class ContactTracingApp_Animated extends Application {
    private Graph contactGraph = new Graph();
    private IoTSimulator simulator = new IoTSimulator(contactGraph);

    @Override
    public void start(Stage primaryStage) {
        contactGraph.addContact("192.168.0.1", "192.168.0.2");
        contactGraph.addContact("192.168.0.2", "192.168.0.3");

        simulator.startSimulation();

        Label sourceLabel = new Label("Source IP:");
        TextField sourceField = new TextField();
        Label targetLabel = new Label("Target IP:");
        TextField targetField = new TextField();
        Button traceButton = new Button("Trace Breach Path");
        Button showGraphButton = new Button("Show Contact Graph");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        Pane graphPane = new Pane();
        graphPane.setPrefSize(520, 200);
        graphPane.setStyle("-fx-border-color: black; -fx-background-color: #f4f4f4;");

        traceButton.setOnAction(e -> {
            String source = sourceField.getText().trim();
            String target = targetField.getText().trim();
            List<String> path = contactGraph.bfs(source, target);

            if (path.isEmpty() || !path.get(path.size() - 1).equals(target)) {
                resultArea.setText("No path found.");
                graphPane.getChildren().clear();
            } else {
                String log = "Malware breach path: " + path;
                String encryptedLog = Encryptor.encrypt(log);
                resultArea.setText("Encrypted: " + encryptedLog + "\nDecrypted: " + Encryptor.decrypt(encryptedLog));

                // Draw animated path
                graphPane.getChildren().clear();
                int radius = 25;
                int spacing = 100;
                int startX = 60;
                int startY = 100;

                for (int i = 0; i < path.size(); i++) {
                    String node = path.get(i);
                    double x = startX + i * spacing;

                    Circle circle = new Circle(x, startY, radius);
                    circle.setFill(Color.LIGHTSKYBLUE);
                    circle.setStroke(Color.DARKBLUE);

                    Text label = new Text(x - 30, startY + 40, node);
                    label.setStyle("-fx-font-size: 10;");

                    graphPane.getChildren().addAll(circle, label);

                    if (i > 0) {
                        Line line = new Line(
                            startX + (i - 1) * spacing, startY,
                            x, startY
                        );
                        line.setStroke(Color.GRAY);
                        line.setStrokeWidth(2);
                        graphPane.getChildren().add(line);
                    }
                }
            }
        });

        showGraphButton.setOnAction(e -> {
            StringBuilder graphText = new StringBuilder("Current Contact Graph:\n");
            for (Map.Entry<String, List<String>> entry : contactGraph.getAdjacencyList().entrySet()) {
                graphText.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
            }
            resultArea.setText(graphText.toString());
        });

        VBox inputBox = new VBox(10, sourceLabel, sourceField, targetLabel, targetField, traceButton, showGraphButton);
        VBox resultBox = new VBox(10, new Label("Trace Info:"), resultArea);
        VBox animationBox = new VBox(5, new Label("Animated Breach Path:"), graphPane);
        HBox layout = new HBox(15, inputBox, resultBox, animationBox);
        layout.setStyle("-fx-padding: 15; -fx-font-size: 14;");

        Scene scene = new Scene(layout, 1200, 400);
        primaryStage.setTitle("Cybersecurity Malware Tracing (With Animated Path)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
