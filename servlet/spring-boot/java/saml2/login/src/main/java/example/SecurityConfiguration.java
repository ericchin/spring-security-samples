package example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Eric Chin
 */
@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain app(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.saml2Metadata(Customizer.withDefaults())
			.authorizeHttpRequests((authorize) -> authorize
				.anyRequest().authenticated()
			)
			.saml2Login(Customizer.withDefaults())
			.saml2Logout(Customizer.withDefaults());
		// @formatter:on

		return http.build();
	}

}
