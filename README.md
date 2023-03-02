# 메뉴 서비스



---
<p></p>
<h2>개발 환경</h2>
<aside>
spring boot, java11, postgreSQL, JPA, Junit5


<aside>



---
<p></p>
<h2>사전 작업</h2>




<aside>
<h3>postgreSQL 설치 (for mac)</h3>

(1) postgresql brew 설치<p></p>
　　$ brew install postgresql

(2) postgresql 서비스 시작<p></p>
　　$ brew services start postgresql

(3) 정상 실행 확인<p></p>
　　$ postgres -V

(4) ddl 생성<p></p>
 　 - 프로젝트의 schema 폴더의 ddl.sql의 내용을 postgresql ddl 쿼리 실행

</aside>

---
<p></p>
<h2>빌드 및 실행 방법</h2>




<aside>
(1) 프로젝트 폴더의 gradlew 권한 변경<p></p>
　　$ chmod +x gradlew<p></p>

(2) gradle clean<p></p>
　　$ ./gradlew clean

(3) gradle build<p></p>
　　$ ./gradlew build

(4) 프로젝트 실행<p></p>
　　$ cd {프로젝트 경로}/build/libs<p></p>
　　$ java -jar menu-service-0.0.1-SNAPSHOT.jar

(5) 프로젝트 실행 확인

</aside>

---
<p></p>
<h2>API 명세</h2>




- **`GET /menus`**: 모든 메뉴를 조회합니다. (하위 메뉴까지 조회 가능)<p></p>
- **`GET /menus/{id}`**: 특정 메뉴를 조회합니다. (하위 메뉴까지 조회 가능)<p></p>
- **`POST /menus`**: 새로운 메뉴를 등록합니다. (최상위 메뉴에만 배너 등록 가능)<p></p>
- **`PUT /menus/{id}`**: 특정 메뉴를 수정합니다.<p></p>
- **`DELETE /menus/{id}`**: 특정 메뉴를 삭제합니다.<p></p>

---
<p></p>
<h2>API 테스트</h2>




<aside>
💡 Swagger Test<p></p>
　　http://localhost:8080/swagger-ui/index.html
<p></p>
**요구사항안)**<p></p>
　　(1) 전체메뉴 조회시 하위메뉴 조회 가능합니다.<p></p>
　　(2) 특정 메뉴 조회시 특정 메뉴의 하위메뉴도 조회 가능합니다.<p></p>
　　(3) 새로운 메뉴 등록시 (링크, 타이틀 등록 가능합니다.)<p></p>
  　　　　- 최초 등록일 경우 배너 등록 가능합니다.<p></p>
  　　　　- 하위 메뉴로 등록시 배너 등록할 경우 exception 발생합니다.

</aside>

---
<p></p>
<h2>물리 ERD</h2>



<img width="173" alt="물리ERD" src="https://user-images.githubusercontent.com/22589581/222450088-3fb48bcb-1a7c-4be7-a728-27d22b857799.png">

---
<p></p>
<h2>논리 ERD</h2>



<img width="269" alt="논리ERD" src="https://user-images.githubusercontent.com/22589581/222450079-e68822b3-336c-4ba4-a96a-ca67fcf39c9c.png">
