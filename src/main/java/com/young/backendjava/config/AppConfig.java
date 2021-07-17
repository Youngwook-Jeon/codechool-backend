package com.young.backendjava.config;

import com.young.backendjava.model.response.UserResponse;
import com.young.backendjava.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(UserDto.class, UserResponse.class)
                .addMappings(m -> m.skip(UserResponse::setPosts));
        return modelMapper;
    }
}
