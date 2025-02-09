@echo off

set "dirs=D:/Projects/GitProjects/Mono D:/Projects/GitProjects/PDF Online D:/Projects/JavaProjects/Practice/untitled D:/Projects/PythonProjectsForGit D:/Projects/ReactProjects/react-learn-app D:/Projects/VSCodeProjects/web/blogs D:/Projects/VueProjects/blog D:/Projects/VueProjects/bookstore D:/Projects/VueProjects/linyu-client D:/Projects/WebstormProjects/Practice/vue-learn"

for %%d in (%dirs%) do (
    if exist "%%d\.git" (
        rd /s /q "%%d\.git"
        echo Deleted.git folder in %%d
    ) else (
        echo.git folder not found in %%d
    )
)

pause