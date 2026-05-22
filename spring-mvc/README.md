# 과제명
REST API 서버 구현

## ⚙️ 실행 방법
1. IntelliJ에서 프로젝트 열기
2. RestApiServerApplication.java 실행

## 💡 작업 내용
- 엔티티
````
Post
````

- 필드
````
id
title
content
createdAt
````

- 폴더 구조
````
controller
service
dto
repository
entity
````

- Postman 사용하여 전체 API 테스트 캡쳐화 후 제출

## 📡 API 명세 (Spring 과제의 경우)
| Method | URL | 설명 |
| ----- | -------- | -------- |
| POST |  /posts | 게시글 생성 |
| GET |  /posts | 전체 조회 |
| GET |  /posts/{id} | 단건 조회 |
| PUT |  /posts/{id} | 수정 |
| DELETE |  /posts/{id} | 삭제 |

## 🤔 느낀 점 / 어려웠던 점
- 멋쟁이사자처럼의 'Java 첫 걸음 시작하기 - Sprring Boot의 구조 및 작동 원리, Spring Boot 데이터베이스 연동 및 CRUD API 구현'을 베이스로 참고했습니다.
- 컨트롤러와 DTO를 분리하기 위해 코드에서 형식을 변환하는 과정이 어려웠습니다. 또한 애너테이션(@)의 역할과 수행하는 과정을 이해하는데 있어서 어려웠습니다.