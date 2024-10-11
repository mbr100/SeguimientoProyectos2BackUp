package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirestoreService {

    // Variable estática que mantiene una única instancia de Firestore
    private static volatile Firestore firestore = null;
    private static final Logger logger = Logger.getLogger(FirestoreService.class.getName());

    // Constructor privado para evitar instanciación
    private FirestoreService() {
    }

    public static Firestore getFirestore() {
        if (firestore == null) {
            synchronized (FirestoreService.class) {
                if (firestore == null) {
                    firestore = FirestoreClient.getFirestore();
                    logger.log(Level.INFO, "Firestore client initialized.");
                }
            }
        }
        return firestore;
    }

    public static void closeFirestore() {
        if (firestore != null) {
            try {
                firestore.close();
                firestore = null;
                logger.log(Level.INFO, "Firestore client closed.");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error closing Firestore client: " + e.getMessage(), e);
            }
        }
    }
}

