
package acme.features.administrator.overture;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.overtures.Overture;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorOvertureRepository extends AbstractRepository {

	@Query("select n from Overture n where NOW() <= n.deadline ")
	Collection<Overture> findMany();

	@Query("select n from Overture n where n.id=?1")
	Overture findOneById(int id);
}
