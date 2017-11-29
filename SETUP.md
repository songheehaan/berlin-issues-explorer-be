
# Setup development environment

First, if you don't already have it - create github account at [github](https://github.com) to be able to contribute to the project.

## Setup IDE (Integrated Development Environment)
  
For developing java projects it is very helpful to have IDE setup. You can either setup IDE locally or use cloud IDE which you can access from your browser. In case that you are not developing in java in general and want to have a quick look into the project, cloud IDE would be suitable as you can have it up and running quickly.


#### Cloud IDE

There are many cloud IDEs, but only few flexible enough and still not requiring credit card for registration. We chose *cloudtasty* but we are open for suggestions:)

  * create free account at [cloudtasty](http://cloudtasty.com)
  * send your username to berlinhacknights@womenwhocode.com, so that we add you to the project
  * once you get confirmation that you are added to the project, use `wwc-issues-explorer` workspace. All prerequisites are installed (java8, gradle build tool, git).
  * detailed information how to use cloud IDE and run the project there for the first time can be found [here]() 
  
### Run and build project locally

  * install java8 ([link](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html))
  * install gradle build tool ([link](https://gradle.org/install/))
  * install git ([link](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git))
  * install/upgrade your favorite IDE ([intellij](https://www.jetbrains.com/help/idea/installing-and-launching.html)/[eclipse](http://www.eclipse.org/downloads/))
  * fork the project by clicking on clone the project `git clone https://github.com/<your user name>/berlin-issues-explorer-be.git`
  * open project in your IDE and build it and run with:  
  ```gradle build && java -jar build/libs/berlin-issues-explorer-be-0.1.0.jar```

