## Step 1: Clone from remote
The first thing I noticed was that your `.idea` folder is committed on GitHub. This is not advisable. If I clone your `.idea` and my settings don't match yours exactly, I am unable to run the program. Less importantly, your `gradle.properties` should not be committed either.
## Step 2: Run all tests.
Four tests is not enough. It's good that they all pass, but running tests with coverage shows...0% coverage, somehow. It is true that your error handling and view-layer classes need not be tested, but there are more untested assets in this project.
## Step 3: Run both CLI and GUI versions.
### CLI
I would heavily recommend against calling your CLI-based classes "UI" and "UI Starter."
Also, given that UIStarter is 11 lines long, it would be better to simply create that <kbd>main</kbd> method inside of `UI.java`.
I think this is taking SRP to an extreme that causes more confusion than clarity.

Upon running UIStarter, I was prompted to enter an article name.
Instead of fetching the revisions, I got a thread error:
```cmd
Caused by: java.lang.IllegalStateException: This operation is permitted on the event thread only; currentThread = main
```
I'm not certain how this even happens myself.
### GUI
This works perfectly though.
## Step 4: Code Analysis
### Testing
As mentioned before, your four tests have zero or near-zero coverage according to the automatic testing.
Keep in mind that, at this time, I have not reviewed your actual code until now.

| Class                    | Test Class                     | Coverage        | Comments                                                                                                                                                                                                           |
|--------------------------|--------------------------------|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `ReadJSONFile.java`      | `ReadJSONFileTest.java`        | 0/0 (undefined) | Maybe it's my dyslexia, but the lack of vertical formatting makes this impossible for me to read quickly. From what I see, ReadJSONFile doesn't read Json at all. It fetches the JSON data from the MediaWiki API. |
| `RedirectionParser.java` | <kbd>none</kbd> (% irrelevant) | 0/1 (0%)        | **This needs a test.** This file is small. My opinion is that all of your JSON should be parsed in the same place. Parsing it multiple times in multiple places causes undue load on the processor.                |
| `Revision.java`          | <kbd>none</kbd> (% irrelevant) | 0/1 (0%)        | **This needs a test.** To add to the previous row's column, a redirect could probably be stored here, too.                                                                                                         |
| `RevisionFormatter.java` | `RevisionFormatterTest.java`   | 0/1 (0%)        | My take, your list of timestamps and your list of users should be contained in a single object as opposed to having multiple objects. It seems arbitrary and memory-intensive.                                     |
| `RevisionParser.java`    | `RevisionParserTest.java`      | 0/1 (0%)**      | So, this tests the method from `Revision.java`. Your tests need restructuring to actually test methods of the classes they correspond to.                                                                          |
_Coverage is according to my own calculations rather than the "Run tests with Coverage" operation._
Check the diffs in the production classes to see my formatting changes.
### View-Layer
#### UI / GraphicalUserInterface
These should not be running model code. They both have a duplicate method that they should not have permission to handle.

I recommend a complete reconstruction of the JavaFX application.
It should have its own package, and it should have three things:
an application class, a controller class, and FXML. 
Not to toot my own horn, but see what Cameron and I did for an example.
As-is, I have no idea what's really going on.
#### Starters
Since they solely consist of main methods, these main methods should be moved into their respective overarching classes.
### Error Handling
Your error handling should wrap other processes
It has no business actually running code, and instead should wrap the code in a try-catch with nothing of value on its own.
## Final Analysis
This project has no proper test coverage, and the Single Responsibility Principle is taken to the extreme.  
The code is difficult to read, the error with the CLI implementation is totally beyond me, and the lack of vertical structure makes matters worse.

That said, the code does run. For the most part. Go back to the textbook (I hate the textbook too) and try a deep-dive into TDD.  
This code appears to me as if production was rushed, and tests were secondary concerns.

Also don't sweat all the notes and comments. Like with our project notes, I go a little heavy. It's the written language emphasis courses.