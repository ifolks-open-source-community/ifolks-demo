<p align="center">
  <img src="assets/ifolks-demo-logo.jpg" alt="iFolks Demo Logo" width="220" />
</p>

<h1 align="center">iFolks Demo</h1>

<p align="center">
  <a href="https://ifolks.org"><img src="https://img.shields.io/badge/Community-ifolks.org-blue.svg" alt="Community" /></a>
  <img src="https://img.shields.io/badge/Java-21-orange.svg" alt="Java 21" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen.svg" alt="Spring Boot 4.1.1" />
  <img src="https://img.shields.io/badge/Angular-22-red.svg" alt="Angular 22" />
  <img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg" alt="License" />
</p>

<p align="center">
  <strong>The Reference Implementation &amp; Showcase Application for the iFolks Open Source Ecosystem</strong>
</p>

---

## 🌟 Overview

**iFolks Demo** is a complete, decoupled enterprise application demonstrating the end-to-end capabilities of the iFolks platform:
* 🛠 **[iFolks Generator](https://generator.ifolks.org)**: Generated directly from metadata declarations (`data-model/skeleton.xml`) with zero boilerplate.
* 🧰 **[iFolks Commons](https://commons.ifolks.org)**: Integrated with structured JSON observability (`ACCESS_LOG`, `ERROR_LOG`), distributed tracing (MDC), context-aware data privacy (`@SensitiveData`), and AspectJ interception.

---

## 🏗 Modular Architecture

The project is organized into clean, decoupled layers:

| Module | Purpose |
| :--- | :--- |
| **`demo-api`** | Public DTOs, interfaces, and service contracts |
| **`demo-model`** | JPA domain entities |
| **`demo-persistence`** | Repositories and database access layer |
| **`demo-services`** | Business service implementations |
| **`demo-rest`** | Spring Boot REST controllers |
| **`demo-populator`** | Automated multi-step database provisioning and seed data |
| **`demo-tests`** | Comprehensive integration and regression test suites |
| **`demo-ui`** | Angular frontend application |

---

## ⚡ Quickstart

### Prerequisites
* **Java 21** or later
* **Maven 3.9+**
* **PostgreSQL** instance running on `localhost:5432`:
  * Database: `demo`
  * Username / Password: `postgres` / `postgres`

> **Tip (Docker)**: You can start the database in one command:
> ```bash
> docker run --name postgres-demo -e POSTGRES_DB=demo -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:16
> ```

---

### Step 1: Build the Project
```bash
mvn clean install
```

### Step 2: Populate the Database
Run the automated populator to create the schema and seed initial sample data:
```bash
cd demo-populator
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

### Step 3: Launch the REST Backend
Start the Spring Boot REST API with the `local` profile:
```bash
cd demo-rest
mvn spring-boot:run -Dspring-boot.run.profiles=local
```
The REST API is now available at: **`http://localhost:8080/demo-rest`**

### Step 4 (Optional): Launch the Angular Frontend
```bash
cd demo-ui
npm install
npm start
```
The Angular UI runs at: **`http://localhost:4200`**

---

## 📖 Official Documentation

For architectural guides, model specifications, and community resources:
* 🌐 **Community Portal**: [ifolks.org](https://ifolks.org)
* 🛠 **Generator Documentation**: [generator.ifolks.org](https://generator.ifolks.org)
* 🧰 **Commons Documentation**: [commons.ifolks.org](https://commons.ifolks.org)

---

## 📝 License

Distributed under the **Apache Software License, Version 2.0**.
