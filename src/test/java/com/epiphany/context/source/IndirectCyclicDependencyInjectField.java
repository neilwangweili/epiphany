package com.epiphany.context.source;

import jakarta.inject.Inject;

@SuppressWarnings("unused")
public class IndirectCyclicDependencyInjectField implements Dependency {

    private @Inject AnotherDependency dependency;

}
