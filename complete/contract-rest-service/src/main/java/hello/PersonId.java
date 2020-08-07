package hello;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;

@Getter @RequiredArgsConstructor
public class PersonId {
    private @NonNull Long id;    
}