package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.models.SourcesTable;

public interface SourcesTableRepository extends JpaRepository<SourcesTable, Integer> {
}
