package src.common.utils;

import src.common.annotations.DisplayName;

public class StringUtils {
    public static String getDisplayName(Class c) {
        if (c.isAnnotationPresent(DisplayName.class)) {
            DisplayName displayName = (DisplayName) c.getAnnotation(DisplayName.class);
            return displayName.value();
        }

        return c.getSimpleName();
    }
}
