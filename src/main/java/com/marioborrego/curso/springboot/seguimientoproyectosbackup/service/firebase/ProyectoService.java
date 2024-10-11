package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Proyecto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ProyectoService {

    private static final String PROYECTOS = "proyectos";

    public ProyectoService() {}

    public List<Proyecto> getProyectos() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreService.getFirestore();

        ApiFuture<QuerySnapshot> future = firestore.collection(PROYECTOS).get();
        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();
        return documentos.stream()
                .map(doc -> {
                    Proyecto proyecto = doc.toObject(Proyecto.class);
                    proyecto.setId(doc.getId());
                    return proyecto;
                })
                .collect(Collectors.toList());
    }
}
