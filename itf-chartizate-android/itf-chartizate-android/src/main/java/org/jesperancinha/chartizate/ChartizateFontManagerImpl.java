package org.jesperancinha.chartizate;

import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.Arrays;
import java.util.List;

public class ChartizateFontManagerImpl
        extends ChartizateFontManagerAbstract<Typeface>
        implements ChartizateFontManager<Typeface> {


    private final Paint mPaint;
    private Typeface font;
    private int fontSize;

    public ChartizateFontManagerImpl(String fontString, int fontSize) {
        this.fontSize = fontSize;
        this.font = Typeface.create(fontString.toUpperCase(), Typeface.NORMAL);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setTextSize(fontSize);
        mPaint.setTypeface(this.font);
    }

    public static List<String> getAllFontTypes() {
        return Arrays.asList("Default",
                "Monospace",
                "Sans serif",
                "Serif");
    }

    @Override
    public int getCharacterWidth(char c) {
        return (int) mPaint.measureText(new char[]{c}, 0, 1);
    }

    @Override
    public int getCharacterHeight(char c) {
        return fontSize;
    }

    @Override
    public Typeface getFont() {
        return font;
    }

    @Override
    public int getFontSize() {
        return fontSize;
    }
}
