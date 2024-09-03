package com.javierhernandez.soccerfieldmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

    @Bean
    Cloudinary  cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "daherc5uz",
            "api_key", "525114975655677",
            "api_secret","wYgXNnqj8n8GQz9R5vHMhvxKDXU"

        ));
    }
}
