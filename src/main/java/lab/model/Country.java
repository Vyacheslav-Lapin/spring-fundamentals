package lab.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@AllArgsConstructor
@Value
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
    private String name;
    private String codeName;
}
