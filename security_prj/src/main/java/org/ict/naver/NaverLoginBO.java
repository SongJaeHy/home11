package org.ict.naver;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class NaverLoginBO {
	/* 인증 요청문을 구성하는 파라미터*/
	/* client_id: 애플리케이션 등록 후 발급받은 클라이언트 아이디
	 * response_type: 인증 과정에 대한 구분값. code로 값이 고정돼 있습니다.
	 * redirect_uri: callback 주소라고 입력한 곳
	 * 클라이언트 아이디
	 * 클라이언트 비밀번호*/
	private final static String CLIENT_ID = "클라이언트 아이디";
	private final static String CLIENT_SECRET = "클라이언트 비밀번호";
	private final static String REDIRECT_URI = "http://localhost:8181/naver/login";
	private final static String SESSION_STATE = "oauth_state";
	
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";
	
	
	public String getAuthorizationUrl(HttpSession session) {
		
		String state = generateRandomString();
		
		setSession(session, state);
		
		OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI).state(state)
				.build(NaverLoginApi.instance());
		return oauthService.getAuthorizationUrl();
	}
	
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException{
		String sessionState = getSession(session);
		if (StringUtils.pathEquals(sessionState, state)) {
			OAuth20Service oauthService = (new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
					.callback(REDIRECT_URI)).state(state).build(NaverLoginApi.instance());
			
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
			return accessToken;
		}
		return null;
	}
	
	private String generateRandomString() {
		return UUID.randomUUID().toString();
	}
	
	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}
	
	private String getSession(HttpSession session) {
		return (String) session.getAttribute(SESSION_STATE);
	}
	
	public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException{
		OAuth20Service oauthService = new ServiceBuilder()
		.apiKey(CLIENT_ID)
		.apiSecret(CLIENT_SECRET)
		.callback(REDIRECT_URI).build(NaverLoginApi.instance());
		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
		oauthService.signRequest(oauthToken, request);
		Response response = request.send();
		return response.getBody();
	}
	
	
}
