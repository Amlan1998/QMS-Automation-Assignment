🧪 QMS Automation – New Event Module
📌 Project Overview

This project contains the manual and automation testing implementation for the New Event functionality of a Quality Management System (QMS).

The objective of this assignment is to:

Demonstrate test design and testing thought process

Automate critical and stable user flows

Handle real-world UI automation challenges

Document known application limitations transparently

🛠 Tech Stack

Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Design Pattern: Page Object Model (POM)

Build Tool: Maven

Reporting: Extent Reports

Version Control: Git & GitHub

🧩 Application Areas Covered

New Event Page (Primary focus)

Deviations Page (Post-submission verification)

📋 Manual Testing

A detailed manual test case document has been created covering:

Functional Testing

Usability Testing

UI Testing

Negative & Validation Scenarios

Security & Session Scenarios

📄 The document includes:

Preconditions

Step-by-step test steps

Expected results

Manual test execution was not performed as part of this assignment.
The focus was on test design quality and coverage.

🤖 Automation Scope

Automation focuses on the critical happy path for the New Event flow:

User login

Navigation to New Event page

Entering mandatory event details

Adding affected items

Entering descriptions

Saving the event successfully

Only stable and repeatable scenarios were automated.

⚠️ Known UI Limitation (Important)

The New Event page contains a fixed bottom action bar (footer) that remains visible at all times.

Impact on Automation

The footer overlaps form elements and rich text editors

Selenium encounters errors such as:

ElementClickInterceptedException

StaleElementReferenceException

Even the expand/maximize icons for text areas can be intercepted

Resolution Implemented

Native Selenium clicks were avoided for rich text editors

JavaScript-based interaction was used to set editor content

Footer-aware scrolling and safe interaction utilities were implemented

This limitation is explicitly documented in the Extent report

This approach ensures deterministic and stable automation without masking application design issues.

🧱 Framework Structure
src
 ├── main
 │   └── java
 │       ├── base        (BaseTest, BasePage)
 │       ├── pages       (Page Object classes)
 │       ├── utils       (ConfigReader, Extent utilities)
 │       └── listeners   (TestNG listeners)
 └── test
     └── java
         └── tests       (Test classes)

▶️ How to Run the Tests
Prerequisites

Java installed

Maven installed

Chrome browser

Internet access

Steps

Clone the repository:

git clone https://github.com/<your-username>/<repo-name>.git


Navigate to the project folder:

cd <repo-name>


Run tests using Maven:

mvn test

📊 Test Reports

After execution, the Extent report is generated at:

test-output/ExtentReport.html


Screenshots are captured automatically on test failure and attached to the report.

📂 Configuration

Test data such as credentials and input values are managed using:

config.properties


(This file can be updated as needed without changing test code.)

✅ Key Highlights

Clean Page Object Model implementation

Real-world UI automation challenges handled gracefully

Transparent documentation of known limitations

Reusable and maintainable framework design

Clear separation between test logic and utilities

👤 Author

Tester: Amlan Singha
Role: QA / Automation Engineer

📝 Notes

This project was developed as part of a technical assignment to demonstrate:

Testing mindset

Automation design decisions

Practical problem-solving skills
