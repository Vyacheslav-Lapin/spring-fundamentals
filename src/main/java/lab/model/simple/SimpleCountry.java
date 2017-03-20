package lab.model.simple;

import lab.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "country")
public class SimpleCountry implements Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Column
	private String name;

    @Column(name="code_name")
	private String codeName;

	public SimpleCountry(String name, String codeName) {
		this.name = name;
		this.codeName = codeName;
	}
}
