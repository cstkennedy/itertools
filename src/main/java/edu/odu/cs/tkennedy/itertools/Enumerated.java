package edu.odu.cs.tkennedy.itertools;

import java.util.Iterator;


/**
 * Wrapper for static<code>enumerate</code> functions that provide indexed iterators.
 */
@SuppressWarnings({
    "PMD.ClassNamingConventions",
    "PMD.ShortVariable",
    "PMD.ShortClassName",
    "PMD.BeanMembersShouldSerialize",
    "PMD.OnlyOneReturn"
})
public class Enumerated
{
    public static class Pair<T>
    {
        public int index;
        public T value;

        public Pair(final T val)
        {
            this(0, val);
        }

        public Pair(final int idx, final T val)
        {
            this.index = idx;
            this.value = val;
        }

        /**
         * Consider two pairs to be equal iff they have the same index and equal
         * values.
         */
        @Override
        public boolean equals(final Object rhs)
        {
            if (!(rhs instanceof Enumerated.Pair)) {
                return false;
            }

            final Enumerated.Pair<T> rhsPair = (Enumerated.Pair<T>) rhs;

            return this.index == rhsPair.index
                && this.value.equals(rhsPair.value);
        }

        @Override
        public int hashCode()
        {
            return this.index
                 + (2 * this.value.hashCode());
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
        private IndexedIterator(final Iterator<T> it)
        {
            this(it, 0);
        }

        /**
         * T.B.W.
         */
        private IndexedIterator(final Iterator<T> it, final int start)
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
        public IndexedIterable(final Iterable<T> collection)
        {
            this(collection, 0);
        }

        /**
         * T.B.W.
         */
        public IndexedIterable(final Iterable<T> collection, final int start)
        {
            this.theCollection = collection;
            this.start = start;
        }

        @Override
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
    public static <T> Iterable<Enumerated.Pair<T>> enumerate(final Iterable<T> theCollection)
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
    public static <T> Iterable<Enumerated.Pair<T>> enumerate(final Iterable<T> theCollection, final int start)
    {
        return new IndexedIterable<T>(theCollection, start);
    }
}
