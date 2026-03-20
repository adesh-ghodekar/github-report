# GitHub Access Report Service

## 📌 Overview

This project is a Spring Boot application that connects to GitHub and generates a report showing which users have access to which repositories.

It fetches repositories and their collaborators, then aggregates the data into a structured JSON response.

---

## 🚀 Features

* Authenticate with GitHub using Personal Access Token
* Fetch repositories for a user
* Fetch collaborators for each repository
* Generate user-to-repository access mapping
* Expose REST API endpoint

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot
* Maven
* GitHub REST API

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```
git clone <https://github.com/adesh-ghodekar/github_report.git>
cd github-report
```

---

### 2. Configure GitHub Token

Open `src/main/resources/application.properties` and add:

```
github.token=YOUR_GITHUB_TOKEN
github.org=YOUR_GITHUB_USERNAME
```

👉 Example:

```
github.token=ghp_xxxxxxxxxxxxxx
github.org=adeshghodekar23
```

---

### 3. Run the Application

```
mvn spring-boot:run
```

---

## 🌐 API Endpoint

GET http://localhost:8080/api/access-report

---

## 📊 Sample Response

```
[
  {
    "username": "adesh-ghodekar",
    "repositories": [
      "AI-Based-Skincare-Recommendation-System",
      "Case-Study-Analyzing-Job-Market-Data-in-Power-BI"
    ]
  }
]
```

---

## ⚡ Design Decisions

* Used HashMap for efficient aggregation of user-repository mapping
* Used GitHub REST API for fetching repositories and collaborators
* Designed modular structure (controller, service, client, model)
* Kept code simple and readable

---

## ⚠️ Assumptions

* The provided GitHub token has required permissions
* Only collaborators are considered for repository access
* Pagination is limited to first 100 results (can be extended)

---

## 🚀 Possible Improvements

* Add pagination handling for large organizations
* Implement caching to reduce API calls
* Add better error handling and logging
* Support both users and organizations dynamically

---

## 👨‍💻 Author

Adesh Ghodekar
