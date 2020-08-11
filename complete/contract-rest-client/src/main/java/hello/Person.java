package hello;

import lombok.Data;
import lombok.NonNull;

@Data
class Person {

	private final @NonNull Long id;
	private final @NonNull String name;
	private final @NonNull String surname;
}
