package az.developia.library.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student  { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size (min = 2,message = "Minimum 2 simvol yazmaq lazimdır")
	@Size (max = 20,message = "Maxsimum 20 simvol yazmaq lazimdır")
	@NotEmpty (message = "Boş qoymaq olmaz")
	@Column(columnDefinition = "VARCHAR(20)")
	private String name;
	
	@Size (min = 2,message = "Minimum 2 simvol yazmaq lazimdır")
	@Size (max = 20,message = "Maxsimum 20 simvol yazmaq lazimdır")
	@NotEmpty (message = "Boş qoymaq olmaz")
	@Column(columnDefinition = "VARCHAR(20)")
	private String surname;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}",message="Telefonu düzgün formatda yazın. Məsələn: 000-000-0000")
	@NotEmpty (message = "Boş qoymaq olmaz")
	@Column(columnDefinition = "VARCHAR(20)")
	@Size (max = 20,message = "Maxsimum 20 simvol yazmaq lazimdır")
	private String phone;
	
	@Size (min = 2,message = "Minimum 2 simvol yazmaq lazimdır")
	@Size (max = 200,message = "Maxsimum 200 simvol yazmaq lazimdır")
	@NotEmpty (message = "Boş qoymaq olmaz")
	@Column(columnDefinition = "VARCHAR(200)")
	private String address;
	
	private String username;
	
	private String password;
	

	

}
