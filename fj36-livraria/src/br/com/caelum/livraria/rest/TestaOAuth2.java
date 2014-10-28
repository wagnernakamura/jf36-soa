/**
 * 
 */
package br.com.caelum.livraria.rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;

/**
 * @author soa4769
 * 
 */
public class TestaOAuth2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String tokenEndpoint = "http://fj36webservicerest-oauthserver.herokuapp.com/oauth/token";

		OAuthClientRequest request;
		try {
			request = OAuthClientRequest.tokenLocation(tokenEndpoint)
					.setGrantType(GrantType.PASSWORD)
					.setClientId("oauth2_client_id")
					.setClientSecret("oauth2_client_secret")
					.setUsername("fake_user").setPassword("passwd")
					.buildBodyMessage();

			OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
			OAuthAccessTokenResponse oauthResponse;

			oauthResponse = oAuthClient.accessToken(request);

			System.out.println("Access token: "
					+ oauthResponse.getAccessToken());
			System.out.println("Expira em: " + oauthResponse.getExpiresIn());

			Client cliente = ClientBuilder.newClient();

			WebTarget target = cliente
					.target(new URI(
							"http://fj36webservicerest-seguro.herokuapp.com/v1/pagamento/1"));

			String entity = target
					.request(MediaType.APPLICATION_XML_TYPE)
					.header("Authorization",
							"Bearer " + oauthResponse.getAccessToken())
					.get(String.class);

			System.out.println("Resposta: " + entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
