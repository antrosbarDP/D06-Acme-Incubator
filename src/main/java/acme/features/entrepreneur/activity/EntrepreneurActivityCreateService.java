
package acme.features.entrepreneur.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activities.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.features.entrepreneur.investmentRound.EntrepreneurInvestmentRoundRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurActivityCreateService implements AbstractCreateService<Entrepreneur, Activity> {

	@Autowired
	private EntrepreneurActivityRepository			repository;

	@Autowired
	private EntrepreneurInvestmentRoundRepository	investmentRoundRepository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		return !request.getModel().getAttribute("investmentRound", InvestmentRound.class).getFinalMode();
	}

	@Override
	public void bind(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "budget", "startDate", "endDate", "title");

	}

	@Override
	public Activity instantiate(final Request<Activity> request) {
		Activity result;

		result = new Activity();
		result.setTitle("");
		InvestmentRound investmentRound = this.investmentRoundRepository.findOneById(request.getModel().getInteger("roundId"));
		result.setInvestmentRound(investmentRound);
		return result;

	}

	@Override
	public void validate(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getStartDate() != null && entity.getEndDate() != null) {
			Boolean datesOk = entity.getEndDate().after(entity.getStartDate());
			errors.state(request, datesOk, "*", "date.after");
		} else {
			errors.state(request, false, "*", "date.after");
		}

		if (entity.getBudget() != null) {
			Boolean budgetOk = entity.getBudget().getCurrency().equals("€") || entity.getBudget().getCurrency().equals("EUR");
			errors.state(request, budgetOk, "budget", "money.currency");
		} else {
			errors.state(request, false, "budget", "money.currency");
		}

	}

	private double calculateAmount(final InvestmentRound ir) {
		double result = 0;
		for (Activity a : ir.getWorkProgramme()) {
			result = result + a.getBudget().getAmount();
		}

		return result;
	}

	@Override
	public void create(final Request<Activity> request, final Activity entity) {

		double amount = this.calculateAmount(entity.getInvestmentRound());
		InvestmentRound investmentRound = entity.getInvestmentRound();
		investmentRound.getAmount().setAmount(amount);
		investmentRound.getWorkProgramme().add(entity);
		this.investmentRoundRepository.save(investmentRound);
		this.repository.save(entity);

	}

}
