package com.pattern;

public class NotSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> spec;

    public NotSpecification(Specification<T> s) {
        spec = s;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return !spec.isSatisfiedBy(t);
    }
}
