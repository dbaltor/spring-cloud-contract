package hello;

import lombok.NonNull;
import lombok.Data;

@Data 
public class PersonId {
    private final @NonNull Long id;    
}