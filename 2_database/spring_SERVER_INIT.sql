----------����-------------
--���������� ��� ���̺� �� �������� ����
BEGIN
    FOR C IN (SELECT TABLE_NAME FROM USER_TABLES) LOOP
    EXECUTE IMMEDIATE ('DROP TABLE '||C.TABLE_NAME||' CASCADE CONSTRAINTS');
    END LOOP;
END;
/

--���������� ��� ������ ����
BEGIN
FOR C IN (SELECT * FROM USER_SEQUENCES) LOOP
  EXECUTE IMMEDIATE 'DROP SEQUENCE '||C.SEQUENCE_NAME;
END LOOP;
END;
/

--���������� ��� �� ����
BEGIN
FOR C IN (SELECT * FROM USER_VIEWS) LOOP
  EXECUTE IMMEDIATE 'DROP VIEW '||C.VIEW_NAME;
END LOOP;
END;
/
------------------------------

---------------------------------------
-------------MEMBER����---------------------
------------------------------------------
CREATE TABLE MEMBER(
    USER_ID VARCHAR2(30) PRIMARY KEY,
    USER_PWD VARCHAR2(100) NOT NULL,
    USER_NAME VARCHAR2(15) NOT NULL,
    EMAIL VARCHAR2(100),
    GENDER VARCHAR2(1) CHECK (GENDER IN ('M','F')),
    AGE NUMBER,
    PHONE VARCHAR(13),
    ADDRESS VARCHAR2(100),
    ENROLL_DATE DATE DEFAULT SYSDATE,
    MODIFY_DATE DATE DEFAULT SYSDATE,
    STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N'))
);

COMMENT ON COLUMN MEMBER.USER_ID IS 'ȸ�����̵�';
COMMENT ON COLUMN MEMBER.USER_PWD IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.USER_NAME IS 'ȸ����';
COMMENT ON COLUMN MEMBER.PHONE IS 'ȸ����ȭ��ȣ';
COMMENT ON COLUMN MEMBER.EMAIL IS 'ȸ���̸���';
COMMENT ON COLUMN MEMBER.GENDER IS 'ȸ������';
COMMENT ON COLUMN MEMBER.AGE IS 'ȸ������';
COMMENT ON COLUMN MEMBER.ADDRESS IS 'ȸ���ּ�';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS 'ȸ��������';
COMMENT ON COLUMN MEMBER.MODIFY_DATE IS '����������';
COMMENT ON COLUMN MEMBER.STATUS IS '���°�(Y/N)';

INSERT INTO MEMBER
VALUES ('admin', '1234', '������', 'admin@kh.or.kr', 'F', 30, '010-1111-2222', '����� ������ ���ﵿ', '20230101', '20230101', DEFAULT);

INSERT INTO MEMBER
VALUES ('user01', 'pass01', 'ȫ�浿', 'user01@kh.or.kr', 'M', 25, '010-3333-4444', '����� ��õ�� ��', '20230201', '20230201', DEFAULT);

INSERT INTO MEMBER
VALUES ('user02', 'pass02', '�踻��', 'user02@kh.or.kr', 'F', 23, '010-5555-6666', '����� ������ ����', '20230301', '20230301', DEFAULT);


-------------------------------------------------
------------NOTICE����------------------------
--------------------------------------------


CREATE TABLE NOTICE(
    NOTICE_NO NUMBER PRIMARY KEY,
    NOTICE_TITLE VARCHAR2(30) NOT NULL,
    NOTICE_WRITER VARCHAR2(30) NOT NULL,
    NOTICE_CONTENT VARCHAR2(200) NOT NULL,
    CREATE_DATE DATE DEFAULT SYSDATE,
    FOREIGN KEY(NOTICE_WRITER) REFERENCES MEMBER(USER_ID) ON DELETE CASCADE
);

