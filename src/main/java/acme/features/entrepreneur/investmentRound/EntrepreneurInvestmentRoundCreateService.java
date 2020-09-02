
package acme.features.entrepreneur.investmentRound;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activities.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurInvestmentRoundCreateService implements AbstractCreateService<Entrepreneur, InvestmentRound> {

	@Autowired
	private EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		return true;
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
	public InvestmentRound instantiate(final Request<InvestmentRound> request) {
		InvestmentRound result;

		result = new InvestmentRound();
		Activity activity = new Activity();
		Money money = new Money();
		money.setCurrency("€");
		money.setAmount(0.0);
		activity.setBudget(money);
		result.setAmount(money);
		result.setFinalMode(false);
		result.setTitle("");
		List<Activity> wp = new ArrayList<Activity>();
		wp.add(activity);
		result.setWorkProgramme(wp);
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
	public void create(final Request<InvestmentRound> request, final InvestmentRound entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationDate(moment);

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
