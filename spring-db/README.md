# 과제명
게시판 + DB 연동

## ⚙️ 실행 방법
1. MySQL에서 데이터베이스 생성
```
CREATE DATABASE post_server
```
2. .env에 DB 정보 입력
3. IntelliJ에서 RestApiServerApplication.java 실행

## 💡 작업 내용
- 게시글 CRUD 구현
- MySQL 연동
- JPA 사용

## 📡 API 명세 (Spring 과제의 경우)
| Method | URI         | 설명        |
|--------|-------------|-----------|
| POST   | /posts      | 게시글 생성    |
| GET    | /posts      | 전체 게시글 조회 |
| GET    | /posts/{id} | 단건 게시글 조회 |
| PUT    | /posts/{id} | 게시글 수정    |
| DELETE | /posts/{id} | 게시글 삭제    |

## 🤔 느낀 점 / 어려웠던 점
- 저번에 비해서 예외 처리 방식에 대해서 살펴본 것 같고 각 어노테이션의 역할에 대해서도 좀 더 알아본 것 같다.