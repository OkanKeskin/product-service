package com.keskin.productservice.exception.utils;

import com.keskin.productservice.enums.Language;
import com.keskin.productservice.exception.enums.IFriendlyMessageCode;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Slf4j
@UtilityClass
public class FriendlyMessageUtils {
    private static final String RESOURSE_BUNDLE_NAME = "FriendlyMessage";
    private static final String SPECIAL_CHARACTER = "__";

    public static String getFriendlyMessage(Language language, IFriendlyMessageCode messageCode){
        String messageKey = null;
        try{
            Locale locale = new Locale(language.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURSE_BUNDLE_NAME,locale);
            messageKey = messageCode.getClass().getSimpleName() + SPECIAL_CHARACTER + messageCode;
            return resourceBundle.getString(messageKey);
        }
        catch (MissingResourceException e){
            log.error("Friendly Message nont found {}",messageKey);
            return null;
        }

    }

}
