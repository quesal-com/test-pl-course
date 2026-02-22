package cannotstudyexample;

public class MainExample {
    public void execute(int times) {
        for (int i = 0; i < times; i++) {
            try {
                study(); // POINT A
            } catch (FeverException e) { // POINT B
                System.out.println("I have a fever. Stop.");
                break; // POINT C
            } catch (FeelingSickException e) { // POINT D
                System.out.println("Feeling unwell but need to keep studying"); // POINT E
            } catch (UnfocusedException e) { // POINT F
                System.out.println("I'm unfocused but still keep going"); // POINT G
            } catch (CannotStudyException e) { // POINT H
                System.out.println("I cannot study. Stop."); // POINT J
                break;
            }
        }
    }

  /*public void execute(int times) {
    for (int i = 0; i < times; i++) {
      try {
        // POINT A
      } catch (------------) { // POINT B
        // POINT C
      } catch (------------) { // POINT D
        // POINT E
      } catch (------------) { // POINT F
        // POINT G
      } catch (------------) { // POINT H
        // POINT J
      }
    }
  }*/

    private void study() throws CannotStudyException {
        // IMPLEMENTATION OMITTED
    }

}
