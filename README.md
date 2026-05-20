# 🦁 마모키 백엔드 스터디

> Java와 Spring Boot를 배우고 과제를 제출하는 공간입니다.

---

## 📁 브랜치 & 폴더 구조

모든 스터디원은 아래 구조를 따라 과제를 제출합니다.

```
{username}/                          ← 본인 브랜치 (예: likelion2014)
├── java-basic/
│   ├── src.Main.java
│   └── README.md
├── spring-mvc/
│   ├── src/
│   ├── build.gradle
│   └── README.md
└── ...
```

---

## 🚀 시작하기

### 1단계 — 본인 브랜치 생성

`main` 브랜치에서 **본인의 GitHub 사용자명**으로 브랜치를 만듭니다.

```bash
git checkout main
git pull origin main
git checkout -b {username}         # 예: git checkout -b likelion2014
git push origin {username}         # 예: git push origin likelion2014
```

---

### 2단계 — 과제 브랜치 생성

과제가 주어지면 **본인 브랜치에서 분기**하여 과제 브랜치를 만듭니다.

```bash
git checkout {username}                # 본인 브랜치로 이동
git checkout -b {username}/{과제명}    # 예: likelion2014/java-basic
```

---

### 3단계 — Pull Request 생성

작업이 끝나면 GitHub에서 **`{username}/{과제명}` → `{username}`** 으로 PR을 생성합니다.

> ⚠️ `main` 브랜치로 직접 PR을 보내지 않습니다.

---

## 🔀 PR 컨벤션

### 제목

```
[과제명] 본인이름 제출합니다.
```

예시: `[객체 배열 관리 프로그램] 김멋사 제출합니다.`

### 본문 템플릿

```markdown
## 과제명
<!-- 제출하는 과제 이름을 적어주세요 -->

## 💡 작업 내용
<!-- 구현한 기능이나 작업 내용을 간단히 작성해 주세요 -->
-

## 🔗 참고 링크
<!-- 참고한 자료를 적어주세요 -->
-

## 🤔 느낀 점 / 어려웠던 점
<!-- 자유롭게 작성해 주세요 -->
```

---

## 📚 과제 목록

### ☕ PART 1 — Java 기초 (1~6주차)

| 주차 | 폴더명 | 설명 |
|---|---|---|
| 2주차 | [`객체 배열 관리 프로그램`](https://www.notion.so/2-31b0e70c7956811db3cdfcf07d8e584c?source=copy_link) | 변수, 자료형, 조건문, 반복문, 함수 실습 |
| 3주차 | [`학과 생성자 프로그램`](https://www.notion.so/3-31b0e70c795681bf8d84d3bebf1046b2?source=copy_link) | 기본형/참조형, 객체 지향 프로그래밍, 생성자 |
| 4주차 | [`Account 클래스 구현`](https://www.notion.so/4-Account-31b0e70c795681989d7bd11d09fa898e?source=copy_link) | 접근 제어자, static, final |
| 5주차 | [`게임 캐릭터 상속 구조`](https://www.notion.so/5-31b0e70c79568196b26acdf878037b89?source=copy_link) | 상속, 다형성 |
| 6주차 | [`RemoteControl 인터페이스`](https://www.notion.so/6-RemoteControl-31b0e70c7956815d8500fb8ec21882e2?source=copy_link) | 인터페이스, 추상화 |

### 🌐 PART 2 — Spring MVC (7~9주차)

| 주차 | 폴더명 | 설명 |
|---|---|---|
| 9주차 | [`REST API 서버 구현`](https://www.notion.so/9-REST-API-31b0e70c795681a998b1eece8e124e39?source=copy_link) | Spring MVC 구조 이해 및 실전 실습 |

### 🗄️ PART 3 — DB & 보안 (10~12주차)

| 주차 | 폴더명 | 설명 |
|---|---|---|
| 10주차 | [`게시판 + DB 연동`](https://www.notion.so/10-DB-31b0e70c795681b88605cf33de6ba82d?source=copy_link) | Spring MVC 기본 기능 및 JPA/DB 연동 |
| 12주차 | [`JWT 인증 서버`](https://www.notion.so/12-JWT-31b0e70c795681f7ba9eeba89d6afa61?source=copy_link) | Spring Security & JWT 인증·인가 구현 |

---

## ✅ 과제 폴더 README 작성 가이드

각 과제 폴더 안의 `README.md`에는 아래 내용을 포함해 주세요.

```markdown
# 과제명
<!-- 제출하는 과제 이름을 적어주세요 -->

## ⚙️ 실행 방법
<!-- Java 파일 또는 Spring 프로젝트 실행 방법을 작성해 주세요 -->

## 💡 작업 내용
- 구현한 기능 목록

## 📡 API 명세 (Spring 과제의 경우)
| Method | URI | 설명 |
|---|---|---|
| GET | /api/... | ... |

## 🤔 느낀 점 / 어려웠던 점
- 자유롭게 작성
```

---

## 🛠️ 개발 환경

| 항목 | 권장 사항 |
|---|---|
| JDK | 17 이상 |
| Build Tool | Gradle |
| Framework | Spring Boot 3.x |
| Database | MySQL |
| IDE | IntelliJ IDEA |

---

## ⚠️ 주의사항

- 반드시 **본인 브랜치**에서 과제 브랜치를 분기하세요.
- `.gitignore`에 `build/`, `.idea/`, `*.class` 등이 포함되어 있는지 확인하세요.
- `application.properties`에 비밀번호, API 키 등 민감한 정보를 커밋하지 마세요.
- 다른 사람의 브랜치에 직접 push하지 마세요.
