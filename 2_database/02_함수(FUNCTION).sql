SELECT EMP_ID, EMP_NAME, SALARY     -- 3번
FROM EMPLOYEE                       -- 1번
WHERE DEPT_CODE IS NULL;            -- 2번

/*
    <ORDER BY 절>
    SELECT문 가장 마지막 줄에 작성, 실행순서 또한 가장 마지막에 실행한다.
    
    [표현법]
    SELECT 조회할 컬럼....
    FROM 조회할 테이블
    WHERE 조건식
    ORDER BY 정렬기준이 될 컬럼명  | 별칭으로도 할 수 있다.  (가장 마지막 출력이라 별칭명이 가능하다) | 
              컬럼순번 [ASC | DESC] [NULL FIRST | NULL LAST]
              
    - ASC : 오름차순 (작은 값으로 시작해서 값이 점점 커지는 것) -> 기본값 (NULL이 가장 맨뒤)
    - DESC : 내림차순 (큰 값으로 시작해서 값이 점점 줄어드는 것) (NULL이 가장 맨앞)
    
    -- NULL은 기본적으로 가장 큰값으로 분류해서 정렬한다.
    - NULLS FIRST : 정렬하고자하는 컬럼값에 NULL이 있을 경우 해당데이터 맨 앞에 배치(DESC일때 기본값)
    - NULLS LAST : 정렬하고자 하는 컬럼값에 NULL이 있을 경우 해당데이터 맨 마지막에 배치 (ASC일때 기본값)
*/

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS; -- 기본값이 오름차순
--ORDER BY BONUS ASC;
--ORDER BY BONUS ASC NULLS FIRST;
--ORDER BY BONUS DESC; --NULL FIRST 기본

-- 정렬기준에 컬럼값이 동일할 경우 그 다음차순을 위해서 여러개를 제시할 수 있다.
ORDER BY BONUS DESC, SALARY ASC;

-- 전 사원의 사원명, 연봉(보너스 제외) 조회 (이 때 연봉별 내림차순 정렬)
SELECT EMP_NAME, SALARY * 12 AS "연봉"
FROM EMPLOYEE
--ORDER BY SALARY * 12 DESC; --그냥했을때
--ORDER BY 연봉 DESC; -- 별칭으로 했을때
ORDER BY 2 DESC; --순서로도 줄수있지만 순서는 바뀔수있으므로 선호하지않음 -- 오라클은 전부 1 부터 시작


--======================================================================================

/*
    <함수 FUNCTION>
    전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환한다.
    
    - 단일행 함수 : N개의 값을 읽어들여서 N개의 결과값을 리턴한다.(매행마다 함수실행결과를 반환한다.)
    - 그룹함수 : N개의 값을 읽어들여서 1개의 결과값을 리턴한다. (그룹을 지어 그룹별로 함수 실행결과 반환)
    
    >> SELECT 절에 단일행 함수랑 그룹함수를 함께 사용하지 못함!!
    왜? 결과 행의 갯수가 다르기 때문에
    
    >> 함수식을 기술할 수 있는 위치 : SELECT절 WHERE절 ORDER BY절 GROUP BY절 HAVING절
*/

--====================<단일행 함수>==================================

/*
    <문자 처리 함수>
    
    * LENGTH(컬럼 | '문자열') 해당 문자열의 글자수를 반환
    * LENGTHB (컬럼 | '문자열') : 해당 문자열의 바이트수를 반환
    
    
    '최' '나' 'ㄱ' 한글은 글자당 3 BYTE
    영문자, 숫자, 특수문자 글자당 1 BYTE
*/

SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME),
        EMAIL, LENGTH('EMAIL'), LENGTHB(EMAIL)
FROM EMPLOYEE;

--==========================================================================

