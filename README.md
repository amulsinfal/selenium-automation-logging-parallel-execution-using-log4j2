# 🧾 Selenium Automation - Implementing Parallel Logging using log4j2 in Automation Framework

As I continued to enhance my Selenium automation skills, I implemented a reliable **logging mechanism that supports parallel test execution** using **Log4j2** in this hands-on exercise.

---

### 🛠️ Tools and Technologies Used

| Category              | Tools / Technologies                             |
|-----------------------|--------------------------------------------------|
| **Programming Language** | Java                                          |
| **Build Tool**        | Maven                                            |
| **Testing Framework** | TestNG                                           |
| **Automation Tool**   | Selenium WebDriver                               |
| **Logging Framework** | Log4j2                                           |
| **Design Pattern**    | Page Object Model (POM)                          |
| **Dependency Manager**| Maven (`pom.xml`)                                |
| **IDE**               | Eclipse                                          |
| **Version Control**   | Git & GitHub                                     |
| **Configuration Files** | `QA-config.properties`, `log4j2.xml`           |

---

### ✅ Sequential Logging Setup
Initially, I implemented **Log4j2** for sequential test runs, which helped in:  
- Tracking WebDriver actions  
- Capturing stack traces during failures  
- Maintaining clear test flow visibility  
  
---

### ⚙️ Scaling Logging for Parallel Execution

To support **parallel execution**, I made the following changes:
- 🔑 **ThreadContext**: Assigned a unique key (test method name) for each thread using `Log4j2’s ThreadContext`.  
- 🔀 **RoutingAppender**: Configured a `RoutingAppender` in `log4j2.xml` to route logs to per-test files dynamically.
- 🧪 **TestNG Configuration**: Updated `testng.xml` with `parallel="methods"` and a `thread-count="2"`.
- 🧵 **Thread-Safe WebDriver**: Implemented `ThreadLocal<WebDriver>` in `DriverFactory` to isolate browser sessions.  

---

### 📁 Project Structure

<img width="419" alt="" src="https://github.com/user-attachments/assets/da54903e-0836-4233-ae07-13f1731cca90" />

---

### 🧩 log4j2.xml (inside `src/main/resources/`)
  <img width="1452" alt="" src="https://github.com/user-attachments/assets/4c55a7a2-d8dd-405d-8d58-83af9c0716cb" />

🧵 DriverFactory.java (Thread-safe WebDriver)  
  <img width="1452" alt="eclipse_ufgpfjLaPt" src="https://github.com/user-attachments/assets/386aeb65-2a02-4afd-8d84-e7ebc13f433a" />

📜 BaseTest.java  
  <img width="1452" alt="" src="https://github.com/user-attachments/assets/46482450-a0fa-4bd3-9bb9-080b142deb80" />

🧪 testng.xml (Run tests in parallel)  
  <img width="1474" height="263" alt="eclipse_S9ERV9Y0pc" src="https://github.com/user-attachments/assets/aebfe623-4bbb-4333-a472-42cb9e6189b0" />

🧪 Log files created LoginTest.java  
  <img width="1452" alt="" src="https://github.com/user-attachments/assets/b6d83b8d-aa01-4470-8ec4-eb7a3b7fb9f8" />

---

### Steps To Run:
1. Create and Clone the project to selenium-automation-logging-parallel-execution-using-log4j2 folder
```
git clone https://github.com/amulsinfal/selenium-automation-logging-parallel-execution-using-log4j2.git
```

2. Go to the folder selenium-automation-logging-parallel-execution-using-log4j2 containing the testng.xml file.
```
cd selenium-automation-logging-parallel-execution-using-log4j2
```

3. Open command prompt from this location and Run maven command in command prompt.
 ```
mvn test
```

<img width="1256" alt="" src="https://github.com/user-attachments/assets/1cd13901-373d-4a7e-8860-3932b4e9f0ac" />


---

### ✅ Result:  
📄 Each test generated a separate log file.  
🧹 Logs were isolated and clean, even during parallel execution  
🐞 Debugging became easy and traceable  

---

### 💡 Learning:
This exercise helped me:  
1. Understand thread-safe programming with ThreadLocal  
2. Implement Log4j2’s RoutingAppender for dynamic log generation  
3. Configure TestNG for efficient parallel execution  

