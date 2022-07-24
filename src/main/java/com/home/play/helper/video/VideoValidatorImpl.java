package com.home.play.helper.video;

import java.util.List;

import org.springframework.stereotype.Component;

import com.home.play.helper.Exception.HomeException;

@Component
public class VideoValidatorImpl implements VideoValidator{

    @Override
    public void validate(List<String> parts) {
        checkPartsSize(parts);
    }

    private void checkPartsSize(List<String> parts) {
        if(parts.size() != 3) {
            StringBuilder exceptionMessage = new StringBuilder();
            exceptionMessage.append("Invalid video path division at ");
            for (int i = 0; i < parts.size(); i++) {
                exceptionMessage.append(parts.get(i).trim());
                exceptionMessage.append(" ");
            }
            throw new HomeException(exceptionMessage.toString().trim());
        }
    }
    
}
