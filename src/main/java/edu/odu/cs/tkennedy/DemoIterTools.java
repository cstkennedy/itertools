package edu.odu.cs.tkennedy;

import java.util.List;
import java.util.Arrays;

import edu.odu.cs.tkennedy.itertools.Enumerated;
import edu.odu.cs.tkennedy.itertools.Zipped;

import static edu.odu.cs.tkennedy.itertools.Enumerated.enumerate;
import static edu.odu.cs.tkennedy.itertools.Zipped.zip;

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

		//----------------------------------------------------------------------
		// Zip reference/demo
		//----------------------------------------------------------------------
		for (Zipped.Tuple tuple : zip(someCollection, someCollection)) {
            System.out.printf("(%s, %s)%n", tuple.getValueAt(0), tuple.getValueAt(1));
        }

    }
}
