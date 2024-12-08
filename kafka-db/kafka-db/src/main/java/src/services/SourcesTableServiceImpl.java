package src.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.models.SourcesTable;
import src.repository.SourcesTableRepository;

import java.util.List;

@Service
public class SourcesTableServiceImpl {
    @Autowired
    SourcesTableRepository sourcesTableRepository;

    public void create(SourcesTable sourcesTable) {
        sourcesTableRepository.save(sourcesTable);
    }

    public List<SourcesTable> readAll() {
        return sourcesTableRepository.findAll();
    }

    public SourcesTable read(int id) {
        return sourcesTableRepository.getOne(id);
    }

    public boolean update(SourcesTable sourcesTable, int id) {
        if (sourcesTableRepository.existsById(id)) {
            sourcesTable.setId(id);
            sourcesTableRepository.save(sourcesTable);
            return true;
        }

        return false;
    }

    public boolean delete(int id) {
        if (sourcesTableRepository.existsById(id)) {
            sourcesTableRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
