package com.bizagi.dojobz.option;

import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Created by WilliamE on 13/08/2015.
 */
public class None<T> extends Option<T> {
    @Override
    public T get() {
        throw new NoSuchElementException();
    }

    @Override
    public T orElse(T t) {
        return t;
    }

    @Override
    public Option<Integer> map(Function<String, Integer> f) {
        return null;
    }
}
