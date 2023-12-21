package utils;

public class XpathUtils {

    public static String parameterXpath(String attributeName, String attributeValue) {
        return "//*[" + attributeName + "='" + attributeValue + "']";
    }
}
