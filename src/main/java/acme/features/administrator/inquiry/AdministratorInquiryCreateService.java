
package acme.features.administrator.inquiry;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiries.Inquiry;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInquiryCreateService implements AbstractCreateService<Administrator, Inquiry> {

	@Autowired
	private AdministratorInquiryRepository repository;


	@Override
	public boolean authorise(final Request<Inquiry> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Inquiry> request, final Inquiry entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate");

	}

	@Override
	public void unbind(final Request<Inquiry> request, final Inquiry entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "contactEmail", "deadline", "description", "minMoney", "maxMoney");

	}

	@Override
	public Inquiry instantiate(final Request<Inquiry> request) {
		Inquiry result;

		result = new Inquiry();
		result.setContactEmail("");
		result.setDescription("");
		result.setTitle("");
		return result;

	}

	@Override
	public void validate(final Request<Inquiry> request, final Inquiry entity, final Errors errors) {
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

		if (entity.getMaxMoney() != null) {
			Boolean maxMoneyOk = entity.getMaxMoney().getCurrency().equals("€") || entity.getMaxMoney().getCurrency().equals("EUR");
			errors.state(request, maxMoneyOk, "maxMoney", "money.currency");
		} else {
			errors.state(request, false, "maxMoney", "money.currency");
		}

		if (entity.getMinMoney() != null) {
			Boolean minMoneyOk = entity.getMinMoney().getCurrency().equals("€") || entity.getMinMoney().getCurrency().equals("EUR");
			errors.state(request, minMoneyOk, "minMoney", "money.currency");
		} else {
			errors.state(request, false, "minMoney", "money.currency");
		}

		if (entity.getMinMoney() != null && entity.getMinMoney() != null) {
			Boolean moneyIntervalOk = entity.getMaxMoney().getAmount() >= entity.getMinMoney().getAmount();
			errors.state(request, moneyIntervalOk, "*", "money.interval");
		}

	}

	@Override
	public void create(final Request<Inquiry> request, final Inquiry entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationDate(moment);

		this.repository.save(entity);

	}

}
