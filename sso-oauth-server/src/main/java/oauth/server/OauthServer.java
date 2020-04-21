package oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
public class OauthServer {
    public static void main(String[] args) {
        SpringApplication.run(OauthServer.class,args);
    }
}
