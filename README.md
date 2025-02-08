# Mobile Automation Assessment (WEBDRIIVERIO) Setup Guide By (Abdul Ahad)

This guide provides step-by-step instructions for setting up the environment for mobile automation testing using Appium, TestNG, Selenium, and Maven.

## Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK) (Recommended: JDK 17 or higher)
- Android SDK & ADB (Android Debug Bridge)
- Node.js and npm (Required for Appium installation)
- Maven (For dependency management)
- Git (To clone repositories)

## Steps to Set Up the Environment

### 1. Install Appium GUI Server and Set Its Configuration

1. Download and install Appium Desktop from [Appium Official Website](https://appium.io/).
2. Open Appium and configure the server settings:
   - Set Host: `localhost`
   - Set Port: `4723`
   - Enable Relaxed Security (if required)
   - Click "Start Server"

### 2. Install Appium Inspector and Set Its Configuration

1. Download and install Appium Inspector from [Appium Inspector GitHub](https://github.com/appium/appium-inspector).
2. Open Appium Inspector and configure the connection:
   - Set Remote Path: `/wd/hub`
   - Enter Host and Port matching the Appium server settings.

### 3. Install and Configure Device Manager

#### Using Android Emulator (Simulator):
1. Open Android Studio and navigate to **AVD Manager**.
2. Create a new Android Virtual Device (AVD).
3. Start the emulator.

#### Using Physical Android Device:
1. Enable **Developer Options** and **USB Debugging** on the Android device.
2. Connect the device via USB.
3. Run the following commands to verify the device is connected:

   adb start-server  
   adb devices

### 4. Clone the Project from Git

1. Open a terminal or command prompt.
2. Navigate to the desired folder.
3. Clone the project using:

   git clone <repository_url>

### 5. Load Project and Maven Changes in `pom.xml` (If Missing)

1. Open the project in an IDE (Eclipse/IntelliJ).
2. Right-click on `pom.xml` and select **Maven > Reload Project**.
3. Ensure all dependencies (Appium, TestNG, Selenium) are properly loaded.
4. For IntelliJ, click on **Load Maven Changes**.

### 6. Run the Project Using `testng.xml`

1. Locate the `testng.xml` file in the project directory and execute through the **Run** button in IntelliJ.
2. For Windows Machines, open **Command Prompt**:

   - Go to the project folder:  
     Example:  
     `C:\>cd TestAutomation\AppiumTest`  
     `C:\TestAutomation\AppiumTest>mvn clean test -DFilename=testng.xml`

3. Execute the following commands in the terminal:

   mvn clean test  
   mvn clean install

### Notes:
- Ensure Appium Server is running before executing tests.
- Verify the device/emulator is properly connected before test execution.
- If dependencies are missing, update the `pom.xml` file and reload Maven.
