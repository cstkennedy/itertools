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
public class Zipped
{
    public static class Tuple<T, U>
    {
        public T lhsValue;
        public U rhsValue;

        public Tuple(final T lhs, final U rhs)
        {
            this.lhsValue = lhs;
            this.rhsValue = rhs;
        }

        public Object getValueAt(final int idx)
        {

            if (idx == 0) {
                return lhsValue;
            }

            if (idx == 1) {
                return rhsValue;
            }

            return null;
        }

        /**
         * Consider two tuples to be equal iff they have eqaul lsh and rhs values
         * values.
         */
        @Override
        public boolean equals(final Object rhs)
        {
            if (!(rhs instanceof Zipped.Tuple)) {
                return false;
            }

            final Zipped.Tuple<T, U> rhsTuple = (Zipped.Tuple<T, U>) rhs;

            return this.lhsValue.equals(rhsTuple.lhsValue)
                && this.rhsValue.equals(rhsTuple.rhsValue);
        }

        @Override
        public int hashCode()
        {
            return this.lhsValue.hashCode()
                 + (2 * this.rhsValue.hashCode());
        }
    }

    /**
     * This is an iterator that consumes an existing iterator (wrapped) to
     * return an index paired with each value returned by the existing wrapped iterator.
     */
    public static class ZippedIterator<T, U>
        implements Iterator<Zipped.Tuple<T, U>>, Iterable<Zipped.Tuple<T, U>>
    {
        /**
         * T.B.W.
         */
        private Iterator<T> lhsIt;

        /**
         * T.B.W.
         */
        private Iterator<U> rhsIt;

        /**
         * There is no "reasonable" default starting state. An existing
         * iterator must be supplied.
         */
        private ZippedIterator()
        {

        }

        /**
         * T.B.W.
         */
        private ZippedIterator(final Iterable<T> lhs, final Iterable<U> rhs)
        {
            this(lhs.iterator(), rhs.iterator());
        }

        /**
         * T.B.W.
         */
        private ZippedIterator(final Iterator<T> lhsIt, final Iterator<U> rhsIt)
        {
            this.lhsIt = lhsIt;
            this.rhsIt = rhsIt;
        }

        @Override
        public boolean hasNext()
        {
            return this.lhsIt.hasNext()
                || this.rhsIt.hasNext();
        }

        @Override
        public Zipped.Tuple<T, U> next()
        {
            T lhsVal = null;
            U rhsVal = null;

            if (this.lhsIt.hasNext()) {
                lhsVal = lhsIt.next();
            }

            if (this.rhsIt.hasNext()) {
                rhsVal = rhsIt.next();
            }

            return new Zipped.Tuple<T, U>(lhsVal, rhsVal);
        }

        @Override
        public ZippedIterator<T, U> iterator()
        {
            return this;
        }
    }

    public static <T, U> Iterable<Zipped.Tuple<T, U>> zip(final Iterable<T> lhsCollection, final Iterable<U> rhsCollection)
    {
        return new ZippedIterator<T, U>(lhsCollection, rhsCollection);
    }
}
