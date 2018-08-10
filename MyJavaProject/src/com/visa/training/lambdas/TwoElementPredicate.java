package com.visa.training.lambdas;

@FunctionalInterface
public interface TwoElementPredicate<T> {

	public boolean isFirstBetter(T o1, T o2);
}
