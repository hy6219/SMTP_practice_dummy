# 회원 가입을 위한 기능들 연습하기!

- 이 공간은 JSP 서블릿을 공부하면서 회원가입 인증처리에 필요한 기능들을 연습한 것을
기록해둔 공간입니다

1. 21-06-11 이메일 인증 방식 구현

- 먼저 선행되어야 할 것
https://jinseongsoft.tistory.com/294
위에서처럼 지메일을 이용하고자 할 경우, 2단계 인증 및 보안 수준을 변경해주어야 한다
(테스트용 계정을 하나 생성하는 것이 좋을 수 있다!)

그리고 네이버도, 지메일도 POP과 IMAP 혹은 SMTP 설정을 해주어야 한다!
a) 네이버
환경설정-POP3/SMTP설정-POP3/SMTP 사용함 체크, 원본저장 설정하기

b) 지메일
환경설정-톱니바퀴-모든 설정 보기-전달 및 POP/IMAP-IMAP사용 설정하기

참고로, 네이버는 587번 포트, 지메일은 465번 포트를 사용!!
- https://mvnrepository.com/artifact/javax.mail/mail/1.4.7 에서 jar 파일 다운로드하기

- 인증을 위한 주요 클래스 정리

a) MailAuth 클래스: 계정 인증
   i. PasswordAuthentication 클래스 이용

b) MailSend 클래스: MailAuth를 이용하여 계정 확인 후 인증번호 생성, 메시지로 보내기
  i. javax.mail.Authenticator : MailAuth 객체를 통한 비밀번호 일치 확인(불일치시 javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted. Learn more at 535 5.7.8 https://support.google.com/mail/?p=BadCredentials x6sm3253404pfd.173 - gsmtp 에러가 뜰 수 있다!)


ii. javax.mail.Message  : 수신자 설정을 위함

iii. javax.mail.Session    : 메일을 보낼 때 세션을 이용하여 정보가 공유될 수 있도록 하여 scope로 인한 정보손실을 막기 위해 사용

iv. javax.mail.Transport : 메일을 보내기 위하여 사용(send(메시지객체))

v. javax.mail.internet.InternetAddress : 메일 주소를 명시하기 위하여 사용

vi.javax.mail.internet.MimeMessage   : 세션을 통해서 메시지를 위한 객체

- 결과물
![](https://github.com/hy6219/SMTP_practice_dummy/blob/master/SMTP_Email_authentification210611.gif?raw=true)

