# 과제명
JWT 인증 서버

## ⚙️ 실행 방법
1. MySQL에서 데이터베이스 생성
```sql
CREATE DATABASE security;
```

2. '.env'에 데이터베이스 정보 설정
```env
DB_URL=jdbc:mysql://localhost:3306/security?serverTimezone=Asia/Seoul&Encoding=UTF-8&&useSSL=false&allowPublicKeyRetrieval=true
DB_USERNAME=(MySQL_사용자명)
DB_USERNAME(MySQL_패스워드)

JWT_SECRET=(Base 64로 인코딩된 JWT 비밀키)
JWT_EXPIRATION_MS=3600000
```

3. Spring Boot 실행

## 💡 작업 내용
- POST /auth/register - 회원가입 구현
- POST /auth/login → JWT 토큰 수령 구현
- GET /posts (protected) → Authorization: Bearer {token} 구현

## 📡 API 명세 (Spring 과제의 경우)
| Method | URI            | 설명     |
|--------|----------------|--------|
| POST   | /auth/register | 회원가입   |
| POST   | /auth/login    | 로그인    |
| GET    | /posts         | 게시글 조회 |

## 🤔 느낀 점 / 어려웠던 점
- JWT의 생성, 검증, 필터 처리 과정이 여러 단계로 되어 있어 전체적인 흐름을 이해하는 데 어려웠다.
- 부족한 예외처리나 글로벌 예외처리는 시간이 좀 나면 작성해야겠다.