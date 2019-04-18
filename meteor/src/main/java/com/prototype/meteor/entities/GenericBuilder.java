package com.prototype.meteor.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericBuilder<T> {
	private final Supplier<T> target;

	private List<Consumer<T>> instanceModifiers = new ArrayList<>();

	public GenericBuilder(Supplier<T> target) {
		this.target = target;
	}

	public static <T> GenericBuilder<T> of(Supplier<T> target) {
		return new GenericBuilder<>(target);
	}

	public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
		Consumer<T> c = instance -> consumer.accept(instance, value);
		instanceModifiers.add(c);
		return this;
	}

	public T build() {
		T value = target.get();
		instanceModifiers.forEach(modifier -> modifier.accept(value));
		instanceModifiers.clear();
		return value; 
	}

}
