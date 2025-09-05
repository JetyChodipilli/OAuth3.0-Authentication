# 🔐 OAuth2 Spring Security Demo

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green.svg)
![OAuth2](https://img.shields.io/badge/Auth-OAuth2-informational.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📖 Project Overview

This is a Spring Boot web application demonstrating **OAuth2-based authentication** using Spring Security. Users can log in via an OAuth2 provider (e.g., Google), view a profile page with user details, and access a public welcome page. The app uses **Thymeleaf** for server-side rendering and includes a REST endpoint for retrieving user information.

---

## ✨ Features

- 🔐 OAuth2 Login via Google or other providers  
- 👤 Profile Page with name, email, and profile picture  
- 🧭 Custom Login Page for initiating authentication  
- 🏠 Welcome Page accessible to all users  
- 🔍 REST Endpoint `/user` returns authenticated user's details  
- 🔒 Security Configuration restricts access to protected endpoints

---

## 📁 Project Structure

```text
src/
├── main/
│   ├── java/com/ccp/
│   │   ├── config/
│   │   │   └── SpringConfig.java         # OAuth2 security configuration
│   │   ├── controller/
│   │   │   └── ProfileController.java    # Handles /profile and /login
│   │   └── oauth/
│   │       └── OauthController.java      # Handles / and /user
│   └── webapp/WEB-INF/
│       ├── resources/
│       │   ├── templates/
│       │   │   ├── welcome.jsp          # Home page
│       │   │   ├── login_page.jsp     # Custom login page
│       │   │   └── profile.jsp          # Profile page
│       │   ├── application.properties    # OAuth2 credentials
│       │   └── static/                   # CSS, JS, images
│       └── web.xml                       # Deployment descriptor (if needed)
└── pom.xml                               # Maven configuration
```

---

## 🛠️ Prerequisites

- Java 17+  
- Maven 3.6+  
- Spring Boot 3.x  
- OAuth2 Provider (e.g., Google)  
- Thymeleaf / JSP 
- Servlet container (e.g., Apache Tomcat) for WAR deployment

---

## ⚙️ Setup Instructions

### 📥 Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>
```

### 🔑 Configure OAuth2 Provider

Obtain credentials from your provider (e.g., Google Cloud Console) and add to:

`src/main/webapp/WEB-INF/resources/application.properties`

```properties
spring.security.oauth2.client.registration.google.client-id=<your-client-id>
spring.security.oauth2.client.registration.google.client-secret=<your-client-secret>
spring.security.oauth2.client.registration.google.scope=openid,profile,email
```

### 🏗️ Build the Project

```bash
mvn clean package
```

Generates a WAR file in the `target/` directory.

### ▶️ Deploy the Application

- Deploy WAR to Apache Tomcat  
- Or run with embedded Tomcat:

```bash
mvn spring-boot:run
```

---

## 🌐 Access the Application

Visit:  
`http://localhost:8080/<context-path>/`  
Click the login link to authenticate via OAuth2 provider.  
After login, you’ll be redirected to `/profile`.

---

## 📡 Endpoints

| Endpoint     | Description                                      |
|--------------|--------------------------------------------------|
| `GET /`      | Public welcome page (`welcome.html`)             |
| `GET /login` | Custom login page (`login_page.html`)            |
| `GET /profile` | Protected profile page (requires authentication) |
| `GET /user`  | REST endpoint returning authenticated user info  |

---

## 🧾 Templates

- `welcome.html` — Home page  
- `login_page.html` — OAuth2 login initiation  
- `profile.html` — Displays user name, email, and profile picture

---

## 🔒 Security Configuration

- Public access: `/`, `/login`  
- All other endpoints require authentication  
- OAuth2 login redirects to `/profile`  
- Custom `AuthenticationSuccessHandler` can be extended for logging/session logic

---

## 📦 Dependencies

Managed via Maven:

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-oauth2-client</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <scope>provided</scope> <!-- Optional for WAR deployment -->
  </dependency>
</dependencies>
```

---

## 📝 Notes

- Set redirect URI in OAuth2 provider to:  
  `http://localhost:8080/<context-path>/login/oauth2/code/google`
- `/user` endpoint returns raw `Principal` object (for debugging)
- If deploying as WAR, ensure `<packaging>war</packaging>` in `pom.xml` and include `web.xml` if required

---

## 🚀 Future Improvements

- Add error handling for failed logins or invalid tokens  
- Implement logout functionality  
- Enhance profile page with more user attributes  
- Add unit and integration tests for controllers and security config

---

## 🤝 Contributing

Contributions are welcome! Submit pull requests or open issues for bugs, improvements, or new features.

---

## 📜 License

This project is licensed under the **MIT License**.