/*
    *INSTR
    문자열로부터 특정 문자의 시작위치를 찾아서 반환해준다.
    
    INSTR(컬럼 | '문자열', '찾고자하는 문자', ['찾을 위치의 시작값', 순번]) => 결과는 NUMBER 로 나옴
*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- 앞쪽에 있는 첫 B는 3번쨰 위치에 있다고 나옴
--찾을 위치는 시작값은 : 1 순번 : 1 => 기본값 (위처럼 안넣어주면 자동으로 기본값처럼 된다)

SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- 뒤에서부터 찾지만 읽을 떄는 앞으로 읽어서 알려준다.
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- 순번을 제시하려면 찾을 위치의 시작값을 표시해야함
SELECT INSTR('AABAACAABBAA', 'B', 1, 3) FROM DUAL;


SELECT EMAIL, INSTR(EMAIL, '_', 1, 1) AS "LOCATION", INSTR(EMAIL, '@') AS "위치"
FROM EMPLOYEE;

--================================================================================
/*
    * SUBSTR / 자주쓰임
    문자열에서 특정 문자열을 추출해서 반환해준다.
    
    [표현법]
    SUBSTR(STRING, POSITION, [LENGTH])
    - STRING : 문자타입의 컬럼 | '문자열'
    - POSITION : 문자열 추출할 시작위치의 값
    - LENGTH : 추출할 문자 갯수 (생략하면 끝까지)
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL; -- 7번쨰 위치부터 끝까지 출력하는거다
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL; -- ME 5번째에서 2번쨰까지
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL; --SHOWME 1번째에서 6번째까지
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL; -- THE 뒤에서8번째 에서 3번째 앞으로

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "성별"
FROM EMPLOYEE;

-- 사원들중 여사원들만 조회
SELECT EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2' OR SUBSTR(EMP_NO,8,1)='4';

-- 사원들중 남사원들만 조회

SELECT EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='1' OR SUBSTR(EMP_NO,8,1)='3';


-- 함수 중첩사용 가능

--이메일 아이디부분만 추출
-- 사원목록에서 사원명, 이메일, 아이디 조회

SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') -1)
FROM EMPLOYEE;

--================================================================================

/*
    * LPAD / RPAD
    문자열을 조회할 때 동일감있게 조회하고자 할 때 사용
    
    [표현법]
    LPAD/RPAD(STRING, 최종적으로 변환할 문자의 길이, [덧붙이고자하는 문자])
    
    문자열에 덧붙이고자하는 문자를 왼쪽 또는 오른쪽에 분여서 최종 N길이만큼의 문자열을 반환
*/

--20만큼의 길이 중 EAMIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다
SELECT EMP_NAME, LPAD(EMAIL, 20)
FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

SELECT RPAD('910524-1', 14, '*')
FROM DUAL;

--사원들의 사원명 주민등록번호 조회(910524-1****** 형식으로)

--SELECT EMP_NAME, SUBSTR (EMP_NO, 1, 8)  1부터 8까지 자르고
--SELECT EMP_NAME, SUBSTR (EMP_NO, 1, 8) || '******'  응용을 한다면 이렇고
SELECT EMP_NAME, RPAD(SUBSTR (EMP_NO, 1, 8) , 14, '*') --배운대로 한다면 이렇게
FROM EMPLOYEE;

--==========================================================================

/*
    * LTRIM / RERIM
    문자열에서 특정 문자를 제거한 나머지를 반환
     LTRIM / RERIM (STRING, [제거하고자하는 문자들])
     
     문자열의 왼쪽 혹은 오른쪽에서 제거하고자하는 문자들을 찾아서 제거한 나머지문자열을 반환
*/

SELECT LTRIM ('    K  H') FROM DUAL; -- 앞에서부터 다른문자가 나올때 까지만 공백제거용
SELECT LTRIM('123123KH123', '123') FROM DUAL;
SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL; -- 제거하고자하는 문자는 문자열이 아닌 문자들 이다!!
SELECT RTRIM ('574185KH123', '0123456789') FROM DUAL;

/*
    * TRIM
    문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
    TRIM([LEADING  |  TRAILNG  |  BOTH] 제거하고자하는 문자열 FROM 문자열)
*/

SELECT TRIM('        K    H     ') FROM DUAL; -- 양쪽에있는 공백을 제거
SELECT TRIM ('Z' FROM 'ZZZZKHZZZZZZZZZ') FROM DUAL; --양쪽에있는 특정문자 제거

