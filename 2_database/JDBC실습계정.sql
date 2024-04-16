-- ������ DROP�� ������ ���̺� �ݴ������ ��������� ���߿� �߸��Ǿ����� 
-- ����� ���ϰ� �������´�
DROP TABLE  MEMBER;
DROP TABLE TEST;

CREATE TABLE TEST(
    TNO NUMBER,
    TNAME VARCHAR2(20),
    TDATE DATE
);

SELECT * FROM TEST;

CREATE TABLE MEMBER(
    BOOKNO NUMBER PRIMARY KEY, -- å ��ȣ
    BOOKID VARCHAR2(15) NOT NULL, --å �̸�
    AUTHORauthor VARCHAR2(15) NOT NULL, --����
    USERNAME VARCHAR2(20) NOT NULL, --���ǻ�
    ENROLLDATE DATE DEFAULT SYSDATE NOT NULL --�����
);

DROP SEQUENCE SEQ_USERNO;
CREATE SEQUENCE SEQ_USERNO
NOCACHE;

INSERT INTO MEMBER
VALUES(SEQ_USERNO.NEXTVAL, '�𳪸���','001','���������� �� ��ġ','admin@iei.or.kr','01012345678','��Ż���� ���׻�','53 x 77 cm', '1503~1506������� ����');

INSERT INTO MEMBER
VALUES(SEQ_USERNO.NEXTVAL, '������ ����','002','���������� �� ��ġ','admin@iei.or.kr','01012345678','��Ż���� ���׻�','880 x 700 cm', '1490��');

COMMIT;

SELECT * FROM MEMBER;














