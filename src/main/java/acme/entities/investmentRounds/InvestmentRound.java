
package acme.entities.investmentRounds;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.entities.activities.Activity;
import acme.entities.applications.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long			serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String						ticker;

	@URL
	private String						additionalInfo;

	@NotBlank
	private String						title;

	@NotBlank
	private String						description;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date						creationDate;

	@Valid
	private Money						amount;

	@NotBlank
	private String						roundKind;

	@NotNull
	private Boolean						finalMode;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Entrepreneur				entrepreneur;

	@NotEmpty
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "investmentRound")
	private List<@Valid Activity>		workProgramme;

	@OneToMany(mappedBy = "investmentRound")
	private List<@Valid Application>	applications;
}
