package edu.odu.cs.tkennedy.itertools;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static edu.odu.cs.tkennedy.itertools.Cloned.cloned;

/**
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 *
 * This is technically an Integration Test.
 */
@SuppressWarnings({
    "PMD.AtLeastOneConstructor",
    "PMD.BeanMembersShouldSerialize",
    "PMD.JUnitAssertionsShouldIncludeMessage",
    "PMD.JUnitTestContainsTooManyAsserts",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LawOfDemeter"
})
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestCloned
{
    private static class Datum implements Cloneable
    {
        private String value;

        public Datum(String val)
        {
            this.value = val;
        }

        @Override
        public boolean equals(Object rhs)
        {
            if (rhs instanceof String) {
                String rhsStr = (String) rhs;
                return this.value.equals(rhsStr);
            }

            if (!(rhs instanceof Datum)) {
                return false;
            }

            Datum rhsDatum = (Datum) rhs;

            return this.value.equals(rhsDatum.value);
        }

        @Override
        public int hashCode()
        {
            return this.value.hashCode();
        }

        @Override
        public Datum clone()
        {
            return new Datum(this.value);
        }
    }

    @Test
    public void testBasic()
    {
        List<Datum> srcWords = Arrays.asList(
            new Datum("Rust"),
            new Datum("already"),
            new Datum("has"),
            new Datum("cloned"),
            new Datum("!!!!")
        );
        Iterator<Datum> srcIt = srcWords.iterator();

        Iterable<Datum> clonedData = cloned(srcWords);
        Iterator<Datum> clonedIt = clonedData.iterator();

        Datum actual = null;

        assertThat(clonedIt.hasNext(), is(true));
        actual = clonedIt.next();
        assertThat(actual, is(equalTo("Rust")));
        assertThat(actual, not(sameInstance(srcIt.next())));

        assertThat(clonedIt.hasNext(), is(true));
        actual = clonedIt.next();
        assertThat(actual, is(equalTo("already")));
        assertThat(actual, not(sameInstance(srcIt.next())));

        assertThat(clonedIt.hasNext(), is(true));
        actual = clonedIt.next();
        assertThat(actual, is(equalTo("has")));
        assertThat(actual, not(sameInstance(srcIt.next())));

        assertThat(clonedIt.hasNext(), is(true));
        actual = clonedIt.next();
        assertThat(actual, is(equalTo("cloned")));
        assertThat(actual, not(sameInstance(srcIt.next())));

        assertThat(clonedIt.hasNext(), is(true));
        actual = clonedIt.next();
        assertThat(actual, is(equalTo("!!!!")));
        assertThat(actual, not(sameInstance(srcIt.next())));
    }
}
