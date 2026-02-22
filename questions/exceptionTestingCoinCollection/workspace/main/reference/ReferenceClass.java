package reference;

import java.util.List;
import java.util.ArrayList;

public class ReferenceClass extends AnotherClass implements AnInterface {
    private List<String> nameList;
    private String name;

    public ReferenceClass(String name) {
        super(name);
        this.nameList = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void aMethod() {
        // stub
    }

    @Override
    public void bMethod() {
        super.bMethod();
        // stub
    }

    public void someMethod(int value) throws CheckedException {
        if (value > 100) {
            // do something
        } else if (value > 0) {
            // otherwise do something else
        } else {
            throw new CheckedException();
        }
    }

    public int someOtherMethod() {
        int data = 0;

        while (data <= 100) {
            // do something
        }

        return data;
    }

    public int countNamesEqualTo(String other) throws UncheckedException {
        if (other == null || other.isEmpty()) {
            throw new UncheckedException("Illegal argument provided: " + other);
        }

        int numNames = 0;

        for (String nextName : nameList) {
            if (nextName.equals(other)) {
                numNames++;
            }
        }

        return numNames;
    }

    public int sumIntegersTo(int max) {
        int sum = 0;

        for (int num = 1; num <= max; num++) {
            sum = sum + num;
        }

        return sum;
    }
}
