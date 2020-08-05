package org.kurolek.demo.springboot.demoecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.kurolek.demo.springboot.demoecommerce.entity.Role;

@Data
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {
    public String name;
    private String password;
    public Long roleId;
    public Role role;
}
