package lab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Country implements Serializable {

    @Value("1")
	private int id;

    @Value("Russia")
    private String name;

    @Value("RU")
    private String codeName;
}
