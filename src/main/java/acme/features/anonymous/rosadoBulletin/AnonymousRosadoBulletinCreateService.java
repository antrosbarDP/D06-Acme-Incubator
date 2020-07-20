
package acme.features.anonymous.rosadoBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.RosadoBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousRosadoBulletinCreateService implements AbstractCreateService<Anonymous, RosadoBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousRosadoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<RosadoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public RosadoBulletin instantiate(final Request<RosadoBulletin> request) {
		assert request != null;

		RosadoBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new RosadoBulletin();
		result.setAuthor("John Doe");
		result.setText("https://image.shutterstock.com/image-photo/bright-spring-view-cameo-island-260nw-1048185397.jpg");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<RosadoBulletin> request, final RosadoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text");

	}

	@Override
	public void bind(final Request<RosadoBulletin> request, final RosadoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<RosadoBulletin> request, final RosadoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<RosadoBulletin> request, final RosadoBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}
}
