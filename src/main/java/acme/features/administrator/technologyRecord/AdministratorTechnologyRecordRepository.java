
package acme.features.administrator.technologyRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.technologyRecords.TechnologyRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTechnologyRecordRepository extends AbstractRepository {

	@Query("select n from TechnologyRecord n")
	Collection<TechnologyRecord> findMany();

	@Query("select n from TechnologyRecord n where n.id=?1")
	TechnologyRecord findOneById(int id);
}
