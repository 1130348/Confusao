Cleansheets 2015
================
  
This readme file is written in [markdown](http://daringfireball.net/projects/markdown/). 

Startup Guide
-------------

### First Step - Requirements

The first thing you need to do is to make sure you have all the requirements. Please read the section about requirements in this file.

### Second Step - Build and Run Cleansheets

The second step is to follow the section regarding the scripts to build and run Cleansheets. You can also open the project with Netbeans and run Cleansheets from Netbeans.

### Third Step - Study the Project

The third step we propose is to study the code and documentation. In particular you should study the extension mechanism of Cleansheets. 

You will find a very simple extension named "Simple Extension". Open the javadoc documentation and read the documentation regarding the package `csheets.ext.simple`.

### Fourth Step - Study The Example Use Case 

You can find an example of the implementation of a use case in the package `csheets.ext.comments`. The technical documentation of use cases should appear in sub-packages of `chseets.userstories`. For the comments extension you find the technical documentation in the package `chseets.userstories.core02_01.comments`.  

Global requirements
-------------------

### Graphviz
You should install [Graphviz](http://www.graphviz.org/) in your computer 
to be able to generate all type of uml diagrams with plantuml in javadoc.

### Plantuml
[Plantuml](http://www.plantuml.com) is a jar file that is already included in the project and that produces uml diagrams from a textual descrition.

### ANTLRWorks

ANTLRWorks is already included in the project.

ANTLR v3 (and ANTLRWorks) are used in the formula parser and lexer. The antlr-3.5.2-complete.jar contains both APIs of 
ANTLR: v2 and v3. ANTLRWorks is contained in a jar file that is located in the lib folder (antlrworks-1.5.2-complete.jar). You can run this jar
to open the IDE for developing ANTLR v3 grammars. Using ANTLRWorks gives you the possibility to have a smart editor for your grammar and also to view 
a graphical parser tree of expressions (using the "interpreter"). 

To run ANTLRWorks execute in the terminal:
    
    cd lib
    java -jar ./antlrworks-1.5.2-complete.jar

Netbeans requirements
---------------------

### Plantuml

This plugin adds support for realtime preview of plantuml diagrams. You should install it from the Plugins window of Netbeans.

### Markdown Support

This plugin adds support for markdown syntax on readme files (like this one). You should download the plugin from [Flow NetBeans Markdown](https://github.com/madflow/flow-netbeans-markdown) and install it.

### Display readme files in project view

This is a very simple plugin that simple displays readme files in the project view. You should install it from the Plugins window of Netbeans.

### ANTLRWorks

You may install this netbeans plugin to have a smart editor for grammar files. This plugin is optional since the ANTLRWorks jar file that comes with the project does everything this plugin does and more.

**This plugin only works with Netbeans 8.0.1!**

Scripts
-------

These are some very important scripts that you should use in the weekly demonstrations of the project and **you should update as necessary**. 

Scripts with the .sh extension are to be used in Linux and Mac OS. Scripts with the .bat extension are to be used in Windows.

**Attention: You should always maintain the scripts up-to-date!**

### One of the first tasks is to generate technical documentation and study it:
For that you should do:

    cd scripts
    ./makeuml.sh
    ./makedoc.sh

Then open the file `doc/api/index.html` in a browser.

Then you should study the scripts!

### To build the csheets.jar you should do:

    cd scripts
    ./cc.sh
    ./makejar.sh


### To execute csheets (from csheets.jar):

    cd scripts
    ./run.sh


### To build the tests:

    cd scripts
    ./build_tests.sh

### To execute the tests:

    cd scripts
    ./run_tests.sh

### To execute a console to tests formulas:

    cd scripts
    ./console.sh

### To remove generated files (.class, etc):

    cd scripts
    ./clean.sh
