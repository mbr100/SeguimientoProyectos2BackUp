package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Tramites;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class TramitesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TramitesService.class);
    private static final String TRAMITES = "tramites";

    public TramitesService() {

    }

    public List<Tramites> getTramites() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection(TRAMITES).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
        return documentos.stream()
                .map(doc -> {
                    Tramites tramites = doc.toObject(Tramites.class);
                    tramites.setId(doc.getId());
                    return tramites;
                })
                .collect(Collectors.toList());
    }
}
