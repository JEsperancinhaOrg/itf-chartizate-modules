package org.jesperancinha.chartizate;

import lombok.Builder;
import org.jesperancinha.chartizate.objects.ColorHelper;

import java.awt.*;
import java.awt.image.BufferedImage;

@Builder
public class ChartizateImageImpl implements ChartizateImage<Color> {

    private BufferedImage srcImage;

    @Override
    public int getImageWidth() {
        return this.srcImage.getWidth();
    }

    @Override
    public int getImageHeight() {
        return this.srcImage.getHeight();
    }

    @Override
    public int getImagePixelRGB(int j, int k) {
        return srcImage.getRGB(j, k);
    }

    @Override
    public Color createColor(ColorHelper colorHelper) {
        return new Color(colorHelper.getRed(),
                colorHelper.getGreen(),
                colorHelper.getBlue(),
                colorHelper.getAlpha());
    }
}
