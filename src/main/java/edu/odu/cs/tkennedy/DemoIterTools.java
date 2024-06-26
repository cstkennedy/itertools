package edu.odu.cs.tkennedy;

import java.util.List;
import java.util.Arrays;

import edu.odu.cs.tkennedy.itertools.Enumerated;

import static edu.odu.cs.tkennedy.itertools.Enumerated.enumerate;

@SuppressWarnings(
    "PMD"
)
public class DemoIterTools
{
    public static void main(String... args)
    {
        System.out.println("IterTools!!");

		//----------------------------------------------------------------------
		// Enumerate reference/demo
		//----------------------------------------------------------------------
		List<String> someCollection = Arrays.asList(
			"Hello", "Java", ", ", "Python", "already", "has", "emumerate", "!!!!"
		);

		for (Enumerated.Pair pair : enumerate(someCollection)) {
			System.out.printf("%3d -> %s%n", pair.index, pair.value);
		}
    }
}
