# Data-Driven Testing (DDT)

Data-Driven Testing (DDT) is a software testing technique where test data is separated from test scripts. The same test runs multiple times with different sets of input data, such as different usernames and passwords for login functionality.

## Why Use Data-Driven Testing?
- Reduces duplication in test scripts
- Tests the same feature with multiple input combinations (valid/invalid)
- Makes it easier to automate repetitive tests

# 🧪 Data-Driven Automation Framework (SDET Version)

A **Java + Selenium + TestNG** based Data-Driven Framework using **Maven** for dependency management and **Apache POI** for Excel data handling.

---

## 📂 Folder Structure

<img width="442" height="666" alt="image" src="https://github.com/user-attachments/assets/bc80e47c-c452-4d2d-bc12-0656a7130a7c" />

---

## 🚀 Steps to Build the Framework

### 1️⃣ Environment Setup
- Install **Java JDK** and configure environment variables:
  - `JAVA_HOME`
  - `PATH`
- Install **Eclipse IDE** (Enterprise & Web Development edition).

---

### 2️⃣ Project Setup
- Create a **Maven Project** → Archetype: `maven-archetype-quickstart`.
  - **Why?** Automatically generates a `pom.xml` file with Maven structure.
- Delete default `src/main/java` and `src/test/java` folders.
- Create a **custom folder structure** as shown above.

---

### 3️⃣ Test Class Creation
- Create `Login.java` inside `src/test/java/tests` with a `@Test` method.
- If `@Test` doesn’t work:
  - Remove **JUnit** dependency from `pom.xml`.
  - Add **TestNG** dependency.
  - Install **TestNG plugin** in Eclipse (if Run/Debug is missing).

---

### 4️⃣ Writing Test Logic
- Implement **Selenium WebDriver** code for the login page.
- Create `@AfterTest` method for browser quit/cleanup.

---

### 5️⃣ Data Provider Setup
- Implement a `@DataProvider` method returning a **2D array** for multiple login credentials.

---

### 6️⃣ Resource & Utility Setup
- Create `src/test/resources` folder.
- Create `util` package inside `src/test/java`:
  - Add `MYXLSReader.java` (download if required).
  - Add `DataUtil.java` (download if required).
- Add **Apache POI** dependencies to `pom.xml`:
---

## 7️⃣ Excel Data Integration
- Replace hardcoded `@DataProvider` with an **Excel-based data provider**.
- Use methods from `MYXLSReader.java` to read login credentials from an Excel file.
- Refactor method parameters to use a **HashMap** for dynamic key-value data mapping, improving flexibility and maintainability.

---

## 8️⃣ Base Class Implementation
- Create a `base` package and add `Base.java` to handle **WebDriver setup** (browser initialization, configuration, and teardown).
- Extend `Base.java` in `Login.java` to inherit the driver setup.
- Call the `openBrowser()` method from the `Base` class for browser initialization.
- Implement **run mode control**:
  - If `RunMode = Y` → Execute the test.
  - If `RunMode = N` → Skip the test execution.

---



Credits to: [QA Fox ](https://www.qafox.com/)
