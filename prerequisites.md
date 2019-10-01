
## Pre Requisites

### JDK
Java as a platform has a development kit called JDK (Java Development Kid) and a Runtime Environment (JRE) the difference between both is, as its name says, that one of them is to write java programs and the other to run it. In order to develop in java you have to install JDK **8** (it has embedded the JRE). Let's install it using the following guide:

- [Installation on Linux](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-18-04)
- [Installation on Mac](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Installation on Windows](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Obviously, you can always google the installation process and find some youtube video :)

### IDE
The Integration Development Environment is up to you, you can use whatever you want. Most of Java developers prefers Eclipse or IntelliJ Idea. One thing to have in mind is that all the Java IDE creates it owns configuration files and folders and these has the configuration for YOUR environment, **please** do not push that to the shared repository. For git repos you can mention that stuff into the .gitignore file for untrack them all.

As we mention you can user [Eclipse](https://www.eclipse.org/downloads/packages/), [intelliJ IDEA](https://www.jetbrains.com/idea/download). All of them are good Java IDE and all has a plugin for Maven or Spring. In case of Eclipse, use the JEE version. Whatever you download and install, please find and see some videos in order to understand what plugin you will need or how to install them.

### Maven
According to [Apache Maven](https://maven.apache.org/) website:

>Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

Using Maven we will construct and package the jar file in order to execute our server. Follow this guide to install and configure it.

- [Download](https://maven.apache.org/download.cgi)
- [Install](https://maven.apache.org/install.html)
- [Run](https://maven.apache.org/install.html)

### GIT
Git is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency.

- [Downloads](https://git-scm.com/downloads)

We will use git to upload our code to github repo. Here you will find a cheatsheet that might help:
[Git cheatsheet](http://rogerdudler.github.io/git-guide/index.html)
