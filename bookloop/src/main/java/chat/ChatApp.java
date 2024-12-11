package chat;

import javafx.application.Application;
// import javafx.beans.value.ChangeListener;
// import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.cloud.firestore.Firestore;

public class ChatApp extends Application {
    private TextField messageField;
    private Button sendButton;
    private TextArea chatArea;

    private ChatHelper chatHelper;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Firestore db = FireStoreHelper.getFirestore();
        chatHelper = new ChatHelper(db);
        
        primaryStage.setTitle("Chat Application");

        // UI bileşenleri
        messageField = new TextField();
        messageField.setPromptText("Type a message...");

        sendButton = new Button("Send");
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // Layout
        VBox layout = new VBox(10, chatArea, messageField, sendButton);
        layout.setPrefSize(400, 400);

        // Button event
        sendButton.setOnAction(e -> sendMessage());

        // Mesajları dinlemeye başla
        String chatId = "chat123"; // Örnek chat ID'si
        chatHelper.listenToMessages(chatId, this::displayMessage);

        // Scene ve Stage
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Mesajı Firestore'a gönder
    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            Map<String, Object> messageData = new HashMap<>();
            messageData.put("sender", "user1");
            messageData.put("message", message);
            messageData.put("timestamp", System.currentTimeMillis());

            String chatId = "chat123"; // Örnek chat ID'si
            chatHelper.addMessage(chatId, messageData);

            messageField.clear();
        }
    }

    // Ekranda mesajları görüntüle
    private void displayMessage(String sender, String message) {
        chatArea.appendText(sender + ": " + message + "\n");
    }
}

