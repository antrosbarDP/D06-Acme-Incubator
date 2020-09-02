
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
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EntrepreneurActivityDeleteService implements AbstractDeleteService<Entrepreneur, Activity> {

	@Autowired
	private EntrepreneurActivityRepository			repository;

	@Autowired
	private EntrepreneurInvestmentRoundRepository	investmentRoundRepository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		Principal principal = request.getPrincipal();

		return request.getModel().getAttribute("investmentRound", InvestmentRound.class).getApplications().size() == 0 && request.getModel().getAttribute("investmentRound", InvestmentRound.class).getWorkProgramme().size() >= 1
			&& request.getModel().getAttribute("investmentRound", InvestmentRound.class).getEntrepreneur().getId() == principal.getActiveRoleId();
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
	public Activity findOne(final Request<Activity> request) {

		assert request != null;
		Activity result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;

	}

	@Override
	public void validate(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	private double calculateAmount(final InvestmentRound ir) {
		double result = 0;
		for (Activity a : ir.getWorkProgramme()) {
			result = result + a.getBudget().getAmount();
		}

		return result;
	}

	@Override
	public void delete(final Request<Activity> request, final Activity entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
		double amount = this.calculateAmount(entity.getInvestmentRound());
		InvestmentRound investmentRound = entity.getInvestmentRound();
		investmentRound.getAmount().setAmount(amount);
		investmentRound.getWorkProgramme().remove(entity);
		this.investmentRoundRepository.save(investmentRound);

	}

}
