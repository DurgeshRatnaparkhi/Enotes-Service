package com.becoder.config;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.becoder.audit.AuditAwareConfig;

@Configuration
public class ProjectConfig {

    @Bean
    public ModelMapper Mapper() {
    	
        return new ModelMapper();
    }
    
    
    
    @Bean
	public AuditorAware<Integer> auditAware() {
    	
		return new AuditAwareConfig();
	}

}