SELECT TRIM(LEADING 'Z' FROM 'ZZZZZZZKHZZZZZZZZZZZ') FROM DUAL; -- LTRIM유사한 기능
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZZZKHZZZZZZZZZZZ') FROM DUAL; -- TRAILING유사한 기능
SELECT TRIM(BOTH 'Z' FROM 'ZZZZZZZKHZZZZZZZZZZZ') FROM DUAL; -- 양쪽에있는 특수문자 제거

/*
    * LOWER / UPPER / INITCAP
    
    LOWER : 다 소문자로 변경한 문자열 반환
    UPPER : 다 대문자로 변경한 문자열 반환
    INITCAP : 띄어쓰기 기준 첫 글자마다 대문자로 변경한 문자열 반환
*/

SELECT LOWER('Welcome To My World!') FROM DUAL;
SELECT UPPER('Welcome To My World!') FROM DUAL;
SELECT INITCAP('welcome to my world!') FROM DUAL;

--==============================================================================

/*
    *CONCAT
    문자열 두개 전달받아서 하나로 합친 후 반환해준다.
    CONCAT (STRING1, STRING2)
*/

SELECT CONCAT('가나다', 'ABC') FROM DUAL; -- 두개의 문자열만 가능
SELECT '가나다' || 'ABC' FROM DUAL;


--==============================================================================

/*
    * REPLACE
    특정문자열에서 특정부분을 다른부분으로 교체
    REPLACE (문자열, 찾을 문자열, 변경할문자열)
*/

SELECT EMAIL, REPLACE (EMAIL, 'KH.or.kr', 'gmail.com')
FROM EMPLOYEE;


--==============================================================================

/*
    <숫자 처리 함수>
    
    *ABS
    숫자의 절대값을 구해주는 함수
*/

SELECT ABS (-10), ABS(-6.3) FROM DUAL;

--==============================================================================

/*
    *MOD
    두 수를 나눈 나머지값을 반환해주는 함수
    MOD (NUMBER, NUMBER)
*/

SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;


--==============================================================================

/*
    *ROUND
    반올림한 결과를 반환
    
    ROUND (NUMBER, [위치])
*/

SELECT ROUND (123.456, 0) FROM DUAL; -- 기본자리수는 소수점 첫번째 자리에서 반올림 : 0
SELECT ROUND (123.456, 1) FROM DUAL; -- 양수로 증가할 수록 소수점뒤로 한칸씩 이동 : 123.5
SELECT ROUND (123.456, -1) FROM DUAL; -- 음수로 증가할 수록 소수점 앞자리로 이동 : 120



/*
 * CEIL
 올림 처리를 위한 함수
 
  [표현법]
  CEIL (NUMBER)
*/
SELECT CEIL(123.456) FROM DUAL;

/*
    FLOOR
    버림처리 함수
    
    [표현법]
    FLOOR (NUMBER)
*/
SELECT FLOOR(123.955) FROM DUAL;

/*
    TRUNC
    버림처리 함수
    
    [표현법]
    TRUNC (NUMBER, [위치] )
*/
SELECT TRUNC (123.952) FROM DUAL;
SELECT TRUNC (123.952, 1) FROM DUAL;
SELECT TRUNC (123.952, -1) FROM DUAL;

--================================================QUIZ==========================

--검색하고자 하는 내용
--JOB_CODE가 J7이거나 J6이면서 SALART값이 200만원 이상이고
--BONUS가 있고 여자이며 이메일주소는 _앞에 3글자만 있는 사원의
-- 이름, 주민등록번호, 직급코드, 부서코드, 급여, 보너스를 조회하고싶다.
--정상적으로 조회되면 결과가 2개 


SELECT EMP_NAME, MEP_NO, JOB_CODE, DEPT_CODE, SALART, BONUS
FROM EMPLOYEE
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J6') AND SALART >= 2000000
        AND EMAIL LIKE '___\_%' ESCAPE '\' AND
        BONUS IS NOT NULL AND SUBSTR(EMP_NO, 8, 1)IN('2','4');
        
