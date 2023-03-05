package az.developia.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class LibraryUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Size (min = 2,message = "Minimum 2 simvol yazmaq lazimdır")
	@Size (max = 20,message = "Maxsimum 20 simvol yazmaq lazimdır")
	@NotEmpty (message = "Boş qoymaq olmaz")
	@Column(columnDefinition = "VARCHAR(20)")
	private String username;
	
	@Size(min = 1, message = "Şifrə minimum 1 simvol yazmaq lazimdır")
	@Size (max = 30,message = "Şifrə maxsimum 30 simvol yazmaq lazimdır")
	@NotEmpty(message = "Boş qoymaq olmaz")
	private String password;
}
