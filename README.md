# Overview

Python provides various utility/convenience functions for working with
iterators. This project is an attempt to port some of that convenience to Java
for cases where...

  1. the Java Stream API does not provide the functionality.

  2. the Java Stream API would lead to less-than-readable or unnecessarily
     verbose code.

  3. a range-based (for-each) loop is required (e.g., for readability).


# Status

| Operation   | Basic       | Generalized |
| :----       | :--:        | :--:        |
| `enumerate` | Implemented |             |
| `zip`       | Implemented |             |
| `chain`     |             |             |
| `cloned`    | Implemented |             |


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


## chain

Implement the Python `chain` function which allows mutiple `Iterable`s to be
traversed as if they are one collection.

For example...

```python
for val chain(collection_1, collection_2):
    print(f"{val}")
```

### Intended Java Chain-Loop

The Java form of the loop should take a form similiar to...

```java
for (T value : zip(lhsCollection, rhsCollection)) {
    System.out.printf("%s%n", value);
}
```

## Generalized chain

Extend `chain` to work with an arbitrary number of `Iterable`s. 


# cloned

Implement the Rust [itertools `cloned`
function](https://docs.rs/itertools/latest/itertools/fn.cloned.html) which
returns deep copies of every item in an`Iterable`.

For example...

```rust
let mut dupes: Vec<T> = Vec::new();

for dup in cloned(some_collection) {
    dupes.push(dup);
}
```


### Intended Java Cloned-Loop

The Java form of the loop should take a form similiar to...

```java
List<T> dupes = new ArrayList<>();

for (T value : cloned(someCollection)) {
    dupes.add(dup);
}
```

