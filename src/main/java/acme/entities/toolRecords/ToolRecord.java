
package acme.entities.toolRecords;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToolRecord extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				inventor;

	@NotBlank
	private String				activitySector;

	@Email
	private String				contactEmail;

	@URL
	private String				website;

	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@NotNull
	private Boolean				openSource;

	@Range(max = 5, min = -5)
	private Integer				stars;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
