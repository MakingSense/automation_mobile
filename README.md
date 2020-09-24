# Apppium tutorial framework
This is a mobile automation framework using Appium
To start working with this framework you will have to install:
* [Appium](http://appium.io/).
* [Java](https://www.java.com/es/download/)
* [IntelliJ](https://www.jetbrains.com/es-es/idea/) or any other IDE
* [AndriodStudio](https://developer.android.com/studio)
* NOTE: The configuration required to run tests in iOS will be updated  

## Instalation and setup
Once you have every tool mentioned, you need to set up the environment variables so that the project can run
in an emulator (or physical device).
The variables that need to be set are: 
* ANDROID_HOME
* ANDROID_SDK_ROOT
* ADB_HOME
* JAVA_HOME
Here is an example on how to set those variables (Keep in mind that the routes should be set according to your system)
In your home folder execute: 
```
$ touch .bashrc
```
Then, open it using vim or any other terminal text editor:
```
$ vim .bashrc
```
Copy the following block of code inside the .bashrc file
```
export ANDROID_HOME=/Users/fabianandreslevin/Library/Android/sdk
export ANDROID_SDK_ROOT=/Users/fabianandreslevin/Library/Android/sdk
export ADB_HOME=/Users/fabianandreslevin/Library/Android/sdk/platform-tools
export PATH=$PATH:ADB_HOME:$ANDROID_HOME:$ANDROID_HOME/tools
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:$PATH
```
NOTE: In Windows, you should also add the path of adb.exe to the PATH variable, in my particular case is: `C:\Users\Fabian Andres Levin\AppData\Local\Android\Sdk\platform-tools`

Once the file has been edited to meet your system configuration, execute the following command:
```
$ source .bashrc
```
Now, the project should be ready to be executed

## Executing the tests
First of all, to execute the tests, the Appium server should be up and running. You can do that by executing the following command:
```
$ appium
```
If the Appium installation went well, you should see something like this:
```
[Appium] Welcome to Appium v1.17.0
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```
Now that the Appium server is running, you should have the emulator running, or the physical device connected.
