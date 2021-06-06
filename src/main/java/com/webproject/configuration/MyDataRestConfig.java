package com.webproject.configuration;

import com.webproject.entities.ProductCategoryEntity;
import com.webproject.entities.ProductEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
            HttpMethod [] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
            //disable HTTp methods for Product: PUT , POST , DELETE
            config.getExposureConfiguration()
                    .forDomainType(ProductEntity.class)
                    .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                    .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        config.getExposureConfiguration()
                .forDomainType(ProductCategoryEntity.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        }
    }