--위 SQL문에서 실행시 원하는 결과가 나오지않는다.
-- 어떤 문제가 있는지 원인을 서술하고, 조치한 코드를 작성하세요.

/*
    <날짜 처리 함수>
*/

-- *SYSDARE : 시스템의 현재 날씨및 시간을 반환환다.
SELECT SYSDATE FROM DUAL;


-- *MONTHS_BETWEEN : 두 날짜 사이의 개월 수
-- 사원들의 사원명, 입사일, 근무일수, 근무계월수를 조회
SELECT EMP_NAME, HIRE_DATE, FLOOR (SYSDATE - HIRE_DATE),
       CEIL (MONTHS_BETWEEN(SYSDATE,HIRE_DATE)) || '개월차' AS "근속개월"
FROM EMPLOYEE;


-- *ADD_MONTHS : 특정 날짜에 NUMBER개월수를 더해서 반환한다.
SELECT ADD_MONTHS(SYSDATE, 4 ) FROM DUAL;


-- 근로자 테이블에서 사원명, 입사일, 입사후 3개월의 날짜 조회 (정규직 전환일)
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3) AS "정규직 전환일"
FROM employee;
        
-- *NEXT_DAY (DATE, 요일(문자 | 숫자)) : 특정날짜 이후 가장 가까운 요일의 날짜를 반환한다.
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;
-- 1: 일요일  2: 월요일 .... 7: 토요일
SELECT NEXT_DAY(SYSDATE, 7) FROM DUAL;
SELECT NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL; --현재 내가 한국어 버전이라 오류남

-- 언어변경
ALTER SESSION SET NLS_LANGUAGE = AMERICAN; -- 영어로 언어 변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- 한국어로 언어 변경


-- *LAST_DAY(DATE) : 해당월의 마지막 날짜 구해서 반환한다.
SELECT LAST_DAY(SYSDATE) FROM DUAL;


-- 사원테이블에서 사원명, 입사일, 입사달의 마지막날짜, 입사달의 근무일수 조회
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE), LAST_DAY(HIRE_DATE) - HIRE_DATE
FROM EMPLOYEE;

/*
    *EXTRACT : 특정 날짜로부터 년도|월|일 값을 추출해서 반환하는 함수
    
    [표현법]
    EXTRACT(YEAR FROM DATE) : 연도 만 추출하고싶을때
    EXTRACT(MONTH FROM DATE) : 월 만 추출하고싶을때
    EXTRACT(DAY FROM DATE) : 일 만 추출하고싶을때
    => 결과는 NUMBER
*/

--사원의 사원명, 입사년도, 입사월, 입사일을 조회
SELECT EMP_NAME,
    EXTRACT(YEAR FROM HIRE_DATE) AS "입사년도",
    EXTRACT(MONTH FROM HIRE_DATE) AS "입사월",
    EXTRACT(DAY FROM HIRE_DATE) AS "입사일"
FROM EMPLOYEE
ORDER BY 2,3,4;


--============================================================================

/*
    [형변환 함수]
    * TO_CHAR : 숫자 타입 또는 날짜 타입의 값을 문자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_CHAR(숫자 | 날짜, [포맷]) 
*/

-- 숫자타입 --> 문자타입
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '99999') AS "NUMBER" FROM DUAL;  -- 9의 자리수만큼 공간확보, 오른쪽 정렬, 빈칸공백이 생긴다
SELECT TO_CHAR(1234, '00000') AS "NUMBER" FROM DUAL; -- 0의 자리수만큼 공간확보, 오른쪽 정렬, 빈칸을 0으로 채움
SELECT TO_CHAR(1234, 'L99999') FROM DUAL; -- 현재 설정된 나라의 로컬 화폐단위 포함
SELECT TO_CHAR(1234, '$99999') FROM DUAL; -- 달러로 나옴

SELECT TO_CHAR(3500000, 'L9,999,999') FROM DUAL;

