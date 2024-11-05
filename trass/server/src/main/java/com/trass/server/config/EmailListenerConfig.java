package com.trass.server.config;


import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListLabelsResponse;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.sun.mail.imap.IMAPStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.*;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import com.sun.mail.imap.IMAPFolder;

@Configuration
public class EmailListenerConfig {

    @Value("${imapConnection.host}")
    private String emailHost;

    @Value("${imapConnection.port}")
    private String emailPort;

    @Value("${imapConnection.username}")
    private String emailUsername;

    @Value("${imapConnection.password}")
    private String emailPassword;

    @Bean
    public IMAPFolder emailListener() {
        try {
//        Properties props = new Properties();
//        props.setProperty("mail.store.protocol", "imaps");
//        props.setProperty("mail.imap.ssl.enable", "true"); // required for Gmail
//        props.setProperty("mail.imap.auth.mechanisms", "XOAUTH2");
//        props.setProperty("mail.imaps.host", emailHost);
//        props.setProperty("mail.imaps.port", emailPort);
//
//        // Create a new session with the properties
//        Session session = Session.getInstance(props);
//        session.setDebug(true); // Enable debug mode for troubleshooting
//
//        Store store = session.getStore("imaps");
//        store.connect(emailUsername, emailPassword);

//            final AccessToken accessToken = ServiceAccountCredentials.fromStream(this.getClass().getClassLoader().getResourceAsStream("google.json")).createScoped(Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM)).refreshAccessToken();

//            Properties props = new Properties();
//            props.put("mail.imap.ssl.enable", "true");
//            props.put("mail.imaps.sasl.enable", "true");
//            props.put("mail.imaps.sasl.mechanisms", "XOAUTH2");
//            props.put("mail.imap.auth.xoauth2.disable", "false");
//            props.put("mail.imap.auth.login.disable", "true");
//            props.put("mail.imap.auth.plain.disable", "true");
//            props.put("mail.imap.auth.ntlm.disable", "true");
//            props.put("mail.debug", "true");
//            props.put("mail.debug.auth", "true");
//
//            Session session = Session.getInstance(props);
//            session.setDebug(true);
//            Store store = session.getStore("imap");

//            store.connect("imap.gmail.com", emailUsername, accessToken.getTokenValue());
            try {
                NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
                GoogleCredentials credential = ServiceAccountCredentials.fromStream(this.getClass().getClassLoader().getResourceAsStream("google.json")).createScoped(Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM));
                HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credential);
                Gmail gmail = new Gmail.Builder(HTTP_TRANSPORT, GsonFactory.getDefaultInstance(), requestInitializer).setApplicationName("trassiapp").build();
                String user = "me";
                ListLabelsResponse listResponse = gmail.users().labels().list(user).execute();
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }



//            Properties props = new Properties();
//            props.put("mail.imap.ssl.enable", "true"); // required for Gmail
//            props.put("mail.imap.auth.mechanisms", "XOAUTH2");
//            Session session = Session.getInstance(props);
//            Store store = session.getStore("imap");
//            store.connect("imap.gmail.com", "trassiapp@trassiapp.iam.gserviceaccount.com", gc.refreshAccessToken().getTokenValue());
//            OAuth2Authenticator.initialize();
//            IMAPStore imapStore = OAuth2Authenticator.connectToImap("imap.gmail.com",
//                993,
//                "trassiapp@trassiapp.iam.gserviceaccount.com",
//                    gc.refreshAccessToken().getTokenValue(),
//                true);
            return null;
//            Properties props = new Properties();
//            props.put("mail.imaps.sasl.enable", "true");
//            props.put("mail.imaps.sasl.mechanisms", "XOAUTH2");
//            props.put(OAuth2SaslClientFactory.OAUTH_TOKEN_PROP, gc.refreshAccessToken().getTokenValue());
//            Session session = Session.getInstance(props);
//            session.setDebug(debug);
//
//            final URLName unusedUrlName = null;
//            IMAPSSLStore store = new IMAPSSLStore(session, unusedUrlName);
//            final String emptyPassword = "";
//            store.connect(host, port, userEmail, emptyPassword);
//            return store;
//        IMAPFolder inbox = (IMAPFolder)store.getFolder("INBOX");
//        inbox.open(Folder.READ_WRITE);
//
//        inbox.addMessageCountListener(new MessageCountAdapter() {
//            @Override
//            public void messagesAdded(MessageCountEvent event) {
//                // Process the newly added messages
//                Message[] messages = event.getMessages();
//                for (Message message : messages) {
//                    try {
//                        // Implement your email processing logic here
//                        System.out.println("New email received: " + message.getSubject());
//                    } catch (MessagingException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        return inbox;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
