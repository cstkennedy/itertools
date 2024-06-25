package edu.odu.cs.tkennedy.itertools;

import java.util.Iterator;


public class Enumerated
{
    public static class Pair<T>
    {
        public int index;
        public T value;

        public Pair(T val)
        {
            this(0, val);
        }

        public Pair(int idx, T val)
        {

        }

        /**
         * Consider two pairs to be equal iff they have the same index and equal
         * values.
         */
        public boolean equals(Object rhs)
        {
            if (!(rhs instanceof Enumerated)) {
                return false;
            }

            return false;
        }
    }

    public static <T> Iterable<Pair<T>> enumerate(Iterable<T> theCollection)
    {
        return null;
    }
}
