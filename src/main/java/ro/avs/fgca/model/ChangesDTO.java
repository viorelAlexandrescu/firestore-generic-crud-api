package ro.avs.fgca.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ChangesDTO extends BaseEntity {
    private Map<String, Object> changes;
}
