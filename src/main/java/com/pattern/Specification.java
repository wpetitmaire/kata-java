package com.pattern;

public interface Specification<T> {
    public boolean isSatisfiedBy(T t);
}