COMMENT ON COLUMN NOTICE.NOTICE_NO IS '�������׹�ȣ';
COMMENT ON COLUMN NOTICE.NOTICE_TITLE IS '������������';
COMMENT ON COLUMN NOTICE.NOTICE_WRITER IS '�ۼ��ھ��̵�';
COMMENT ON COLUMN NOTICE.NOTICE_CONTENT IS '�������׳���';
COMMENT ON COLUMN NOTICE.CREATE_DATE IS '���������ۼ���';

CREATE SEQUENCE SEQ_NNO
NOCACHE;

INSERT INTO NOTICE VALUES (SEQ_NNO.NEXTVAL, '������ ����', 'admin',
                            '�������񽺸� �Խ��մϴ�. ���� �̿����ּ���',
                            '20230201');
                            
INSERT INTO NOTICE VALUES (SEQ_NNO.NEXTVAL, '�������� ���� ȯ��', 'admin',
                            '���� ���µǾ�����. ���� �̿��ϰڽ��ϴ�.',
                            '20230201');

INSERT INTO NOTICE VALUES (SEQ_NNO.NEXTVAL, '�������� �̿�ȳ�', 'admin',
                            '�������񽺴� ȸ���� �̿��� �� �ֽ��ϴ�. ȸ�������ϼ���.',
                            '20230201');

COMMIT;

-------------------------------------------------------
----------------- BOARD ���� ------------------------
-------------------------------------------------------

CREATE TABLE BOARD(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR2(100) NOT NULL,
    BOARD_WRITER VARCHAR2(15) NOT NULL,
    BOARD_CONTENT VARCHAR2(4000) NOT NULL,
    ORIGIN_NAME VARCHAR2(100),
    CHANGE_NAME VARCHAR2(100),
    COUNT NUMBER DEFAULT 0,
    CREATE_DATE DATE DEFAULT SYSDATE,
    STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
    FOREIGN KEY (BOARD_WRITER) REFERENCES MEMBER ON DELETE CASCADE
);

COMMENT ON COLUMN BOARD.BOARD_NO IS '�Խñ۹�ȣ';
COMMENT ON COLUMN BOARD.BOARD_TITLE IS '�Խñ�����';
COMMENT ON COLUMN BOARD.BOARD_WRITER IS '�ۼ��ھ��̵�';
COMMENT ON COLUMN BOARD.BOARD_CONTENT IS '�Խñ۳���';
COMMENT ON COLUMN BOARD.ORIGIN_NAME IS '÷�����Ͽ����̸�';
COMMENT ON COLUMN BOARD.CHANGE_NAME IS '÷�����Ϻ����̸�';
COMMENT ON COLUMN BOARD.COUNT IS '�Խñ���ȸ��';
COMMENT ON COLUMN BOARD.CREATE_DATE IS '�Խñ��ۼ���';
COMMENT ON COLUMN BOARD.STATUS IS '�Խñۻ��°�(Y/N)';

