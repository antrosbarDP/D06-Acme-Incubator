
package acme.features.authenticated.challenge;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.challenges.Challenge;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedChallengeRepository extends AbstractRepository {

	@Query("select n from Challenge n where NOW() <= n.deadline ")
	Collection<Challenge> findMany();

	@Query("select n from Challenge n where n.id=?1")
	Challenge findOneById(int id);
}
