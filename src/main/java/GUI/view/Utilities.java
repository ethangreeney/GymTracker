package GUI.view;

import java.awt.Color;

public class Utilities {

    public static Color backgroundColour = Color.getHSBColor(0.6f, 0, .9f);

    public static String toHtmlFormat(String s) {
        StringBuilder sb = new StringBuilder("<html><pre><font face='Monospaced'>");
        sb.append(s + "</font></pre></html>");

        return sb.toString();

    }

}
