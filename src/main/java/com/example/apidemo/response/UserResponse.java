package com.example.apidemo.response;

import com.example.apidemo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserResponse {

    private Long id;
    private String name;
    private String description;

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getDescription());
    }

}
