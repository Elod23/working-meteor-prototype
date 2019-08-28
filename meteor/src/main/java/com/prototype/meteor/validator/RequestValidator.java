package com.prototype.meteor.validator;

public interface RequestValidator<T> {

	boolean validate(T t);
}
