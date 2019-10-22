package com.susanibar.david.footballapi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilTest {
    public static void main(String[] args) {
        String s = "You reached your request limit. Wait 46 seconds.";
        Pattern p = Pattern.compile("(?<=Wait )\\d+");
        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}
