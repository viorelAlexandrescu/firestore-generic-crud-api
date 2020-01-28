package ro.avs.fgca.service;

import ro.avs.fgca.dao.BaseDAO;
import ro.avs.fgca.model.BaseEntity;
import ro.avs.fgca.model.ChangesDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class BaseService<T extends BaseEntity> {

    protected BaseDAO<T> dao;

    public BaseService(BaseDAO<T> dao) {
        this.dao = dao;
    }

    public List<T> getAll() throws ExecutionException, InterruptedException {
        return dao.getAllDocumentsParsedFromCollection();
    }

    public T getById(String id) throws ExecutionException, InterruptedException {
        return dao.getDocumentById(id);
    }

    public void addDocument(T entry) {
        dao.addDocument(entry);
    }

    public void updateDocument(T entry) {
        dao.updateDocument(entry);
    }

    public void updateDocument(ChangesDTO changesDTO) {
        dao.updateDocument(changesDTO.getId(), changesDTO.getChanges());
    }

    public void deleteDocument(String id) {
        dao.deleteDocument(id);
    }
}
