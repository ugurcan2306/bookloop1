package chat;

import com.google.cloud.firestore.Firestore;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Firestore veritabanını al
            Firestore db = FireStoreHelper.getFirestore();

            // ChatHelper nesnesi oluştur
            ChatHelper chatHelper = new ChatHelper(db);

            String chatId = "user1_user2"; // İki kullanıcı arasında benzersiz bir ID

            // Mesajları dinleme (BiConsumer kullanılarak mesajlar işlenir)
            chatHelper.listenToMessages(chatId, (sender, messageContent) -> {
                System.out.println(sender + ": " + messageContent);
            });

            // Kullanıcıdan mesaj al
            Scanner scanner = new Scanner(System.in);
            System.out.print("Kullanıcı adı: ");
            String username = scanner.nextLine();

            System.out.println("Mesaj göndermek için yazmaya başlayın (çıkmak için 'exit'):");

            while (true) {
                String messageContent = scanner.nextLine();
                if (messageContent.equalsIgnoreCase("exit")) break;

                // Mesaj objesi oluştur
                Message message = new Message(username, messageContent, LocalDateTime.now());
                chatHelper.sendMessage(chatId, message);
            }

            scanner.close();
            System.out.println("Sohbet sonlandı.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

