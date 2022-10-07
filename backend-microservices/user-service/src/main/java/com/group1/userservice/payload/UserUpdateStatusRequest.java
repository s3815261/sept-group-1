package com.group1.userservice.payload;

public class UserUpdateStatusRequest {
    private long user_id;

    private String status;

    public UserUpdateStatusRequest(long user_id, String status) {
        this.user_id = user_id;
        this.status = status;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public String getStatus() {
        return this.status;
    }
}
