package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.ExpertoComite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ExpertoComiteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpertoComiteService.class);
    private static final String EXPERTOS_COMITE = "expertosComite";

    public ExpertoComiteService(){}

    public List<ExpertoComite> getExpertosComite() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection(EXPERTOS_COMITE).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
        // Mapea los documentos a la clase Proyecto

        return documentos.stream()
                .map(doc -> {
                    ExpertoComite expertoComite = doc.toObject(ExpertoComite.class);
                    expertoComite.setId(doc.getId());
                    return expertoComite;
                })
                .toList();
    }
}
