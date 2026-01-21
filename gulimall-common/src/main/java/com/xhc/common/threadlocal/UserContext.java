package com.xhc.common.threadlocal;

import lombok.*;

import java.io.Serializable;

/**
 * 用户请求信息
 *
 * @author 80387245
 * @create 2022/11/10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserContext implements Serializable {

    public static final String USER_TOKEN_HEADER_KEY = "Authorization";
    /**
     * user info 是经过网关，从token解析处理放入进去的， 结构如下
     * {userName:"", userId:""}
     */
    public static final String USER_INFO_HEADER_KEY = "user";

    public static final String USER_NAME_HEADER_KEY = "userName";

    public static final String USER_ID_HEADER_KEY = "userId";

    public static final String ACCEPT_LANGUAGE_HEADER_KEY = "Accept-Language";

    /**
     * TOKEN
     */
    private String token;

    /**
     * username
     */
    private String userName;

    /**
     * userId
     */
    private String userId;

    /**
     * language
     */
    private String language;

    /**
     * user
     */
    private String user;

}