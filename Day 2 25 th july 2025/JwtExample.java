//package `Day 2 25 th july 2025`

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtExample {

    // Secret key used to sign the JWT
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 256-bit key

    public static void main(String[] args) {
        // 1. Create JWT
        String token = createJwt("aditya13", "Aditya", "Student");
        System.out.println(" JWT Token:\n" + token);

        // 2. Decode/Verify JWT
        System.out.println("\n Decoded Payload:");
        decodeJwt(token);
    }

    //  Create JWT
    public static String createJwt(String userId, String username, String role) {
        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(userId) // user ID
                .claim("username", username)
                .claim("role", role)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 1000 * 60 * 5)) // 5 minutes
                .signWith(SECRET_KEY)
                .compact();
    }

    // Verify and Decode JWT
    public static void decodeJwt(String token) {
        try {
            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);

            Claims claims = jwt.getBody();

            System.out.println("Subject (user ID): " + claims.getSubject());
            System.out.println("Username: " + claims.get("username"));
            System.out.println("Role: " + claims.get("role"));
            System.out.println("Issued At: " + claims.getIssuedAt());
            System.out.println("Expiration: " + claims.getExpiration());
        } catch (JwtException e) {
            System.out.println("Invalid token: " + e.getMessage());
        }
    }
}
