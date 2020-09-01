
package acme.features.administrator.notice;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.notices.Notice;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorNoticeCreateService implements AbstractCreateService<Administrator, Notice> {

	@Autowired
	private AdministratorNoticeRepository repository;


	@Override
	public boolean authorise(final Request<Notice> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate");

	}

	@Override
	public void unbind(final Request<Notice> request, final Notice entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "header", "deadline", "links", "body");
		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("confirm", "false");
		} else {
			request.transfer(model, "confirm");
		}

	}

	@Override
	public Notice instantiate(final Request<Notice> request) {
		Notice result;

		result = new Notice();
		result.setHeader("");
		result.setTitle("");
		result.setLinks("");
		return result;

	}

	@Override
	public void validate(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String regexpUrl = "^(https?:\\/\\/)?(www\\.)?([a-zA-Z0-9]+(-?[a-zA-Z0-9])*\\.)+[\\w]{2,}(\\/\\S*)?$";

		String[] links = entity.getLinks().replaceAll("\\s+", "").split(",");
		for (String l : links) {
			if (!l.matches(regexpUrl) && !entity.getLinks().isEmpty()) {
				errors.state(request, false, "links", "links.url");
				break;
			}
		}

		if (entity.getDeadline() != null) {
			Calendar calendar = new GregorianCalendar();
			calendar.add(Calendar.MONTH, 1);
			Date minimumDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "deadline.future");
		} else {
			errors.state(request, false, "deadline", "deadline.future");
		}

		Boolean confirm = request.getModel().getBoolean("confirm");
		errors.state(request, confirm, "confirm", "notice.confirm");

	}

	@Override
	public void create(final Request<Notice> request, final Notice entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationDate(moment);

		this.repository.save(entity);

	}

}