--사원둘의 사원명, 월급, 연봉을 조회
SELECT EMP_NAME, TO_CHAR (SALARY, 'L99,999,999') AS "월급",
        TO_CHAR(SALARY * 12, 'L99,999,999')  AS "연봉"
FROM EMPLOYEE;


--날짜타입 => 문자타입
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS') FROM DUAL; -- AM, PM 어떤 것을 쓰던 형식에 맞춰나옴
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL; -- 24시간으로 표현
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DY') FROM DUAL;  --DAY 월요일 DY 월
SELECT TO_CHAR(SYSDATE, 'MON, YYYY') FROM DUAL;


--사원들의 이름, 입사날짜(0000년 00월 00일)
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') -- 정해진 형식대로만 사용가능하다.
FROM EMPLOYEE;


--년도와 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'YYYY'), --
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RRRR'), -- RR룰이 따로 존재한다 -> 50년이상값이 + 100 -> EX) 1954 
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT HIRE_DATE, TO_CHAR(HIRE_DATE) FROM EMPLOYEE;

--월과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'MM'), -- 이번달 숫자 두자리 > 02
       TO_CHAR(SYSDATE, 'MON'), -- 2월
       TO_CHAR(SYSDATE, 'MONTH') -- 약어로 나옴
FROM DUAL;


--일에 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 오늘이 이번년도에서 몇번째 일수 (24년 2월 19일 기준 050 = 50일)
       TO_CHAR(SYSDATE, 'DD'), -- 오늘 일자
       TO_CHAR(SYSDATE, 'D')  -- 요일 - > 숫자로 표시
FROM DUAL; 


--요일에 대한 포맷
SELECT TO_CHAR(SYSDATE, 'DAY'), -- 월요일
       TO_CHAR(SYSDATE, 'DY') -- 월
FROM DUAL;

--=============================================================================

/*
    TO_DATE : 숫자타입 또는 문자타입을 날짜타입으로 변경하는 함수
    
    TO_DATE(숫자 | 문자, [포멧] ) -> DATE 
*/
SELECT TO_DATE(20100101) FROM DUAL;
SELECT TO_DATE(240219) FROM DUAL; -- 50년 미만은 자동으로 20XX으로 설정되고 50년 이상은 19XX로 설정된다.

SELECT TO_DATE(020505) FROM DUAL; -- 숫자는 0으로 시작하면 안됨
SELECT TO_DATE('020505') FROM DUAL; -- 문자로 하면 됨 -> ''


SELECT TO_DATE('20240219 120800') FROM DUAL; -- 포멧을 정해줘야 시,분,초를 표시할 수 있다
SELECT TO_DATE('20240219 120800', 'YYYYMMDD HH24MISS') FROM DUAL;

--==================================================================================

/*
    TO_NUMBER : 문자타입의 데이터를 숫자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_NUMNER(문자, [포멧])
*/

SELECT TO_NUMBER('05123456789') FROM DUAL;

SELECT '100000' + '55000' FROM DUAL; --단순 형변환으로 덧셈이 되어 가능하다.
SELECT '100,000' + '55,000' FROM DUAL; -- , 로 인해 불가능하다
SELECT TO_NUMBER ('100,000', '999,999') + TO_NUMBER('55,000', '99,999')
FROM DUAL;

--==================================================================================

/*
    [NULL 처리 함수]
*/

-- NVL(컬럼, 해당컬럼이 NULL일 경우 보여줄 값)
SELECT EMP_NAME, NVL(BONUS,0)
FROM EMPLOYEE;

-- 전사원의 이름, 보너스포함 연봉
SELECT EMP_NAME, (SALARY + (SALARY * NVL(BONUS,0))) * 12
FROM EMPLOYEE;

--NVL2 (컬럼, 반환값1, 반환값2)
-- 반환값 1 : 해당컬럼이 존재할 경우 보여줄 값
-- 반환값 2 : 해당컬럼이 NULL일 경우 보여줄 값

SELECT EMP_NAME, BONUS, NVL2(BONUS, 'O', 'X')
FROM EMPLOYEE;

