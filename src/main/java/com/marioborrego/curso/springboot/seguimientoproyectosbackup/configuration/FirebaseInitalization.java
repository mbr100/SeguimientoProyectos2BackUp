package com.marioborrego.curso.springboot.seguimientoproyectosbackup.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseInitalization {

    @Value("classpath:/seguimientoproyectos2mbr.json")
    private Resource privateKey;

    @Bean
    public Firestore firestore() throws IOException {
        try {
            if (FirebaseApp.getApps().isEmpty()) { // Verifica si ya hay una instancia activa
                InputStream credentials = new ByteArrayInputStream(privateKey.getContentAsByteArray());
                FirebaseOptions firebaseOptions = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(credentials))
                        .build();

                FirebaseApp firebaseApp = FirebaseApp.initializeApp(firebaseOptions);
                return FirestoreClient.getFirestore(firebaseApp);
            } else {
                return FirestoreClient.getFirestore();  // Reutiliza la instancia existente
            }
        } catch (IOException e) {
            throw new IOException("Error al inicializar Firebase", e);
        }
    }
}