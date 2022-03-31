package com.tour.authservice.config;

import java.util.Objects;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

public class OAuthTokenServices extends DefaultTokenServices {
	@Override
	public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {
		OAuth2AccessToken token = super.getAccessToken(authentication);
		try {
			if (Objects.isNull(token) || token.isExpired()) {
				return super.createAccessToken(authentication);
			}
		} catch (DuplicateKeyException dke) {
			token = super.getAccessToken(authentication);
			return token;
		} catch (Exception ex) {
		}
		return token;
	}
}
