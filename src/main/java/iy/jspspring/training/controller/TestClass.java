package iy.jspspring.training.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public final class TestClass<T extends Serializable>
{
    private final T name;

//    private final T age;

    private final List<T> list;

    public enum Temperature
    {
        CELSIY("one"),
        FAHRENGATE("two");

        private String value;

        Temperature(String s)
        {
            this.value = s;
        }

        public String getTemperature()
        {
            return this.value;
        }
    }

    TestClass(T name)
    {
        this.name = name;
        this.list = new ArrayList<>();
//        this.age = age;
    }

    @SuppressWarnings("unchecked")
    public List<T> getList()
    {
        ArrayList<T> temporaryList = (ArrayList<T>) this.list;
        return (List<T>) temporaryList.clone();
    }

//    public T getAge()
//    {
//        return age;
//    }

    public T getName()
    {
        return name;
    }
}