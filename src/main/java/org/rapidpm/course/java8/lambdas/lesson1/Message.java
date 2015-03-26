package org.rapidpm.course.java8.lambdas.lesson1;

/**
* Created by Sven Ruppert on 01.04.2014.
*/
public class Message {
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
