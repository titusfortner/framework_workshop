package test.exercises;

import org.junit.Test;
import test.data.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//
// Exercise:
//
// Update src/test/data/Person.java to work with this test
//

public class ContextualDataObject {

    @Test
    public void personData() {
        Person person = Person.beverlyHills();

        assertEquals("90210", person.zipCode);
        assertNotNull(person.firstName);
        assertNotNull(person.lastName);
    }

}
