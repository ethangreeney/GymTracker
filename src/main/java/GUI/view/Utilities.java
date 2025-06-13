package GUI.view;

public class Utilities {

    public static String toHtmlFormat(String s) {
        StringBuilder sb = new StringBuilder("<html><pre><font face='Monospaced'>");
        sb.append(s + "</font></pre></html>");

        return sb.toString();

    }

}
