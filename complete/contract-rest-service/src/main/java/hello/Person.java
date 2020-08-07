package hello;

import lombok.NonNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode @Getter @NoArgsConstructor @AllArgsConstructor
class Person {
	
	@EqualsAndHashCode.Exclude private Long id;
	private @NonNull String name;
	private @NonNull String surname;
}
