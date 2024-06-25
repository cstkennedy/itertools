# Overview

Python provides various utility/convenience functions for working with
iterators. This project is an attempt to port some of that convenience to Java
for cases where...

  1. the Java Stream API does not provide the functionality

  2. the Java Stream API would lead to less-than-readable or unnecessarily
     verbose code.

  3. a range-based (for-each) loop is required (e.g., for readability)


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


## Generalized zip

Extend `zip` to work with an arbitrary number of `Iterables`. 
