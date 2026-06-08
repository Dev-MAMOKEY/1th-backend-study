# 과제명
게시판 + DB 연동
## ⚙️ 실행 방법
1. MySQL 실행 후 데이터베이스 생성
```sql
CREATE DATABASE board_spring_db;
```
2. `.env`에 DB 정보 설정

3. Intelij Spring Boot 프로젝트 실행

---

## 💡 작업 내용

### 게시글 CRUD 기능 구현

* 게시글 생성
* 게시글 전체 조회
* 게시글 단건 조회
* 게시글 수정
* 게시글 삭제

### DB 연동

* Spring Data JPA 사용
* MySQL 연동
* JpaRepository 활용

---

## 📡 API 명세

| Method | URI         | 설명             |
| ------ | ----------- | -------------- |
| POST   | /posts      | 게시글 생성         |
| GET    | /posts      | 게시글 목록 조회 |
| GET    | /posts/{id} | 게시글 단건 조회      |
| PUT    | /posts/{id} | 게시글 수정         |
| DELETE | /posts/{id} | 게시글 삭제         |

---

## 🤔 느낀 점 / 어려웠던 점
- 처음 CRUD를 구현했을때보다 어노테이션들에 대해 더욱 익숙해진 것 같습니다.
- DTO를 사용하는 이유와 Entity를 직접 반환하지 않는 이유를 더욱 잘 이해하게 되었습니다.