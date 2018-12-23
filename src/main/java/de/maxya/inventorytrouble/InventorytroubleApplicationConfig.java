package de.maxya.inventorytrouble;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InventorytroubleApplicationConfig {

        @Bean
        public CommonsRequestLoggingFilter logFilter() {
            CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
            filter.setIncludeQueryString(true);
            filter.setIncludePayload(true);
            filter.setMaxPayloadLength(10000);
            filter.setIncludeHeaders(false);
            filter.setAfterMessagePrefix("REQUEST DATA : ");
            return filter;
        }

        @SuppressWarnings("deprecation")
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").exposedHeaders(HttpHeaders.ETAG, HttpHeaders.LOCATION, HttpHeaders.LINK, "Total-Items")
                            .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS", "HEAD")
                            .allowedHeaders(HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.CONTENT_LANGUAGE,
                                    HttpHeaders.ACCEPT, HttpHeaders.ACCEPT_LANGUAGE, HttpHeaders.ACCEPT_LANGUAGE,
                                    HttpHeaders.IF_MATCH, HttpHeaders.IF_NONE_MATCH)
                            .allowCredentials(true);
                }
            };
        }

        @Bean
        public MessageSource messageSource() {
            ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
            messageSource.setBasename("classpath:i18n/messages");
            messageSource.setDefaultEncoding("UTF-8");
            return messageSource;
        }

}