CREATE SEQUENCE SEQ_BNO
NOCACHE;

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '������ �Խñ�', 'admin',
        '���� ����Ʈ�� �̿��� �ּż� �����մϴ�.', NULL, NULL,
        DEFAULT, '20220210', DEFAULT);
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'MVC Model2 �����̶�', 'user01',
        '�� ���ø����̼� ���� ��� �� �ϳ��Դϴ�.', NULL, NULL,
        DEFAULT, '20220211', DEFAULT);  
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '������ 2', 'user02',
        '�� ���ø����̼� ���� ��� �� �ι�° ����� �� ���� ���� �տ� First Controller�� �δ� ���Դϴ�.', 
        NULL, NULL, DEFAULT, '20220212', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '������ 3', 'user02',
        '�� ���ø����̼� ���� ��� �� ����° ����� Front Controller ������ ����Ǵ� ��Ʈ�ѷ����� ������ �ƴ� �ڹ� Ŭ������ �ۼ��ؼ� �����ϴ� ����Դϴ�.', 
        NULL, NULL, DEFAULT, '20220220', DEFAULT);
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'MVC Modell ����', 'user01',
        '�� ���ø����̼� ���� ��� �� JSP ������ ��� ��Ʈ�ѷ� �ΰ��� �ٸ� ó���ϴ� ����Դϴ�.', 
        NULL, NULL, DEFAULT, '20220220', DEFAULT);
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'JSP��', 'user02',
        'Java Server Page�� ����', 
        NULL, NULL, DEFAULT, '20220221', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'Servlet�̶�', 'admin',
        '�������� �����Ǵ� �� �Ծ��� ����� Java EE����� �����ϴ� ���� ó���� Ŭ������.', 
        NULL, NULL, DEFAULT, '20220221', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'HTML5', 'user02',
        '���ο� �� ǥ�ر���� ��� ����̽� ��ġ�� ���������� �����ϰ� �۵��Ǵ� ���������� ����� ���� ����� �����Ѵ�.', 
        NULL, NULL, DEFAULT, '20220301', DEFAULT);
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'CSS3', 'user02',
        '�� �������� �ٹ̱� ���� ��Ÿ�Ͻ�Ʈ�� HTML5 ������ ���߾� �Ӽ����� ���׷��̵� �Ǿ���.', 
        NULL, NULL, DEFAULT, '20220301', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'jQuery ��', 'admin',
        '�ڹٽ�ũ��Ʈ ���� �ҽ� ���̺귯���� �ϳ��� html ��ҵ��� css �����ڸ� �̿��ؼ� ���� ������ �� �ִ� ��ɵ��� �����Ѵ�.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'ajax ��', 'admin',
        'asynchronos javascript and xml�� ���Ӹ��� ������ ������ ���� ����ϴ� �ڹٽ�ũ��Ʈ ����̴�.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '����(Filter) ��', 'user02',
        'Ŭ���̾�Ʈ ��û�� ���񽺰� �������� ���޵Ǳ� ���� ���� �����Ǵ� Ŭ�����̴�.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
        
INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '����(Wrapper) ��', 'user01',
        '���Ͱ� ����æ ��û�� ���� ������ ó���� ����ϴ� Ŭ�����̴�.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
        
        
--------------------------------------------------------------------------
------------------------ REPLY ���� ---------------------------
--------------------------------------------------------------------

CREATE TABLE REPLY(
    REPLY_NO NUMBER PRIMARY KEY,
    REPLY_CONTENT VARCHAR2(400) NOT NULL,
    REF_BNO NUMBER NOT NULL,
    REPLY_WRITER VARCHAR2(15) NOT NULL,
    CREATE_DATE DATE DEFAULT SYSDATE NOT NULL,
    STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN ('Y','N')),
    FOREIGN KEY (REF_BNO) REFERENCES BOARD(BOARD_NO),
    FOREIGN KEY (REPLY_WRITER) REFERENCES MEMBER(USER_ID)
);

COMMENT ON COLUMN REPLY.REPLY_NO IS '��۹�ȣ';
COMMENT ON COLUMN REPLY.REPLY_CONTENT IS '��۳���';
COMMENT ON COLUMN REPLY.REF_BNO IS '�����ϴ°Խñ۹�ȣ';
COMMENT ON COLUMN REPLY.REPLY_WRITER IS '����ۼ��ھ��̵�';
COMMENT ON COLUMN REPLY.CREATE_DATE IS '����ۼ���';
COMMENT ON COLUMN REPLY.STATUS IS '���°�(Y/N)';

CREATE SEQUENCE SEQ_RNO
NOCACHE;

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, 'ù��° ����Դϴ�.', 1, 'admin', '20220213', DEFAULT);

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, 'ù��° ����Դϴ�.', 13, 'user01', '20221030', DEFAULT);

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, '�ι�° ����Դϴ�.', 13, 'user02', '20221030', DEFAULT);

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, '������ ����Դϴ�.', 13, 'admin', '20221030', DEFAULT);

COMMIT;