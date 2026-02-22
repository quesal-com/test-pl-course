package reference;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.fail;

public class ReferenceTestClass {
    private reference.ReferenceClass testReference;

    @BeforeEach
    void runBefore() {
        testReference = new ReferenceClass("TestClass");
    }

    @Test
    void sampleTestMethod() {
        // assertEquals(expected, actual);
        // assertTrue(boolean);
        // assertFalse(boolean);
        // assertNull(objReference);
    }

    @Test
    void otherSampleTestMethod() {
        try {
            testReference.someMethod(7);
        } catch (CheckedException e) {
            fail("Unexpected exception");
        }
    }
}
