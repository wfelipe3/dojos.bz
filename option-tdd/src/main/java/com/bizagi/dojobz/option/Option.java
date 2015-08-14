package com.bizagi.dojobz.option;

import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Created by WilliamE on 13/08/2015.
 */
public abstract class Option<T> {

    public static <T> Option<T> some(T i) {
        if (i == null)
            throw new NoSuchElementException();
        else
            return new Some<>(i);
    }

    public static <T> Option<T> none() {
        return new None();
    }

    public static <T> Option<T> someNullable(T t) {
        if (t == null)
            return new None<>();
        else
            return new Some<>(t);
    }

    public abstract T get();

    public abstract T orElse(T t);

    public abstract Option<Integer> map(Function<String,Integer> f);
}
