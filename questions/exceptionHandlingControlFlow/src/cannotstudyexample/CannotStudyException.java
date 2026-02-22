package cannotstudyexample;

class CannotStudyException extends Exception {
}
class FeelingSickException extends CannotStudyException {
}
class UnfocusedException extends CannotStudyException {
}
class BetterThingsToDoException extends CannotStudyException {
}
class RunnyNoseException extends FeelingSickException {
}
class HeadacheException extends FeelingSickException {
}
class FeverException extends FeelingSickException {
}
