package nizam.in.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
public class SentryConfig {
	
	public HandlerExceptionResolver sentryExcetionResolver()
	{
		return new io.sentry.spring.SentryExceptionResolver(null, null, 0);
	}

}
