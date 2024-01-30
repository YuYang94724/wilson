package com.java.builder;

public class User {
    private String username;
    private String password;
    private int age;

    // 私有构造函数，通过 Builder 构建实例
    private User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // Getter 方法...

    // 静态内部类 Builder
    public static class Builder {
        private String username;
        private String password;
        private int age;

        // Builder 的构造函数，可以根据需要添加默认值或者必填项
//        public Builder(String username, String password) {
//            this.username = username;
//            this.password = password;
//        }
        public Builder() {}

        // 设置可选项的方法，返回 Builder 实例以支持链式调用
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        // 构建 User 实例的方法
        public User build() {
            // 在此处可以添加构建前的验证逻辑
            return new User(username, password, age);
        }
    }
    @Override
    public String toString() {
        return "User{" +username +" "+ password +" "+ age +"}";
    }
    public static void main(String[] args) {
        User user = new Builder()
                .password("123")
                .age(30)
                .username("test")
                .build();
        System.out.println(user);
    }
}
