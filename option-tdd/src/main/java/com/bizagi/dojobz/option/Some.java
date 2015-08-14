package com.bizagi.dojobz.option;

import java.util.function.Function;

/**
 * Created by WilliamE on 13/08/2015.
 */
public class Some<T> extends Option<T> {
    private T t;

    public Some(T t) {
        this.t = t;
    }

    @Override
    public T get() {
        return t;
    }

    @Override
    public T orElse(T defaultT) {
        return t;
    }

    @Override
    public Option<Integer> map(Function<String, Integer> f) {
        return null;
    }
}
