package com.stats.nbastatsbomb.swagger;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        /*name = "Authorization",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer",
        in = SecuritySchemeIn.HEADER
*/
        name = "bearer Auth",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        scheme =  "bearer",
        in = SecuritySchemeIn.HEADER


)
public class OpenAPI30Configuration {
}
