package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Recurso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class RecursoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecursoService.class);
    private static final String RECURSOS = "recursos";

    public RecursoService(){}

    public List<Recurso> getRecursos() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection(RECURSOS).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
        return documentos.stream()
                .map(doc -> {
                    Recurso recurso = doc.toObject(Recurso.class);
                    recurso.setId(doc.getId());
                    return recurso;
                })
                .collect(Collectors.toList());
    }
}
