# Overview

Python provides various utility/convenience functions for working with
iterators. This project is an attempt to port some of that convenience to Java
for cases where...

  1. the Java Stream API does not provide the functionality.

  2. the Java Stream API would lead to less-than-readable or unnecessarily
     verbose code.

  3. a range-based (for-each) loop is required (e.g., for readability).


# Goals

## enumerate

Implement the Python `enumerate` function which allows both a value and an
index to be generated without a temporary counter variable in the driver code.

For example...

```python
for idx, val in enumerate(collection):
    print(f"{idx:>3} -> {value}")
```

would yield output in the form...

```console
  0 -> {some value}
  1 -> {some value}
  2 -> {some value}
  ...
```

where `{some value}` is a placeholder. The alternate

```python
for idx, val in enumerate(collection, start=1):
    print(f"{idx:>3} -> {value}")
```

form of enumerate should also be implemented to allow the first index to be
user specified (instead of defaulting to zero).


### Intended Java Enumerate-Loop

The Java form of the loop should take a form similiar to...

```java
for (Enumerated.Pair pair : enumerate(someCollection)) {
    System.out.printf("%3d -> %s%n", pair.index, pair.value);
}
```

where `enumerate` can be utilized as a static import.


## zip

Implement the Python `zip` function which allows to `Iterable`s to be iterated
through (looped over) as a tuple.

For example...

```python
for lhs_val, rhs_val in zip(collection_1, collection_2):
    print(f"({lhs_val}, {rhs_val})")
```

would output the first pair of entries, followed by the second, until the end
of a list is encountered. We will emulate the following behavior...

> if one list is shorter than the other return `None` or `null` until the
> longer list is exhausted.


### Intended Java Zip-Loop

The Java form of the loop should take a form similiar to...

```java
for (Zipped.Tuple tuple : zip(lhsCollection, rhsCollection)) {
    System.out.printf("(%s, %s)%n", tuple.getValueAt(0), tuple.getValueAt(1));
}
```

where `zip` can be utilized as a static import. If the position supplied to
`getValueAt` is out of bounds... an
[`IndexOutOfBoundsException`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/IndexOutOfBoundsException.html)
should be thrown.


## Generalized zip

Extend `zip` to work with an arbitrary number of `Iterable`s. 


# Notes

## Java - General Imports

```java

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Objects;


```

## Java - Class Template

```java
public class PICKANAME
{
    /**
     *
     */

    /**
     *
     */
    public PICKANAME()
    {

    }

    /**
     *
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof PICKANAME)) {
            return false;
        }

        return false;
    }

    /**
     *
     */
    @Override
    public int hashCode()
    {
        return -1
    }

    /**
     *
     */
    @Override
    public PICKANAME clone()
    {
        return null;
    }

    /**
     *
     */
    @Override
    public String toString()
    {
        return null;
    }
}
```


## JUnit - Test Suite Template

```java
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
public class TestTEMPLATE
{
    @BeforeEach
    public void setUp()
    {
        //...
    }

    @Test
    public void testThrowsReference()
    {
        /*
        assertThrows(NullPointerException.class,
            () -> {
                generic.permitsStacking();
            }
        );
        */
    }
```
