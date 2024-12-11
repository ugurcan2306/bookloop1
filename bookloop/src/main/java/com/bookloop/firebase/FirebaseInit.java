package com.bookloop.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInit {
    public static void initializeFirebase() {
        try {
           
            FileInputStream serviceAccount =
                new FileInputStream("bookloop/src/main/resources/bookloop-5d51a-firebase-adminsdk-ptztt-59a495ea0b.json");

            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase has been initialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


