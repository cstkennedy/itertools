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

import static edu.odu.cs.tkennedy.itertools.Zipped.zip;


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
public class TestZipped
{
    @BeforeEach
    public void setUp()
    {
        //...
    }

    @Test
    public void testBasicUse()
    {
        // How do I call Zipped.enumerate?
		List<String> someCollection = Arrays.asList(
			"Hello", "Java", ", ", "Python", "already", "has", "enumerate", "!!!!"
		);

		Iterable<Zipped.Tuple<String, String>> collection = zip(someCollection, someCollection);
        Iterator<Zipped.Tuple<String, String>> it = collection.iterator();

        Zipped.Tuple<String, String> expected = null;
        Zipped.Tuple<String, String> actual = null;

        expected = new Zipped.Tuple("Hello", "Hello");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Zipped.Tuple("Java", "Java");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Zipped.Tuple(", ", ", ");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Zipped.Tuple("Python", "Python");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Zipped.Tuple("already", "already");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Zipped.Tuple("has", "has");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Zipped.Tuple("enumerate", "enumerate");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        expected = new Zipped.Tuple("!!!!", "!!!!");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(equalTo(expected)));

        assertThat(it.hasNext(), is(not(true)));
    }

}
