package test;

import com.app.spring.service.security.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TokenServiceTest {

    private String token;


    @Before
    public void setUp() {
        token = TokenService.createToken("karol", "cba", "USER");
    }

    @Test
    public void validateToken() {
        String expected = TokenService.createToken("karol", "cba", "USER");
        assertEquals(expected, token);
    }

    @Test
    public void shouldFailBadTokenKey() {
        //different key for hashing algorithm
        String different = JWT.create().withClaim("name", "karol").sign(Algorithm.HMAC384("superSecret"));
        assertNotEquals(different, token);
        //assertNotEquals("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6ImNiYSIsInJvbGUiOiJVU0VSIiwibmFtZSI6Imthcm9sIn0.uLMWf8DpDjoojeQBS6RmIxu_MPe1gfDCiVxt8FDUuUI", token);
    }

    @Test
    public void decodeToken() {
        String name = JWT.decode(token).getClaim("name").asString();
        String role = JWT.decode(token).getClaim("role").asString();
        assertEquals("USER", role);
        assertEquals("karol", name);
    }
}