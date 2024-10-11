package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Consultores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ConsultoresService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultoresService.class);
    private static final String CONSULTORES = "consultores";

    public ConsultoresService() {
    }

    public List<Consultores> getConsultores() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection(CONSULTORES).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
        // Mapea los documentos a la clase Proyecto

        return documentos.stream()
                .map(doc -> {
                    Consultores consultor =doc.toObject(Consultores.class);
                    consultor.setId(doc.getId());
                    return consultor;
                })
                .toList();
    }
}
