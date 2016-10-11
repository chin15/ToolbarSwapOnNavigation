package com.dblackker.toolbarhello;

public class User {
    private String profileImageUrl;
    private String name;
    private String email;

    public User(String profileImageUrl, String name, String email) {
        this.profileImageUrl = profileImageUrl;
        this.name = name;
        this.email = email;
    }

    public User(Builder builder) {
        this.profileImageUrl = builder.profileImageUrl;
        this.name = builder.name;
        this.email = builder.email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String profileImageUrl;
        private String name;
        private String email;

        public Builder setProfileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
