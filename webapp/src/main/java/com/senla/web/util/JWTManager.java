package com.senla.web.util;

import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.senla.entity.User;
import com.senla.web.filter.JWTFilter;

import net.minidev.json.JSONObject;

@Component
public class JWTManager {

	private static final JWSAlgorithm algorithm = JWSAlgorithm.HS256;
	private static final String issuer = "webapp";
	private static final TemporalAmount TOKEN_VALIDITY = Duration.ofHours(4L);
	private static final Logger logger = Logger.getLogger(JWTFilter.class);
	private static final byte[] sharedKey = new byte[32];

	static {
		generateSharedKey();
	}

	public static String createToken(User user) {
		try {
			MACSigner signer = new MACSigner(sharedKey);
			JWTClaimsSet set = new JWTClaimsSet.Builder().issuer(issuer).expirationTime(getExpirationPeriod())
					.claim("User", user).build();
			SignedJWT sign = new SignedJWT(new JWSHeader(algorithm), set);
			sign.sign(signer);
			return sign.serialize();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public static boolean verifyToken(String token) {
		try {
			SignedJWT sign = SignedJWT.parse(token);
			JWSVerifier verifier = new MACVerifier(sharedKey);
			Date expiryDate = (Date) sign.getJWTClaimsSet().getExpirationTime();
			if (sign.verify(verifier) && expiryDate.after(new Date())) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}

	private static Date getExpirationPeriod() {
		Instant now = Instant.now();
		Date expiryDate = Date.from(now.plus(TOKEN_VALIDITY));
		return expiryDate;
	}

	private static void generateSharedKey() {
		SecureRandom random = new SecureRandom();
		random.nextBytes(sharedKey);
	}

	public static User getCurrentUserByToken(String token) {
		try {
			SignedJWT sign = SignedJWT.parse(token);
			JSONObject jsonUser = (JSONObject) sign.getJWTClaimsSet().getClaim("User");
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(jsonUser.toString(), User.class);
			return user;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

}
