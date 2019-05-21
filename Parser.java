package com.nn.prt.loganalyzer.helpers;

@FunctionalInterface
public interface Parser<I, O> {
    O parse(I input);
}
