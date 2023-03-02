# 메뉴 서비스

---

# 사전 작업

---

```json
postgreSQL 설치 (for mac)

(1) postgresql brew 설치
$ brew install postgresql

(2) postgresql 서비스 시작
$ brew services start postgresql

(3) 정상 실행 확인
$ postgres -V

(4) ddl 생성
 - 프로젝트의 schema 폴더의 ddl.sql의 내용을 postgresql ddl 쿼리 실행
```

# 빌드 및 실행 방법

---

```json
(1) 프로젝트 폴더의 gradlew 권한 변경
$ chmod +x gradlew

(2) gradle clean
$ ./gradlew clean

(3) gradle build
$ ./gradlew build

(4) 프로젝트 실행
$ cd {프로젝트 경로}/build/libs
$ java -jar menu-service-0.0.1-SNAPSHOT.jar

(5) 프로젝트 실행 확인
```

# API 명세

---

- **`GET /menus`**: 모든 메뉴를 조회합니다. (하위 메뉴까지 조회 가능)
- **`GET /menus/{id}`**: 특정 메뉴를 조회합니다. (하위 메뉴까지 조회 가능)
- **`POST /menus`**: 새로운 메뉴를 등록합니다. (최상위 메뉴에만 배너 등록 가능)
- **`PUT /menus/{id}`**: 특정 메뉴를 수정합니다.
- **`DELETE /menus/{id}`**: 특정 메뉴를 삭제합니다.

# API 테스트

---

```json
Swagger Test
http://localhost:8080/swagger-ui/index.html

**요구사항안)**
(1) 전체메뉴 조회시 하위메뉴 조회 가능합니다.
(2) 특정 메뉴 조회시 특정 메뉴의 하위메뉴도 조회 가능합니다.
(3) 새로운 메뉴 등록시 (링크, 타이틀 등록 가능합니다.)
  - 최초 등록일 경우 배너 등록 가능합니다.
  - 하위 메뉴로 등록시 배너 등록할 경우 exception 발생합니다.
```

# 물리 ERD

---

![Untitled](%E1%84%86%E1%85%A6%E1%84%82%E1%85%B2%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%B5%E1%84%89%E1%85%B3%200e95fbdbc469420a977533adf9275a9f/Untitled.png)

# 논리 ERD

---

![Untitled](%E1%84%86%E1%85%A6%E1%84%82%E1%85%B2%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%B5%E1%84%89%E1%85%B3%200e95fbdbc469420a977533adf9275a9f/Untitled%201.png)
