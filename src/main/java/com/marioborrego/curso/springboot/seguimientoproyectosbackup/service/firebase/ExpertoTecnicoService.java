package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.ExpertoTecnico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ExpertoTecnicoService {
    private final String EXPERTOSTECNICOS = "expertosTecnicos";
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpertoTecnicoService.class);

    public ExpertoTecnicoService(){}

    public List<ExpertoTecnico> getExpertosTecnicos() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection(EXPERTOSTECNICOS).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();

        return documentos.stream()
                .map(doc -> {
                    ExpertoTecnico expertoTecnico = doc.toObject(ExpertoTecnico.class);
                    expertoTecnico.setId(doc.getId());
                    return expertoTecnico;
                })
                .toList();
    }
}
