package org.jesperancinha.chartizate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;

import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ChartizateImageManagerImpl
        extends ChartizateImageManagerAbstract<Integer, Typeface, Bitmap> {

    private final Bitmap targetBitmap;
    private final Canvas canvas;
    private final Paint paint;
    private final String outputFile;
    private Bitmap bitmap;

    public ChartizateImageManagerImpl(final InputStream inputStream, String outputFile) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ALPHA_8;
        try {
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Exception e) {
            bitmap = null;
            e.printStackTrace();
        }
        srcImage = new ChartizateImageImpl(bitmap);
        this.outputFile = outputFile;
        this.targetBitmap = Bitmap.createBitmap(srcImage.getImageWidth(), srcImage.getImageHeight()
                , Bitmap.Config.RGB_565);
        this.canvas = new Canvas(targetBitmap);
        this.paint = new Paint();
    }


    @Override
    public Bitmap generateBufferedImage(
            ChartizateCharacterImg<Integer>[][] chartizateCharacterImgs,
            ChartizateFontManager<Typeface> chartizateFontManager) {
        paint.setTextSize(chartizateFontManager.getFontSize());
        paint.setTypeface(chartizateFontManager.getFont());
        paint.setColor(chartizateCharacterImgs[0][0].getBg());
        canvas.drawPaint(paint);
        renderRows(chartizateCharacterImgs, chartizateFontManager);
        return targetBitmap;
    }

    @Override
    public void saveBitmap(Bitmap bitmap) throws FileNotFoundException {
        final FileOutputStream out = new FileOutputStream(this.outputFile);
        if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)) {
            Log.i("File", this.outputFile.concat(" is saved"));
        }
    }

    private void renderRows(ChartizateCharacterImg<Integer>[][] chartizateCharacterImgs, ChartizateFontManager<Typeface> chartizateFontManager) {
        for (int i = 0; i < chartizateCharacterImgs.length; i++) {
            int rowLength = chartizateCharacterImgs[i].length;
            renderRow(chartizateCharacterImgs[i], (float) (chartizateFontManager.getFontSize() * (i + 1)), rowLength);
        }
    }

    private void renderRow(ChartizateCharacterImg<Integer>[] row, float y, int rowLength) {
        int currentWidth = 0;
        for (int j = 0; j < rowLength; j++) {
            final ChartizateCharacterImg<Integer> character = row[j];
            paint.setColor(character.getFg());
            canvas.drawText(character.toString(), (float) currentWidth, y, paint);
            currentWidth += row[j].getWidth();
        }
    }
}
