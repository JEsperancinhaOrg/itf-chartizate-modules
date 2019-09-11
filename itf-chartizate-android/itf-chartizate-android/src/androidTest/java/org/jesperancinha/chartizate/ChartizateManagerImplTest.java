package org.jesperancinha.chartizate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.test.runner.AndroidJUnit4;
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

import static java.lang.Character.UnicodeBlock.ARABIC;
import static java.lang.Character.UnicodeBlock.HEBREW;
import static java.lang.Character.UnicodeBlock.LATIN_EXTENDED_A;
import static java.lang.Character.UnicodeBlock.MANDAIC;
import static java.lang.Character.UnicodeBlock.SAMARITAN;
import static java.lang.Character.UnicodeBlock.SYRIAC;
import static java.lang.Character.UnicodeBlock.THAANA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.chartizate.distributions.ChartizateDistributionType.Linear;

@RunWith(AndroidJUnit4.class)
public class ChartizateManagerImplTest {

    private static final String TIMES_NEW_ROMAN = "Times New Roman";

    private static final String ARIAL = "Arial";

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private File targetFile;

    @Before
    public void setUp() throws IOException {
        targetFile = folder.newFile();
    }

    @Test
    public void testGenerateConvertedImageStreamCustomColor() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);
        assertThat(imageFullStream).isNotNull();
        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(15280682)
                .densityPercentage(50)
                .rangePercentage(10)
                .distributionType(Linear)
                .fontName(ARIAL)
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageStreamCyanBlack() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLUE)
                .densityPercentage(50)
                .rangePercentage(10)
                .distributionType(Linear)
                .fontName(ARIAL)
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageCyanBlack() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(50)
                .rangePercentage(10)
                .distributionType(Linear)
                .fontName(ARIAL)
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageLatinRealExample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName(TIMES_NEW_ROMAN)
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageArabicRealExample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName(TIMES_NEW_ROMAN)
                .fontSize(5)
                .block(ARABIC)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageHebrewRealExample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName(TIMES_NEW_ROMAN)
                .fontSize(20)
                .block(HEBREW)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageSyriacRealExample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName(TIMES_NEW_ROMAN)
                .fontSize(20)
                .block(SYRIAC)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageSamaritanRealExample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName(TIMES_NEW_ROMAN)
                .fontSize(20)
                .block(SAMARITAN)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageMandaicRealExample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName(TIMES_NEW_ROMAN)
                .fontSize(20)
                .block(MANDAIC)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
    }

    @Test
    public void testGenerateConvertedImageThaanaRealExample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Integer, Typeface, Bitmap> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.RED)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName(TIMES_NEW_ROMAN)
                .fontSize(20)
                .block(THAANA)
                .imageFullStream(imageFullStream)
                .destinationImagePath(targetFile.getAbsolutePath())
                .build();

        final Bitmap generateConvertedImage = manager.generateConvertedImage();

        assertThat(generateConvertedImage).isNotNull();
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
