
# AutoTests: Reproducing IDE Auto Test Focus Stealing

This tiny Gradle Java project is designed to reproduce disruptive behavior when IDEs (CLion, RustRover, PyCharm, IntelliJ IDEA) run tests automatically on code changes.

What you should observe in the IDE when auto tests are enabled:
- Tests re-run frequently while you type/save.
- Navigation pops you into failing tests (focus changes) instead of staying in the editor.
- Flaky test failures can keep stealing focus back and forth.
- Long-running tests keep the test runner active in the background.

## Project layout
- `src/Main.java`: simple code with a slow method.
- `src/MainTest.java`: has one passing and one intentionally failing test.
- `src/FlakyTest.java`: fails on odd seconds to simulate flakiness.
- `src/LongRunningTest.java`: takes a few seconds to complete using `slowDouble`.

> Note: For simplicity this project uses a single `src` directory for both sources and tests. The Gradle build is configured to exclude `*Test.java` from the main source set and include them in the test source set.

## How to reproduce in JetBrains IDEs
1. Open this project in your IDE.
2. Make sure Gradle has finished indexing and JUnit 5 is available.
3. Open the test tool window and enable automatic test execution:
   - In IntelliJ IDEA/PyCharm/RustRover/CLion test tool window, click the "Rerun Tests Automatically" (auto-run) toggle.
4. Start editing `src/Main.java` (e.g., add spaces, comments, or tweak `add` implementation). Each small change should trigger a test re-run.
5. Observe:
   - The IDE navigates to the first failing test (e.g., `MainTest#testAdditionFails`) and may steal focus from your current editor.
   - `FlakyTest#sometimesFailsBasedOnTime` fails intermittently, causing repeated re-navigation/focus changes.
   - `LongRunningTest#slowProcessingShouldPassEventually` keeps the test runner busy for several seconds, increasing the chance of focus disruptions during active edits.
