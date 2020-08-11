package hello;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Data;
import lombok.Getter;

//@Getter @RequiredArgsConstructor
@Data 
public class PersonId {
    private final @NonNull Long id;    
}