package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.TipoRecurso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class TipoRecursoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoRecursoService.class);
    private static final String TIPORECURSO = "tipoRecursos";

    public TipoRecursoService(){}

    public List<TipoRecurso> getTipoRecursos() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection(TIPORECURSO).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
        return documentos.stream()
                .map(doc -> {
                    TipoRecurso tipoRecurso = doc.toObject(TipoRecurso.class);
                    tipoRecurso.setId(doc.getId());
                    return tipoRecurso;
                })
                .collect(Collectors.toList());
    }
}
