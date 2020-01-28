package ro.avs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {
    protected String id;

    protected BaseEntity(String id) {
        this.id = id;
    }
}
