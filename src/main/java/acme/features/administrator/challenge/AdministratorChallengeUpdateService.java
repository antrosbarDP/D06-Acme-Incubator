
package acme.features.administrator.challenge;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

	@Autowired
	private AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate");

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "rookieGoal", "rookieReward", "averageGoal", "averageReward", "expertGoal", "expertReward");

	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {

		assert request != null;
		Challenge result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;

	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getDeadline() != null) {
			Calendar calendar = new GregorianCalendar();
			calendar.add(Calendar.MONTH, 1);
			Date minimumDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "deadline.future");
		} else {
			errors.state(request, false, "deadline", "deadline.future");
		}

		if (entity.getRookieReward() != null) {
			Boolean currencyOk = entity.getRookieReward().getCurrency().equals("€") || entity.getRookieReward().getCurrency().equals("EUR");
			errors.state(request, currencyOk, "rookieReward", "money.currency");
		} else {
			errors.state(request, false, "rookieReward", "money.currency");
		}

		if (entity.getAverageReward() != null) {
			Boolean currencyOkavg = entity.getAverageReward().getCurrency().equals("€") || entity.getAverageReward().getCurrency().equals("EUR");
			errors.state(request, currencyOkavg, "averageReward", "money.currency");
		} else {
			errors.state(request, false, "averageReward", "money.currency");
		}

		if (entity.getExpertReward() != null) {
			Boolean currencyOkexp = entity.getExpertReward().getCurrency().equals("€") || entity.getExpertReward().getCurrency().equals("EUR");
			errors.state(request, currencyOkexp, "expertReward", "money.currency");
		} else {
			errors.state(request, false, "expertReward", "money.currency");
		}

	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
