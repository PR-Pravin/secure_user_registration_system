# User Registration Web Application

## 📌 Overview

This project is a **User Registration Web Application** built using **HTML, CSS, JavaScript, Java Servlets, JDBC, and MySQL**.
It allows users to enter their personal details through a form and stores the data securely in a MySQL database.

---

## 🚀 Features

* User-friendly registration form UI
* Input validation using HTML attributes
* Automatic age calculation based on Date of Birth
* Backend processing using Java Servlet
* Database integration using JDBC
* Secure data insertion with PreparedStatement

---

## 🛠️ Technologies Used

* **Frontend:** HTML5, CSS3, JavaScript
* **Backend:** Java Servlet (GenericServlet)
* **Database:** MySQL
* **IDE:** Eclipse
* **JDBC Driver:** MySQL Connector/J

---

## 📂 Project Structure

```
UserRegistrationProject/
│
├── index.html        # Registration form UI
├── style (internal)  # CSS styling
├── script (internal) # JavaScript for age calculation
│
├── register_back_code.java  # Servlet backend
│
└── Database:
    └── register_db
        └── regi (table)
```

---

## 🧾 Database Setup

### 1. Create Database

```sql
CREATE DATABASE register_db;
```

### 2. Create Table

```sql
USE register_db;

CREATE TABLE regi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone BIGINT,
    dob DATE,
    age INT,
    aadhar BIGINT,
    password VARCHAR(100)
);
```

---

## ⚙️ Configuration

### Update Database Credentials

In your servlet file:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/register_db",
    "your_username",
    "your_password"
);
```

---

## ▶️ How to Run

1. Import project into **Eclipse Dynamic Web Project**
2. Add **MySQL Connector JAR** to build path
3. Configure **Apache Tomcat Server**
4. Deploy project on server
5. Open browser and navigate to:

```
http://localhost:8080/YourProjectName/index.html
```

---

## 🔄 Workflow

1. User fills registration form
2. JavaScript calculates age automatically
3. Form submits data to servlet (`/reg_form`)
4. Servlet processes request
5. Data stored in MySQL database
6. Success message displayed

---

## ⚠️ Validations Implemented

* Phone number must be 10 digits
* Aadhar number must be 12 digits
* Required fields enforced
* Age auto-calculated (read-only)

---

## 🔒 Security Notes (Important)

* Password is currently stored as plain text ❗
  👉 Recommended: Use hashing (e.g., BCrypt)
* Avoid hardcoding database credentials in production
* Implement input sanitization for better security

---

## 📌 Future Enhancements

* Password encryption
* Login system
* Email verification
* Responsive UI improvements
* MVC architecture (Servlet + JSP)

---

## 👨‍💻 Author

**Pravin**
Engineering Student

---

## 📄 License

This project is for educational purposes.
