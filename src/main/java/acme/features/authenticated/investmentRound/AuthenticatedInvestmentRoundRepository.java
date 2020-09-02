
package acme.features.authenticated.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInvestmentRoundRepository extends AbstractRepository {

	@Query("select n from InvestmentRound n where n.finalMode=true")
	Collection<InvestmentRound> findMany();

	@Query("select n from InvestmentRound n where n.id=?1")
	InvestmentRound findOneById(int id);
}
