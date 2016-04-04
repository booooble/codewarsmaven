import java.util.Arrays;

public class StringHelper {

    /*
    Returns abbreviation of the String input in format: 1st letter + amount of removed letters + last letter.
    Example: "abbreviation-satisfaction yabadabadoo babe" --> "a10n-s10n y9o b2e"
    */
    public static String abbreviate(String string) {
        StringBuilder sb = new StringBuilder();
        try {
            if (string != "") {
                char[] ch = string.replaceAll("[A-Za-z]+", "").toCharArray();
                String[] str = string.split("[ -]+");
                for (int i = 0; i < str.length; i++) {
                    String x = str[i];
                    if (x.length() > 1) {
                        if (string.length() < 3) {
                            sb.append(x);
                        } else {
                            long length = x.length() - 2;
                            sb.append(x.substring(0, 1) + length + x.substring(x.length() - 1));
                        }
                        if (ch.length != 0 && i < ch.length) {
                            sb.append(String.valueOf(ch[i]));
                        }
                    }
                }
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        }
        return sb.toString();
    }

    /*
    Modifies and returns String where each word stars from the capital letter.
    Example: "most trees are blue" -> "Most Trees Are Blue"
    */
    public static String toJadenCase(String phrase) {
        StringBuilder str = new StringBuilder();
        try {
            if (!phrase.equals("")) {
                String[] mas = phrase.split(" ");
                for (String x : mas) {
                    str.append(x.substring(0, 1).toUpperCase() + x.substring(1));
                    if (Arrays.asList(mas).lastIndexOf(x) != mas.length - 1) {
                        str.append(" ");
                    }
                }
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        }
        return str.toString();
    }
}
