package edu.odu.cs.tkennedy.itertools;

import java.util.Iterator;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Cloned
{
    /**
     * This is clone helper based on the "quirks" of the Cloneable interface in
     * Java.
     * <p>
     * The code within is based on <https://stackoverflow.com/a/1138790>.
     */
    private static <T extends Cloneable> T performClone(T srcObj)
    {
        T clonedValue = null;

        try {
            clonedValue = (T) srcObj
                .getClass()
                .getMethod("clone")
                .invoke(srcObj);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException err) {
            // No-op
        }

        return clonedValue;
    }

    public static class CloneIterator<T extends Cloneable>
        implements Iterator<T>, Iterable<T>
    {
        private Iterator<T> sourceIt;

        public CloneIterator(final Iterator<T> sourceIt)
        {
            this.sourceIt = sourceIt;
        }

        @Override
        public boolean hasNext()
        {
            return sourceIt.hasNext();
        }

        @Override
        public T next()
        {
            return performClone(this.sourceIt.next());
        }

        @Override
        public Iterator<T> iterator()
        {
            return this;
        }

    }

    public static <T extends Cloneable> Iterable<T> cloned(Iterator<T> sourceIt)
    {
        return new CloneIterator<T>(sourceIt);
    }

    public static <T extends Cloneable> Iterable<T> cloned(Iterable<T> sourceCollection)
    {
        return cloned(sourceCollection.iterator());
    }
}