-- 사원들의 사원명과 부서배치여부(배정완료 또는 미배정 표시) 조회
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE, '배정완료','미배정')
FROM EMPLOYEE;

--NULLIF (비교대상1, 비교대상2)
-- 두 값이 일치하면 NULL 반환한다.
-- 두 값이 일치하지않는다면 비교대상1 반환한다.
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

--===============================================================================

/*
    [선택함수]
    *DECODE(비교하고자하는 대상(컬럼, 연산식, 함수식), 비교값1, 결과값1, 비교값2, 결과값2,  비교값3, 결과값3...)
    
    SWITCH(비교대상){
    CASE 비교값1:
        실행코드
    CASE 비교값2:
        실행코드
    ...
    }
*/

--사번, 사원명, 주민번호, 성별
SELECT EMP_ID, EMP_NAME, EMP_NO,
       DECODE (SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여', '3', '남', '4', '여', '외계인') AS "성별"
FROM EMPLOYEE;


--직원의 성명, 기존급여, 인상된 급여조회 * 각 직급별로 인상해서 조회
-- J7인 사원은 급여를 10%인상 (SALARY * 1.1)
-- J6인 사원은 급여를 15%인상 (SALARY * 1.15)
-- J5인 사원은 급여를 20%인상 (SALARY * 1.2)
-- 그외 사원들은 급여를 5%인상 (SALARY * 1.05)

SELECT EMP_NAME,SALARY AS "인상전",
       DECODE (JOB_CODE,
       'J7', SALARY * 1.1,
       'J6', SALARY * 1.15,
       'J5', SALARY * 1.2,
             SALARY * 1.05) AS "인상후"
FROM EMPLOYEE;

/*
    * CASE WHEN THEN
    
    CASE WHEN 조건식1 THEN 결과값1
         WHEN 조건식2 THEN 결과값2
         ...
         ELSE 결과값
    END
*/

SELECT EMP_NAME, SALARY,
       CASE WHEN SALARY >= 5000000 THEN '고급'
            WHEN SALARY >= 3500000 THEN '중급'
            ELSE '초급'
       END
FROM EMPLOYEE;

---------------------------------------그룹함수----------------------------------

-- 1. SUM(숫자타임컬럼) : 해당컬럼 값들의 총 합계를 구해서 반환해주는 함수

-- 근로자테이블의 전사원의 총 급여를 구해라
SELECT SUM(SALARY)
FROM EMPLOYEE;

--남자사원들의 총 급여함
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1','3');

--부서코드가 D5인 사원들의 총 연봉(급여 * 12)
SELECT SUM(SALARY * 12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


-- 2. AVG(NUMBER) : 해당 컬럼값들의 평균값을 구해서 반환
SELECT ROUND (AVG(SALARY))
FROM EMPLOYEE;



-- 3. MIN(모든타입가능) : 해당컬럼값 중 가장 작은 값 구해서 반환하기
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;


-- 4. MAX(모든 타입 가능) : 해당 컬럼값들 중에 가장 큰 값을 구해서 반환
SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;


-- 5. COUNT(* | 컬럼 | DISTINCT 컬럼) : 해당 조건에 맞는 행의 갯수를 세서 반환
-- COUNT(*) : 조회된 결과에 모든 행의 갯수를 세서 반환
-- COUNT(컬럼) : 제시한 해당 컬럼값이 NULL이 아닌 것만 행의 갯수를 세서 반환
-- COUNT(DISTINCT 컬럼) : 해당 컬럼값 중북을 제거한 후 행의 갯수 세서 반환

-- 전체 사원 수
SELECT COUNT(*) FROM EMPLOYEE;


-- 여자사원 수
SELECT COUNT(*) 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN('2','4');


-- 보너스를 받는 사원 수
SELECT COUNT(BONUS) -- 1 번째 COUNT 만 이용해서 구분
FROM EMPLOYEE;

SELECT COUNT(*) -- 2번째 COUNT 랑 IS 를 이용하여 구분
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 부서배치를 받은 사원 수
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE;

-- 현재 사원들이 총 몇개의 부서에 분포되어 있는지 조회
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;









