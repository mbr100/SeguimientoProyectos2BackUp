package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Comite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ComiteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComiteService.class);
    private static final String COMITES = "comites";

    public ComiteService(Firestore firestore) {
    }

    public List<Comite> getComites() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection(COMITES).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
        // Mapea los documentos a la clase Proyecto
        return documentos.stream()
                .map(doc -> {
                    Comite comite = doc.toObject(Comite.class);
                    comite.setId(doc.getId());
                    return comite;
                })
                .collect(Collectors.toList());
    }
}