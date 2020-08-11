package hello;

import lombok.NonNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode @Getter @NoArgsConstructor @AllArgsConstructor
class Person {
	
	private @NonNull @EqualsAndHashCode.Exclude Long id;
	private @NonNull String name;
	private @NonNull String surname;
}
