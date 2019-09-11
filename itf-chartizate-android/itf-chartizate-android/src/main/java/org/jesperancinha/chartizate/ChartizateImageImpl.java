package org.jesperancinha.chartizate;

import android.graphics.Bitmap;
import android.graphics.Color;

import org.jesperancinha.chartizate.objects.ColorHelper;


public class ChartizateImageImpl implements ChartizateImage<Integer> {

    private Bitmap bitmap;

    public ChartizateImageImpl(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public int getImageWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getImageHeight() {
        return bitmap.getHeight();
    }

    @Override
    public int getImagePixelRGB(int x, int y) {
        return bitmap.getPixel(x, y);
    }

    @Override
    public Integer createColor(ColorHelper colorHelper) {
        return Color.argb(colorHelper.getAlpha(), colorHelper.getRed(), colorHelper.getGreen(), colorHelper.getBlue());
    }


}
