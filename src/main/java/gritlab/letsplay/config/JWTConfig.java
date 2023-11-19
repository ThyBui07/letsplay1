package gritlab.letsplay.config;
import org.springframework.beans.factory.annotation.Value;
public class JWTConfig {
    //Generating token
    @Value("${secret}")
    private String secret;
    private static final long serialVersionUID = 7008375124389347049L;
    public static final long TOKEN_VALIDITY = 10 * 60 * 60;

    //Validating token
    //Checking the signature
    //Verifying claims and permissions
}
