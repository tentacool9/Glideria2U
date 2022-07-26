package src.common.utils;

import src.common.model.Order;

import java.util.Comparator;

public class Comparators {
    public static Comparator sortOrdersByLatest = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Order)o2).getDate().compareTo(((Order)o1).getDate());
        }
    };
}
