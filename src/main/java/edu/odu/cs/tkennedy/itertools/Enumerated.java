package edu.odu.cs.tkennedy.itertools;

import java.util.Iterator;


/**
 * Wrapper for static<code>enumerate</code> functions that provide indexed iterators.
 */
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
        @Override
        public boolean equals(Object rhs)
        {
            if (!(rhs instanceof Enumerated.Pair)) {
                return false;
            }

            Enumerated.Pair<T> rhsPair = (Enumerated.Pair<T>) rhs;

            return this.index == rhsPair.index
                && this.value.equals(rhsPair.value);
        }
    }

    /**
     * This is an iterator that consumes an existing iterator (wrapped) to
     * return an index paired with each value returned by the existing wrapped iterator.
     */
    public static class IndexedIterator<T> implements Iterator<Enumerated.Pair<T>>
    {
        /**
         * T.B.W.
         */
        private int idx;

        /**
         * T.B.W.
         */
        private Iterator<T> wrappedIt;

        /**
         * There is no "reasonable" default starting state. An existing
         * iterator must be supplied.
         */
        private IndexedIterator()
        {

        }

        /**
         * T.B.W.
         */
        private IndexedIterator(Iterator<T> it)
        {
            this(it, 0);
        }

        /**
         * T.B.W.
         */
        private IndexedIterator(Iterator<T> it, int start)
        {
            this.wrappedIt = it;
            this.idx = start;
        }

        @Override
        public boolean hasNext()
        {
            return this.wrappedIt.hasNext();
        }

        @Override
        public Enumerated.Pair<T> next()
        {
            return new Enumerated.Pair<T>((this.idx)++, this.wrappedIt.next());
        }
    }

    /**
     * This is an iterable that wraps an existing iterable. It is assumed that
     * the original (wrapped) iterable is finite.
     */
    public static class IndexedIterable<T> implements Iterable<Enumerated.Pair<T>>
    {
        /**
         * T.B.W.
         */
        private int start;

        /**
         * T.B.W.
         */
        private Iterable<T> theCollection;

        /**
         * T.B.W.
         */
        public IndexedIterable(Iterable<T> collection)
        {
            this(collection, 0);
        }

        /**
         * T.B.W.
         */
        public IndexedIterable(Iterable<T> collection, int start)
        {
            this.theCollection = collection;
            this.start = start;
        }


        public Iterator<Enumerated.Pair<T>> iterator()
        {
            return new IndexedIterator<T>(this.theCollection.iterator(), this.start);
        }
    }

    /**
     * Generated an Iterable sequence of index-value pairs in the form (index,
     * value).
     *
     * @param theCollection collection of values to index
     */
    public static <T> Iterable<Enumerated.Pair<T>> enumerate(Iterable<T> theCollection)
    {
        return new IndexedIterable<T>(theCollection);
    }

    /**
     * Generated an Iterable sequence of index-value pairs in the form (index,
     * value).
     *
     * @param theCollection collection of values to index
     * @param start starting (first) index
     */
    public static <T> Iterable<Enumerated.Pair<T>> enumerate(Iterable<T> theCollection, int start)
    {
        return new IndexedIterable<T>(theCollection, start);
    }
}
