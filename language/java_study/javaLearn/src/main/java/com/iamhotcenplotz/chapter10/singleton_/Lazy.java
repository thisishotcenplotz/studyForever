package com.iamhotcenplotz.chapter10.singleton_;

public class Lazy {
    public static void main(String[] args) {

        PrettyGirlFriend instance = PrettyGirlFriend.getInstance();
        System.out.println(instance);
    }
}

class PrettyGirlFriend {
    private String name;
    private static PrettyGirlFriend girlFriend;

    private PrettyGirlFriend(String name) {
        this.name = name;
    }

    public static PrettyGirlFriend getInstance() {
        if (girlFriend == null) {
            girlFriend = new PrettyGirlFriend("迪丽热巴");
        }
        return girlFriend;
    }

    @Override
    public String toString() {
        return "PrettyGirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
