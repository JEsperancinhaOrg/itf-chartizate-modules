package org.jesperancinha.chartizate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * @author joao
 */
public class ChartizateEncodingManagerImpl
        extends ChartizateEncodingManagerAbstract<Typeface>
        implements ChartizateEncodingManager<Typeface> {

    public ChartizateEncodingManagerImpl(Character.UnicodeBlock block, ChartizateFontManager<Typeface> fontManager) {
        super(block, fontManager);
    }

    @Override
    public int getCharacterFullness(Character character) {
        final int width = fontManager.getCharacterWidth(character);
        final int fontSize = fontManager.getFontSize();
        if (width == 0) {
            return 0;
        }
        final Bitmap bitmap = Bitmap.createBitmap(width, fontSize, Bitmap.Config.RGB_565);
        final Canvas canvas = new Canvas(bitmap);
        final Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(fontSize);
        paint.setTypeface(fontManager.getFont());
        canvas.drawPaint(paint);
        paint.setColor(Color.BLACK);
        canvas.drawText(character.toString(), 0, fontSize, paint);
        final int fullPixels = width * fontSize;
        int numberOfOnes = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < fontSize; j++) {
                if (bitmap.getPixel(i, j) == Color.BLACK) {
                    numberOfOnes++;
                }
            }
        }
        return computeFullness(numberOfOnes, fullPixels);
    }

    @Override
    public Character[] getCharacters() {
        return characters;
    }
}