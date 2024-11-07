package be.ugent.memory;

import be.ugent.memory.model.DummyMemoryGame;
import be.ugent.memory.model.IMemoryGame;
import be.ugent.memory.model.MemoryGame;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;


public class MemoryView extends Application {
    private IMemoryGame gameModel;
    private Button[][] cardButtons;
    private Label movesLabel;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showTitleScreen();
    }

    private void showTitleScreen() {
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getStyleClass().add("titleScreen");

        Label titleLabel = new Label("Memory Game");
        titleLabel.getStyleClass().add("label");

        Button smileyButton = new Button("Game with Smileys");
        smileyButton.getStyleClass().add("controlButton");
        smileyButton.setOnAction(e -> initializeSmileyGame());

        Button fileButton = new Button("Load Game from File");
        fileButton.getStyleClass().add("controlButton");
        fileButton.setOnAction(e -> initializeGameFromFile());
        vbox.getChildren().addAll(titleLabel, smileyButton, fileButton);


        Scene scene = new Scene(vbox, 400, 300);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Memory Game");
        primaryStage.show();
    }


    private void initializeGameFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "/src/main/resources/be/ugent/memory/games"));
        fileChooser.setTitle("Select Game to Load");
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            // pas hier aan: new MemoryGame
//            gameModel = new DummyMemoryGame(selectedFile);
            gameModel = new MemoryGame(selectedFile);
            startGame();
        } else {
            // User cancelled, return to title screen
            showTitleScreen();
        }
    }


    private void initializeSmileyGame() {
        // pas hier aan: new MemoryGame
//        gameModel = new DummyMemoryGame(3, 4);
        gameModel = new MemoryGame(3, 4);
        startGame();
    }

    private void startGame() {
        int rows = gameModel.getRowCount();
        int cols = gameModel.getColumnCount();
        cardButtons = new Button[rows][cols];

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.getStyleClass().add("buttonGrid");

        // Add a label to display the move count
        movesLabel = new Label("Moves: 0");
        movesLabel.getStyleClass().add("label");
        grid.add(movesLabel, 0, 0, cols, 1);

        // Create card buttons
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Button cardButton = new Button();
                cardButton.setPrefSize(100, 100);
                cardButton.getStyleClass().add("button");
                final int r = row;
                final int c = col;

                cardButton.setOnAction(e -> {
                    gameModel.selectCard(r, c);
                    // Show Card Value for short period also when incorrect matched
                    cardButtons[r][c].setText(gameModel.getCardValue(r, c));

                    // Add short delay to show card if incorrect pair is selected
                    PauseTransition pause = new PauseTransition(Duration.seconds(1.0));
                    pause.setOnFinished(event -> {
                        updateView();
                    });
                    pause.play();
                });

                cardButtons[row][col] = cardButton;
                grid.add(cardButton, col, row + 1);
            }
        }

        updateView();

        Scene scene = new Scene(grid);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Memory Game");
        primaryStage.show();
    }

    private void updateView() {
        int rows = gameModel.getRowCount();
        int cols = gameModel.getColumnCount();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Button cardButton = cardButtons[row][col];
                cardButton.setDisable(false);
                cardButton.setText("");

                if (gameModel.isCardFlipped(row, col)) {
                    cardButton.getStyleClass().add("selected");
                    cardButton.setText(gameModel.getCardValue(row, col));
                } else {
                    cardButton.getStyleClass().add("unselected");
                    cardButton.setText("");
                }
            }
        }

        movesLabel.setText("Moves: " + gameModel.getMoveCount());

        if (gameModel.isGameOver()) {
            movesLabel.setText("Game Over! Total Moves: " + gameModel.getMoveCount());
            movesLabel.getStyleClass().add("gameOverLabel");
            // Disable all buttons
            for (Button[] rowButtons : cardButtons) {
                for (Button button : rowButtons) {
                    button.setDisable(true);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
