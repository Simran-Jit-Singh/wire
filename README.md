# Test Automation Framework

## Overview
This project is a test automation framework designed for iOS application testing. It supports iOS automation using Cucumber, Appium and XCUITest, ensuring robust and reliable test execution.

## Prerequisites
- **Java**: Version 15 or higher
- **Gradle**: Version 5 or higher
- **Node**: Installed and configured
- **Appium**: Installed and configured
- **xcode**: Installed and configured
- **XCUITest**: Installed and configured


## Features
- Supports iOS test automation on simulator running using xcuitest.
- The tests are written in cucumber BDD framework using Gherkin language: https://cucumber.io/
- Each scenario is tagged with cucumber annotation and runs independently.
- Gradle-based build and test execution.
- Scalable and maintainable test architecture.

## Project Structure
```
root/
│-- src/
│   ├── main/       # Lauch the app in simulator
│   ├── test/       # cucumber scenario and execution stesp
│-- configs/        # device specific configs
│-- reports/        # cucumber reports
│-- build.gradle    # Gradle build file
│-- README.md       # Project documentation
```

## Usage
1. Clone the repository
2. Start Appium server on port 4723:  `appium -p 4723`
3. Start Xcode simulator and add the booted device config in `config.json`. _Note_, Appium will also launch the simulator if not manually triggered.
4. Navigate to the project root and execute the command  `gradle cucumber -DdeviceName="iPhone_14" -Ptag="@login"`. Replace _DeviceName_ with 
simulator running on your machine. This should execute the tag `@login` in _login.feature_ file. 
5. Review test reports after execution.

## Reporting
Test results and execution reports can be found in the `reports/` directory after test execution.

## Contribution
Contributions are welcome! Please follow the project's coding standards and submit pull requests for review.


