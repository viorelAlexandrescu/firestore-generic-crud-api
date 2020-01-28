package ro.avs.fgca.dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import ro.avs.fgca.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class BaseDAO<T extends BaseEntity> {
    private static Firestore db;

    abstract protected String getCollectionName();

    abstract protected T parseDocument(DocumentSnapshot document);

    protected CollectionReference getCollection() {
        if (db == null) {
            db = FirestoreClient.getFirestore();
        }
        return db.collection(getCollectionName());
    }

    public void addDocument(T entry) {
        getCollection().add(entry);
    }

    public T getDocumentById(String id) throws ExecutionException, InterruptedException {
        DocumentReference reference = getCollection().document(id);
        ApiFuture<DocumentSnapshot> future = reference.get();
        DocumentSnapshot document = future.get();
        return parseDocument(document);
    }

    public List<QueryDocumentSnapshot> getAllDocumentsFromCollection() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = getCollection().get();
        QuerySnapshot querySnapshot = query.get();
        return querySnapshot.getDocuments();
    }

    public List<T> getAllDocumentsParsedFromCollection() throws ExecutionException, InterruptedException {
        List<QueryDocumentSnapshot> documents = getAllDocumentsFromCollection();
        List<T> items = new ArrayList<>(documents.size());
        for (DocumentSnapshot document : documents) {
            items.add(parseDocument(document));
        }
        return items;
    }

    public void updateDocument(T entry) {
        getCollection().document(entry.getId()).set(entry);
    }

    public void deleteDocument(String id) {
        getCollection().document(id).delete();
    }


}
