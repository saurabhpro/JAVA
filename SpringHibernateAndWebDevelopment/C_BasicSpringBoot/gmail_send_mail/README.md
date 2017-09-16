- https://www.quickprogrammingtips.com/spring-boot/how-to-send-email-from-spring-boot-applications.html
- http://www.technicalkeeda.com/spring-tutorials/spring-4-sending-email-with-freemarker-template


Since we are using gmail to send email, we need to enable "less secure access" on the gmail account. 
1. Login in to the gmail account configured in application.properties. 
2. Then click on this [link and turn on access for less secure apps](https://www.google.com/settings/security/lesssecureapps). In some cases, you may need to access this [link as well](https://accounts.google.com/b/0/DisplayUnlockCaptcha)! If you don’t follow these steps, you will get the following error,

`org.springframework.mail.MailAuthenticationException: Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 534-5.7.14 Please log in via your web browser and 534-5.7.14 then try again.`


Less secure sign in option is required for Yahoo mail as well. This article contains configuration details for other email providers such as Yahoo mail, sendgrid and mailgun.


http://javasampleapproach.com/spring-framework/spring-boot/configure-javamailsender-springboot