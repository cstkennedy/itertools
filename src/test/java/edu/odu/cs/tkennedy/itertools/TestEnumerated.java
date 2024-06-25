package edu.odu.cs.tkennedy.itertools;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;


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
        Enumerated.Pair expected = null;

        // TODO: This needs to be replaced with an iterator
        Enumerated.Pair actual = null;

        expected = new Enumerated.Pair(0, "Hello");
        assertThat(actual, is(equalTo(expected)));

        expected = new Enumerated.Pair(1, "Java");
        assertThat(actual, is(equalTo(expected)));

        expected = new Enumerated.Pair(2, ", ");
        assertThat(actual, is(equalTo(expected)));

        expected = new Enumerated.Pair(3, "Python");
        assertThat(actual, is(equalTo(expected)));

        expected = new Enumerated.Pair(4, "already");
        assertThat(actual, is(equalTo(expected)));

        expected = new Enumerated.Pair(5, "has");
        assertThat(actual, is(equalTo(expected)));

        expected = new Enumerated.Pair(6, "emumerate");
        assertThat(actual, is(equalTo(expected)));

        expected = new Enumerated.Pair(7, "!!!!");
        assertThat(actual, is(equalTo(expected)));
    }
}
