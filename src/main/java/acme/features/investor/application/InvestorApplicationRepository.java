
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorApplicationRepository extends AbstractRepository {

	@Query("select n from Application n where n.investor.id=?1")
	Collection<Application> findManyByInvestorId(int id);

	@Query("select n from Application n where n.id=?1")
	Application findOneById(int id);
}
