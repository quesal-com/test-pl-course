## Background

This question tests students' programming capabilities for simple List data structures and exception handling.

Students must first complete a series of tests and then complete the scaffold of an implementation.

The question is largely based on the "Stamp Collection" in `workspacePracticeProblems/advancedC123LectureLab` with the following
changes having been applied in particular:

- The `Coin` class has an implementation of `equals` that must be used to check for duplicate coins (rather than comparing Stamp's IDs in `StampCollection`)
- The constructor of `DuplicateCoinException` receives the coin's title as argument and passes `"Duplicate: " + coinTitle` to the super constructor (rather than just passing the full exception message in `DuplicateStampException`)
- In `getCoins`, a year is passed as argument and all coins published before or during that year is returned (rather than all stamps above a given min value)

The `reference` package is provided in the question and has been slightly extended over previous versions.

## How the question is graded

The question score will be a combination of code coverage (10%), bug detection (40%), and reference tests (50%).

Students can run Jacoco in the workspace to check the coverage of their tests. Checkstyle is disabled.

For bug detection, we have 10 different buggy versions that are largely based on the buggy versions of the Stamp Collection question.
However, note that the structure is slightly different:

- The buggy implementations are maintained as source code in a package `model.buggy`.
- These buggy implementations extend a class `CoinCollectionCorrect` (a correct implementation) and only the buggy methods are implemented.
- The correct version `CoinCollection` is an empty class that extends `CoinCollectionCorrect`.

This structure makes it very easy to run the test suite with each of the buggy versions. You can simply change the 
instantiation of the test object in `@BeforeEach` with a buggy instance (e.g. `new CoinCollectionBuggy1()`).

## How the artifacts are built

The buggy jar artifacts are built with `compile-buggy-tests.sh`. For each of the buggy versions in the `model.buggy` package,
this script will create a jar file where the `CoinCollection` class has been replaced with the buggy version (where one 
method from the correct implementation is overridden). The script also needs to replace the package name from `model.buggy`
to just `model` (it does so using the `sed` command). The process creates a `tmp` directory for the build process that is
removed after the jar was created.

The correct jar is built with `compile-correct-impl.sh`. The process is similar: a `tmp` directory is created for the 
build and removed after the jar was created.

The scripts place the jar files in their corresponding locations `tests/buggy` and `tests/correct`.

## Test classes

There are two test classes:

- `CoinCollectionTest`: a reference solution for the test suite that students need to implement
- `CoinCollectionAutoTest`: the test class that the grader runs against the student's implementation. This extends
  `CoinCollectionTest` just so common fields and the `@BeforeEach` method don't need to be duplicated in both classes.

The `CoinCollectionAutoTest` and `CoinCollectionTest` need to be copied to `tests/test/model`. Only `CoinCollectionAutoTest`
is used by the grader but `CoinCollectionTest` is needed because it's extended by the other class as described above.

## Workspace setup

The workspace has the following:

- `main/model/Coin`: an exact copy of the `Coin` class in `src/main/model`
- `main/model/DuplicateCoinException`: an exact copy of the `DuplicateCoinException` class in `src/main/model`
- `main/model/CoinCollection`: this is the scaffold that students will need to implement. This is the same content as in
  the `CoinCollectionCorrect` class minus the method bodies and with class and constructor renamed (i.e. `Correct` removed)
- `test/model/CoinCollectionTest`: this is the test class scaffold that students need to complete. It is a copy of
  `CoinCollectionTest` with the method bodies removed. Note that this class has an assertion in the `@BeforeEach` method
  with a comment `// IGNORE THIS LINE`. This is in place to get coverage for the case in `Coin.equals` where completely
  different types are passed.
