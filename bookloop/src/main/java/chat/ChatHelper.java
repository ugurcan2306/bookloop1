package chat;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.util.Map;
import java.util.function.BiConsumer;

public class ChatHelper {

    private Firestore db;

    public ChatHelper(Firestore firestore) {
        this.db = firestore;
    }

    // Yeni mesaj ekleme fonksiyonu
    public void addMessage(String chatId, Map<String, Object> messageData) {
        CollectionReference messagesRef = db.collection("chats").document(chatId).collection("messages");
        ApiFuture<DocumentReference> result = messagesRef.add(messageData);

        try {
            DocumentReference docRef = result.get();
            System.out.println("Message added with ID: " + docRef.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mesajları dinlemeye başlama fonksiyonu
    @SuppressWarnings("null")
    public void listenToMessages(String chatId, BiConsumer<String, String> messageConsumer) {
        CollectionReference messagesRef = db.collection("chats").document(chatId).collection("messages");
        messagesRef.addSnapshotListener((querySnapshot, e) -> {
            if (e != null) {
                System.out.println("Error getting messages: " + e);
                return;
            }
            for (DocumentSnapshot document : querySnapshot) {
                String sender = document.getString("sender");
                String message = document.getString("message");
                messageConsumer.accept(sender, message);
            }
        });
    }

    // Mesaj gönderme fonksiyonu
    public void sendMessage(String chatId, Message message) {
        Map<String, Object> messageData = Map.of(
            "sender", message.getSender(),
            "message", message.getContent(),
            "timestamp", message.getTimestamp().toString()
        );
        addMessage(chatId, messageData);
    }
}
