package com.nextgate.assesment.jwt;

import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * Class used to bypass password encoding taking plain text password string
 */
public class PasswordEncoderBypass implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}