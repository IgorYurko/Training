package iy.jspspring.training.controller;

import iy.jspspring.training.pojo.UserPojo;

import java.util.Comparator;

public class Comparators
{
    public static final Comparator<String> stringComparator = String::compareTo;
    public static final Comparator<String> stringReversComparator = (aStr,bStr) -> bStr.compareTo(aStr);
    public static final Comparator<Integer> integerComparator = Integer::compareTo;
    public static final Comparator<Integer> integerReversComparator = (aInt, bInt) -> bInt.compareTo(aInt);
    public static final Comparator<UserPojo> userPojoComparator = (aUser, bUser) -> {
        if (aUser == bUser) return 0;
        int compareTo = aUser.getName().compareTo(bUser.getName());
        if (compareTo == 0){
            return aUser.getPassword().compareTo(bUser.getPassword());
        }
        return compareTo;
    };

    public static final Comparator<UserPojo> userPojoReversComparator = (aUser, bUser) -> {
        if(aUser == bUser) return 0;
        int compareTo = - (aUser.getName().compareTo(bUser.getName()));
        if (compareTo == 0){
            return aUser.getPassword().compareTo(bUser.getPassword());
        }
        return compareTo;
    };
}

