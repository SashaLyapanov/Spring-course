package ru.sashaLy;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "How deeps is your love";
    }
}
