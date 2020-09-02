
package acme.features.entrepreneur.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurInvestmentRoundRepository extends AbstractRepository {

	@Query("select n from InvestmentRound n where n.entrepreneur.id=?1")
	Collection<InvestmentRound> findManyByEntrepreneurId(int id);

	@Query("select n from InvestmentRound n where n.id=?1")
	InvestmentRound findOneById(int id);
}
