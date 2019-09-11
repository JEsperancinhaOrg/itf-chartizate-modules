package org.jesperancinha.chartizate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.test.runner.AndroidJUnit4;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImgImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@RunWith(AndroidJUnit4.class)
public class ChartizateImageManagerImplTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private File targetFile;

    @Before
    public void setUp() throws IOException {
        targetFile = folder.newFile();
    }

    @Test
    public void testgetImageAverageColorBlackGreen() {
        final InputStream io = getByteArrayInputStreamFromResource(R.raw.chartizateblackgreen);

        final ChartizateImageManager<Integer, Typeface, Bitmap> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Integer imageAverageInteger = imageManager.getImageAverageColor();
        assertThat(imageAverageInteger).isEqualTo(-13788928);
    }

    @Test
    public void testgetImageAverageColorCyanBlack() {
        final InputStream io = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);

        final ChartizateImageManager<Integer, Typeface, Bitmap> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Integer imageAverageInteger = imageManager.getImageAverageColor();

        assertThat(imageAverageInteger).isEqualTo(-16742778);
    }

    @Test
    public void testGetPartAverageIntegerCyanBlack00() {
        final InputStream io = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);

        final ChartizateImageManager<Integer, Typeface, Bitmap> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Integer partAverageInteger = imageManager.getPartAverageColor(0, 0, 10, 10);

        assertThat(partAverageInteger).isEqualTo(-16728129);
    }

    @Test
    public void testGetPartAverageIntegerCyanBlack10() {
        final InputStream io = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);

        final ChartizateImageManager<Integer, Typeface, Bitmap> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());

        final Integer partAverageInteger = imageManager.getPartAverageColor(10, 0, 19, 10);
        assertThat(partAverageInteger).isEqualTo(-16759226);
    }

    @Test
    public void testSaveImage() {
        final InputStream io = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);
        final ChartizateImageManager<Integer, Typeface, Bitmap> imageManager = new ChartizateImageManagerImpl(io, targetFile.getAbsolutePath());
        final ChartizateCharacterImg<Integer>[][] chartizateCharacterImgs = new ChartizateCharacterImg[2][];
        chartizateCharacterImgs[0] = new ChartizateCharacterImg[]{
                new ChartizateCharacterImgImpl<>(Color.GREEN, Color.RED, 10, 'A'),
                new ChartizateCharacterImgImpl<>(Color.BLACK, Color.RED, 10, 'B')
        };
        chartizateCharacterImgs[1] = new ChartizateCharacterImg[]{
                new ChartizateCharacterImgImpl<>(Color.BLUE, Color.YELLOW, 10, 'C'),
                new ChartizateCharacterImgImpl<>(Color.YELLOW, Color.GREEN, 10, 'D')
        };
        final ChartizateFontManager<Typeface> fontManager = new ChartizateFontManagerImpl("Arial", 10);

        assertDoesNotThrow(() -> {
            final Bitmap bufferedImage = imageManager.generateBufferedImage(chartizateCharacterImgs, fontManager);
            imageManager.saveBitmap(bufferedImage);
        });
    }

    private ByteArrayInputStream getByteArrayInputStreamFromResource(int resource) {
        final Context appContext = androidx.test.InstrumentationRegistry.getTargetContext();
        final Drawable drawable = appContext.getDrawable(resource);
        assertThat(drawable).isNotNull();
        final Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
        final byte[] bitmapdata = bos.toByteArray();
        return new ByteArrayInputStream(bitmapdata);
    }
}
