This project demonstrates an area of confusion where I am unsure whether it is a bug or my mistake. However, I am indeed
encountering this issue.

## Reproduction Steps

1. Run the project using Gradle, which will open PyCharm.
2. Create a new project named 'pythonProject' using the 'virtualenv' option.
3. Open the tool window by navigating to Menu -> View -> Tool Windows -> AirScript.
4. Check the console and then click the run button to check the console again. It should print the current project
   information.
5. Go back to PyCharm and select 'pythonProject'. Press 'Shift+F6' to modify the 'directory' and 'project' to '
   pythonProject2'.
6. Click the run button and observe that the printed project information still shows 'pythonProject' instead of the
   modified 'pythonProject2'.
7. Close the running plugin debugger and open it again. It will prompt a 'venv' error, as the 'venv' path is still
   looking for the previous project path.