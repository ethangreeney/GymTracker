package GUI.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//public utilities class, for setting constants
public class Utilities {

    public static Color backgroundColour = Color.getHSBColor(0.6f, 0, .9f);
    public static Dimension buttonGap = new Dimension(0, 10);

    public static String toHtmlFormat(String s) {
        StringBuilder sb = new StringBuilder("<html><pre><font face='Courier New'>");
        sb.append(s).append("</font></pre></html>");

        return sb.toString();

    }

    public static Dimension topBarGap(JPanel topBar) {
        return new Dimension(Integer.MAX_VALUE, topBar.getPreferredSize().height);
    }

}
