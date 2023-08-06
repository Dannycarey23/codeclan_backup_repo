# Configuring Spring for use with React.js

## Introduction
When working with React.js, the component structure means that the back-end can be configured in a way that makes fetching data a little easier.

When calling a back-end that's on a seperate machine (or even just a different port) we need to configure that back-end to work with "CORS".

### Cross-Origin-Resource-Sharing

In order to call our back-end from a front-end that's running on a separate resource (or server), then we must tell our browser that this is OK. Servers and browsers assume this isn't OK by default as a security precaution to prevent CSFR's (Cross Site Forgery Requests) which is a type of security vulnerability. In short - imagine if a script running on one tab of our browser could send something like this to our bank, that we're logged into in another tab -

```js
fetch('http://onlinebanking.mybank.com`, 
{action: 'TRANSFER', amount: 100000000000, recipient: 'Dr Evil'})
```

## Configure CORS in Spring

With Spring configuring how to handle CORS is just a matter of adding a class that implements the right interfaces. We also need to add the `@Configuration` annotation to make sure the class is picked up by Spring when our application is starting.

If there's not one already, we need a `configs` or `configurations` package. In that create a sensibly named class e.g. `SpringGlobalConfig` (we might do other global setup here). This class will be used to setup CORS to allow calls into our API from any machine.
Ideally, later on or when more is known about who will be calling into your API the CORS settings can be changed to restrict or allow certain hosts.


```java
@Configuration
public class SpringGlobalConfig implements WebMvcConfigurer {

    private static final String CORS_BASE_PATTERN = "/**";
    private static final String ALLOWED_ORIGINS = "*";
    private static final String ALLOWED_HEADERS = "*";
    private static final String ALLOWED_METHODS = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(CORS_BASE_PATTERN)
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedHeaders(ALLOWED_HEADERS)
                .allowedMethods(ALLOWED_METHODS);
    }
}
```
