package com.app.cart.configuration;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author Nilesh Sargar
 * @since 20-04-2018
 */

/*
Configuration added to tell servlet that we have custom Context path.
*/

//@Component
public class ContainerConfig{// implements EmbeddedServletContainerCustomizer {
/*
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {

        container.setPort(8087);
        container.setContextPath("/cart");
    }*/

}
