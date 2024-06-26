package edu.odu.cs.tkennedy.itertools;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static edu.odu.cs.tkennedy.itertools.Enumerated.enumerate;


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
public class TestEnumerated
{
    @BeforeEach
    public void setUp()
    {
        //...
    }

    @Test
    public void testBasicUse()
    {
        // How do I call Enumerated.enumerate?
		List<String> someCollection = Arrays.asList(
			"Hello", "Java", ", ", "Python", "already", "has", "emumerate", "!!!!"
		);

		Iterable<Enumerated.Pair<String>> collection = enumerate(someCollection);
        Iterator<Enumerated.Pair<String>> it = collection.iterator();

        Enumerated.Pair<String> expected = null;
        Enumerated.Pair<String> actual = null;

        expected = new Enumerated.Pair(0, "Hello");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Enumerated.Pair(1, "Java");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Enumerated.Pair(2, ", ");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Enumerated.Pair(3, "Python");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Enumerated.Pair(4, "already");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Enumerated.Pair(5, "has");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Enumerated.Pair(6, "emumerate");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Enumerated.Pair(7, "!!!!");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        assertThat(it.hasNext(), is(not(true)));
    }
}
