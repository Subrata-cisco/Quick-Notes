package com.subrata.javamail;

/**
 * Send receive mail using java mail API
 * @author Subrata Saha.
 *
 */

/*
 public class SimpleMailReader
 {

 public static void main(String args[])
 {
 try
 {
 String strServer=args[0];
 String strUser=args[1];
 String strPassword=args[2];

 read(strServer, strUser, strPassword);
 }
 catch (Exception ex)
 {
 System.out.println("Usage: java SimpleMailReader"
 +" strServer strUser strPassword");
 }

 System.exit(0);
 }


 //"read" method to fetch messages and process them.

 public static void read(String strServer, String strUser
 , String strPassword)
 {

 Store mystore=null;
 Folder myfolder=null;

 try
 {
 Properties p = System.getProperties();
 Session session = Session.getDefaultInstance(p, null);

 mystore = session.getStore("pop3");
 mystore.connect(strServer, strUser, strPassword);

 myfolder = mystore.getDefaultFolder();
 if (myfolder == null) throw new Exception("No default folder");

 myfolder = myfolder.getFolder("INBOX");
 if (myfolder == null) throw new Exception("No POP3 INBOX");

 myfolder.open(Folder.READ_ONLY);

 Message[] msg = myfolder.getMessages();
 for (int msgNumber = 0; msgNumber < msg.length; msgNumber++)
 {
 printMessage(msg[msgNumber]); 
 }

 }
 catch (Exception ex)
 {
 ex.printStackTrace();
 }
 finally
 {
 try
 {
 if (myfolder!=null) myfolder.close(false);
 if (mystore!=null) mystore.close();
 }
 catch (Exception ex2) {ex2.printStackTrace();}
 }
 }

 public static void printMessage(Message message)
 {
 try
 {
 String strfrom=((InternetAddress)message.getFrom()[0]).getPersonal();
 if (strfrom==null) strfrom=((InternetAddress)message.getFrom()[0]).getAddress();
 System.out.println("FROM: "+strfrom);

 String strsubject=message.getSubject();
 System.out.println("SUBJECT: "+strsubject);

 Part msgPart=message;
 Object content=msgPart.getContent();

 if (content instanceof Multipart)
 {
 msgPart=((Multipart)content).getBodyPart(0);
 System.out.println("[ Multipart Message ]");
 }

 String contentType=msgPart.getContentType();

 System.out.println("CONTENT:"+contentType);

 if (contentType.startsWith("text/plain")
 || contentType.startsWith("text/html"))
 {
 InputStream is = msgPart.getInputStream();

 BufferedReader reader
 =new BufferedReader(new InputStreamReader(is));
 String thisLine=reader.readLine();

 while (thisLine!=null)
 {
 System.out.println(thisLine);
 thisLine=reader.readLine();
 }
 }

 System.out.println("-----------------------------");
 }
 catch (Exception ex)
 {
 ex.printStackTrace();
 }
 } 
 }


 Simple JavaMail Serder.java



 import javax.mail.*;
 import javax.mail.internet.*;

 import java.util.*;

 // A simple email sender class.
 public class SimpleMailSender
 {


 public static void main(String args[])
 {
 try
 {
 String strstrSmtpServer=args[0];
 String strTo=args[1];
 String strFrom=args[2];
 String strSubject=args[3];
 String strBody=args[4];

 send(strstrSmtpServer, strTo, strFrom, strSubject, strBody);
 }
 catch (Exception ex)
 {
 System.out.println("Usage: java SimpleMailSender"
 +" strstrSmtpServer toAddress fromAddress subjectText bodyText");
 }

 System.exit(0);
 }


 public static void send(String strSmtpServer, String strTo, String strFrom
 , String strSubject, String strBody)
 {
 try
 {
 java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

 Properties p = new Properties(System.getProperties());
 // -- Attaching to default Session, or we could start a new one --
 // -- Could use Session.getTransport() and Transport.connect()
 // , but assume we're using SMTP --


 if(strSmtpServer != null)
 {
 p.put("mail.smtp.starttls.enable","true");
 p.put("mail.smtp.host", strSmtpServer);
 p.put("mail.transport.protocol", "smtp");
 p.put("mail.smtp.starttls.enable","true");
 p.put("mail.smtp.auth", "true");


 }

 Session session = Session.getDefaultInstance(p, null);

 // -- Create a new message --
 Message msg = new MimeMessage(session);

 // -- Set the FROM and TO fields --
 msg.setFrom(new InternetAddress(strFrom));
 msg.setRecipients(Message.RecipientType.TO,
 InternetAddress.parse(strTo, false));

 // -- We could include CC recipients too --
 // if (cc != null)
 // msg.setRecipients(Message.RecipientType.CC
 // ,InternetAddress.parse(cc, false));

 // -- Set the subject and body text --
 msg.setSubject(strSubject);
 msg.setText(strBody);

 // -- Set some other header information --
 msg.setHeader("X-Mailer", "KogentEmail");
 msg.setSentDate(new Date());

 // -- Send the message --
 Transport.send(msg);

 System.out.println("Message sent OK.");
 }
 catch (Exception ex)
 {
 ex.printStackTrace();
 }
 }
 }
 */
