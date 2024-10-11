package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Aviso;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class AvisoService {
    private static final String AVISOS = "avisos";

    // No se necesita recibir Firestore en el constructor
    public AvisoService() {
    }

    public List<Aviso> getAvisos() throws ExecutionException, InterruptedException {
        // Obtiene la instancia de Firestore a través del FirestoreService
        Firestore firestore = FirestoreService.getFirestore();

        ApiFuture<QuerySnapshot> future = firestore.collection(AVISOS).get();
        List<QueryDocumentSnapshot> listaAvisos = future.get().getDocuments();

        return listaAvisos.stream()
                .map(doc -> {
                    Aviso aviso = doc.toObject(Aviso.class);
                    aviso.setId(doc.getId());
                    return aviso;
                })
                .toList();
    }
}
