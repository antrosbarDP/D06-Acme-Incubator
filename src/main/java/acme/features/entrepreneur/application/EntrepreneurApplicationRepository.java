
package acme.features.entrepreneur.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurApplicationRepository extends AbstractRepository {

	@Query("select n from Application n where n.investmentRound.entrepreneur.id=?1")
	Collection<Application> findManyByEntrepreneurId(int id);

	@Query("select n from Application n where n.id=?1")
	Application findOneById(int id);
}
