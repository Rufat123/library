package az.developia.library.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size (min = 2,message = "Minimum 2 simvol yazmaq lazimdır")
	@Size (max = 40,message = "Maxsimum 40 simvol yazmaq lazimdır")
	@NotEmpty (message = "Boş qoymaq olmaz")
	@Column(columnDefinition = "VARCHAR(40)")
	private String name;
	
	@NotNull (message = "Boş qoymaq olmaz")
	@Min(value = 0,message = "Minimum 0 yazmaq olar")
	@Max(value = 1000,message = "Maxsimum 10000 yazmaq olar")
	private Double price;
	
	@Past (message = "Siz yazdıqınız tarix keçmiş zamanda olmalıdır")
	private Date publishDate;
}
