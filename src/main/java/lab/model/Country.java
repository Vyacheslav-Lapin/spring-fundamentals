package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Country {
    @Value("1")
    private int id;

    @Value("Russia")
    private String name;

    @Value("RU")
    private String codeName;
}
