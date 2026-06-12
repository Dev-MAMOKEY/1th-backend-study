# 과제명

JWT 인증 서버

## ⚙️ 실행 방법

1. MySQL 실행 후 데이터베이스 생성

```sql
CREATE DATABASE board_spring_db;
```

2. `application.properties`에 데이터베이스 정보 설정

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/board_spring_db
spring.datasource.username=사용자명
spring.datasource.password=비밀번호
```

3. Spring Boot 프로젝트 실행

4. Postman을 이용하여 API 테스트

---

## 💡 작업 내용


### JWT 인증 기능 구현

* 회원가입 기능 구현
* 로그인 기능 구현
* 로그인 성공 시 JWT 토큰 발급
* Authorization Header를 통한 JWT 인증
* Spring Security 적용
* JwtAuthFilter를 이용한 사용자 인증 처리

### 예외 처리


* 회원가입 시 사용자 중복 예외 처리
* 로그인 시 사용자 미존재 예외 처리
* 로그인 시 비밀번호 불일치 예외 처리


---

## 📡 API 명세

### 인증 API

| Method | URI            | 설명           |
| ------ | -------------- | ------------ |
| POST   | /auth/register | 회원가입         |
| POST   | /auth/login    | 로그인 및 JWT 발급 |

### 게시글 API

| Method | URI         | 설명        |
| ------ | ----------- | --------- |
| POST   | /posts      | 게시글 생성    |
| GET    | /posts      | 게시글 목록 조회 |
| GET    | /posts/{id} | 게시글 단건 조회 |
| PUT    | /posts/{id} | 게시글 수정    |
| DELETE | /posts/{id} | 게시글 삭제    |

---

## 🔐 JWT 인증 방식

1. 사용자가 회원가입을 진행한다.
2. 로그인 성공 시 JWT 토큰을 발급받는다.
3. 이후 요청 시 Authorization Header에 JWT 토큰을 포함한다.

예시

```http
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

4. JwtAuthFilter가 토큰을 검증한다.
5. 인증된 사용자만 게시글 API에 접근할 수 있다.

---



## 🤔 느낀 점 / 어려웠던 점

* 기존 CRUD 게시판에 JWT 인증 기능을 추가하면서 Spring Security의 동작 원리를 이해할 수 있었습니다.
* JwtAuthFilter와 SecurityConfig를 직접 구현하며 인증과 인가 과정이 어떻게 이루어지는지 경험할 수 있었습니다.
