package com.example.userservice.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.jvnet.staxex.Base64EncoderStream;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import java.io.IOException;
import java.net.HttpURLConnection;

public class MessageSenderWithAuth extends HttpUrlConnectionMessageSender{

    private String login;
    private String password;

    public MessageSenderWithAuth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection) throws IOException {

        String logPass = login.concat(":").concat(password);
        String encodedlogPass = new String(Base64.encodeBase64(logPass.getBytes()));
        connection.setRequestProperty("Authorization", "Basic " + encodedlogPass);

        super.prepareConnection(connection);

    }
}
