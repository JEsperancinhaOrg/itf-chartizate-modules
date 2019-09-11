package org.jesperancinha.chartizate;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class to manage all fonts
 */
public class ChartizateFonts {

    /**
     * Returns a list of all awt available fonts
     *
     * @return List of all available Fonts
     */
    public static List<String> getAllAvailableFonts() {
        return Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
    }
}
