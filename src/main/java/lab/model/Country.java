package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Column
	private String name;

    @Column(name="code_name")
	private String codeName;

	public Country(String name, String codeName) {
		this.name = name;
		this.codeName = codeName;
	}
}
