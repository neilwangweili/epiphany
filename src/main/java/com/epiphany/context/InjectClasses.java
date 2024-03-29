package com.epiphany.context;

import com.epiphany.context.exception.IllegalComponentException;

final class InjectClasses<Type, Implementation extends Type> {

    private final Class<Type> injectType;
    private final Class<Implementation> implementation;

    @SuppressWarnings("unchecked")
    public static <Type, Implementation extends Type> InjectClasses<Type, Implementation> from(final Class<Type> injectType, final String className) {
        try {
            Class<Implementation> implementation = (Class<Implementation>) Class.forName(className);
            if (!injectType.isAssignableFrom(implementation)) throw new IllegalComponentException();
            return new InjectClasses<>(injectType, implementation);
        } catch (ClassNotFoundException e) {
            throw new IllegalComponentException();
        }
    }

    public InjectClasses(final Class<Type> injectType, final Class<Implementation> implementation) {
        this.injectType = injectType;
        this.implementation = implementation;
    }

    public Class<Type> type() {
        return injectType;
    }

    public Class<Implementation> implementation() {
        return implementation;
    }

}
