
package acme.features.entrepreneur.investmentRound;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activities.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurInvestmentRoundUpdateService implements AbstractUpdateService<Entrepreneur, InvestmentRound> {

	@Autowired
	private EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		Principal principal = request.getPrincipal();

		return !request.getModel().getAttribute("investmentRound", InvestmentRound.class).getFinalMode() && request.getModel().getAttribute("investmentRound", InvestmentRound.class).getEntrepreneur().getId() == principal.getActiveRoleId();
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate", "ticker", "amount");

	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "ticker", "additionalInfo", "creationDate", "description", "amount", "roundKind");

	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {

		assert request != null;
		InvestmentRound result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;

	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		List<String> kinds = new ArrayList<String>();
		kinds.add("ANGEL");
		kinds.add("SEED");
		kinds.add("SERIES-B");
		kinds.add("SERIES-A");
		kinds.add("SERIES-C");
		kinds.add("BRIDGE");
		Boolean kindOk = kinds.contains(entity.getRoundKind());
		errors.state(request, kindOk, "roundKind", "round.kind");

		Boolean numberOk = 0 < request.getModel().getInteger("number") && request.getModel().getInteger("number") < 9999999;
		errors.state(request, kindOk, "ticker", "ticker.number");

		double budget = 0;
		for (Activity a : entity.getWorkProgramme()) {
			budget = budget + a.getBudget().getAmount();
		}
		Boolean amountOk = entity.getAmount().getAmount() == budget;
		errors.state(request, amountOk, "amount", "amount.budget");

	}

	@Override
	public void update(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		Integer tickerNumber = request.getModel().getInteger("number");
		int year = entity.getCreationDate().getYear();
		String yeardigits = Integer.toString(year).substring(2);
		String sector = entity.getEntrepreneur().getActivitySector().substring(0, 3);
		while (sector.length() < 3) {
			sector = sector + "X";
		}
		String ticker = sector + "-" + yeardigits + "-" + String.format("%06d", tickerNumber.toString());
		entity.setTicker(ticker);
		this.repository.save(entity);

	}

}
