package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity

@EqualsAndHashCode(callSuper=false)
@Table(name="applicants")


@NoArgsConstructor
@AllArgsConstructor
public class Applicant extends User {

	

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_year")
	private int birthYear;

	@Column(name = "national_identity_no")
	private String nationalId;

	
}
