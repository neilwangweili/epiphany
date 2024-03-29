package com.epiphany.context;

import java.lang.reflect.*;
import java.util.*;

import static com.epiphany.general.Exceptions.evaluate;
import static java.util.Arrays.stream;

class ExplicitInjectionProvider<InjectionsType, Type> implements Provider<Type> {

    private final Class<InjectionsType> injectionsType;
    private final Method method;

    public ExplicitInjectionProvider(final Class<InjectionsType> injectionsType, final Method method) {
        this.injectionsType = injectionsType;
        this.method = method;
    }

    @Override
    @SuppressWarnings("all")
    public Type get(final Context context) {
        InjectionsType injections = context.get(injectionsType).get();
        Object[] dependencies = stream(method.getParameters()).map(Parameter::getType).map(context::get).map(Optional::get).toArray(Object[]::new);
        return (Type) evaluate(() -> {
            method.setAccessible(true);
            return method.invoke(injections, dependencies);
        }).evaluate();
    }

    @Override
    public List<Class<?>> dependencies() {
        return Arrays.stream(method.getParameterTypes()).toList();
    }

}
