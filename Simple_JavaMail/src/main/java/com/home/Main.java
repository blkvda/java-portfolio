package com.home;

import com.sun.mail.imap.IMAPStore;
import com.sun.mail.pop3.POP3Store;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;

public class Main {


    public static void main(String[] args) {

    }


    private static void  receivePOP3(){
        try{
            Properties userProps = new Properties();
            userProps.load(Main.class.getClassLoader().getResourceAsStream("UserProps.properties"));
            String user = userProps.getProperty("user");
            String password = userProps.getProperty("password");

            //Get the session object
            Properties props = new Properties();
            props.put("mail.pop3.host", "pop.yandex.ru");
            props.put("mail.pop3.port", 995);
            props.put("mail.pop3.ssl.enable", "true");
            props.put("mail.pop3.auth", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user,password);
                        }
                    });

            //2) create the IMAP store object and connect with the pop server
            POP3Store emailStore = (POP3Store) session.getStore("pop3");
            emailStore.connect(user, password);

            //3) create the folder object and open it
            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //4) retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

            //5) close the store and folder objects
            emailFolder.close(false);
            emailStore.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void receiveIMAP(){
        try{
            Properties userProps = new Properties();
            userProps.load(Main.class.getClassLoader().getResourceAsStream("UserProps.properties"));
            String user = userProps.getProperty("user");
            String password = userProps.getProperty("password");

            //Get the session object
            Properties props = new Properties();
            props.put("mail.imap.host", "imap.yandex.ru");
            props.put("mail.imap.port", 993);
            props.put("mail.imap.ssl.enable", "true");
            props.put("mail.imap.auth", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user,password);
                        }
                    });

            //2) create the IMAP store object and connect with the pop server
            IMAPStore emailStore = (IMAPStore) session.getStore("imap");
            emailStore.connect(user, password);

            //3) create the folder object and open it
            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //4) retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

            //5) close the store and folder objects
            emailFolder.close(false);
            emailStore.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Отправка емейла используя SMTP - на сервере отправленное сообщение не сохраняется
    //получать емейл по этому протоколу нельзя
    private static void sendSMTPnoAttachment(){
        try {
            Properties userProps = new Properties();
            userProps.load(Main.class.getClassLoader().getResourceAsStream("UserProps.properties"));
            String user = userProps.getProperty("user");
            String password = userProps.getProperty("password");
            String to = userProps.getProperty("to");

            //Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host","smtp.yandex.ru");
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user,password);
                        }
                    });

            //Compose the message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Тест 2 - отправка без вложений");
            message.setText("Тетовый текст");

            //send the message
            Transport.send(message);
            System.out.println("message sent successfully...");
        }
        catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendSMTPwithAttachment(){
        try {
            Properties userProps = new Properties();
            userProps.load(Main.class.getClassLoader().getResourceAsStream("UserProps.properties"));
            String user = userProps.getProperty("user");
            String password = userProps.getProperty("password");
            String to = userProps.getProperty("to");

            //Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host","smtp.yandex.ru");
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user,password);
                        }
                    });

            //Compose the message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Тест 3 - отправка вложений");

            //3) create MimeBodyPart object and set your message text
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("This is message body");

            //4) create new MimeBodyPart object and set DataHandler object to this object
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            File testFile1 = new File("testfile1.txt");
            OutputStreamWriter outputStreamReader = new OutputStreamWriter(new FileOutputStream(testFile1));
            outputStreamReader.write("some text in file1");
            outputStreamReader.flush();
            DataSource dataSource = new FileDataSource(testFile1);
            messageBodyPart2.setDataHandler(new DataHandler(dataSource));
//            messageBodyPart2.setHeader("Content-Transfer-Encoding", "8bit");
//            messageBodyPart2.setHeader("Content-Type", dataSource.getContentType() + "; " + dataSource.getName());
            messageBodyPart2.setFileName("someAttachment222.txt");


            //5) create Multipart object and add MimeBodyPart objects to this object
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);

            //6) set the multipart object to the message object
            message.setContent(multipart);

            //send the message
            Transport.send(message);
            System.out.println("message sent successfully...");
        }
        catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}
