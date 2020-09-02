
package acme.features.authenticated.activity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activities.Activity;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedActivityListService implements AbstractListService<Authenticated, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedActivityRepository repository;

	// AbstractListService<Administrator,Shout> Interface ---------------------------------------------------------


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Activity> findMany(final Request<Activity> request) {
		assert request != null;
		Collection<Activity> result;
		Integer id = request.getModel().getInteger("roundId");
		result = this.repository.findManyByInvestmentRoundId(id);
		return result;
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Integer id = request.getModel().getInteger("roundId");
		model.setAttribute("tsw", id);
		request.unbind(entity, model, "title", "budget");

	}
}
