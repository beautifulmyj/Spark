package com.apple.chapter06;

public class Scala07_Object_Method_Java {
    public static void main(String[] args) {

        final Class<UserXX> userXXClass = UserXX.class;
    }
}
class UserXX {
    public int id;
    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof UserXX ) {
            UserXX other = (UserXX)obj;
            return this.id == other.id;
        } else {
            return false;
        }
    }
}
