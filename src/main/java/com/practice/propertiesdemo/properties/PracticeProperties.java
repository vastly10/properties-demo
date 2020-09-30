package com.practice.propertiesdemo.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@ConfigurationProperties(prefix = "practice.property")
@ConstructorBinding
@Getter
@Validated
public class PracticeProperties {

    @NotNull
    private final String name;
    @NotNull
    private final String id;
    @NotNull
    private final List<String> emails;

    public PracticeProperties(@DefaultValue("default name") String name, String id, List<String> emails) {
        this.name = name;
        this.id = id;
        this.emails = emails;
    }
}
