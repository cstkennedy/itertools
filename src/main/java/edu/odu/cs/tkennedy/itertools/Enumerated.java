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
            this.index = idx;
            this.value = val;
        }

        /**
         * Consider two pairs to be equal iff they have the same index and equal
         * values.
         */
        public boolean equals(Object rhs)
        {
            if (!(rhs instanceof Enumerated.Pair)) {
                return false;
            }

            Enumerated.Pair rhsPair = (Enumerated.Pair) rhs;

            return this.index == rhsPair.index
                && this.value.equals(rhsPair.value);
        }
    }

    public class IndexedIterator<T> implements Iterator<Enumerated.Pair<T>>
    {
        public IndexedIterator()
        {

        }

        public boolean hasNext()
        {
            return false;
        }

        @Override
        public Enumerated.Pair<T> next()
        {
            return null;
        }
    }

    public class IndexedWrapper<T> implements Iterable<Enumerated.Pair<T>>
    {
        public Iterator<Enumerated.Pair<T>> iterator()
        {
            return new IndexedIterator<T>();
        }
    }

    public static <T> Iterable<Pair<T>> enumerate(Iterable<T> theCollection)
    {
        return null;
    }
}
