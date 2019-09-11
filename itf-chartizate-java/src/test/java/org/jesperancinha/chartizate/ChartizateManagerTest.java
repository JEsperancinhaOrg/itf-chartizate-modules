package org.jesperancinha.chartizate;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
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


public class ChartizateManagerTest {

    @Test
    public void testGenerateConvertedImageStreamCustomColor() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("ChartizateCyanBlack.png");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(new Color(15280682))
                .densityPercentage(50)
                .rangePercentage(10)
                .distributionType(Linear)
                .fontName("Arial")
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testCyanCustom.png")
                .build();

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageStreamCyanBlack() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("ChartizateCyanBlack.png");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLUE)
                .densityPercentage(50)
                .rangePercentage(10)
                .distributionType(Linear)
                .fontName("Arial")
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testCyanBlue.png")
                .build();

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageCyanBlack() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("ChartizateCyanBlack.png");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(50)
                .rangePercentage(10)
                .distributionType(Linear)
                .fontName("Arial")
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testCyanBlue.png")
                .build();

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageLatinRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");

        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName("Times New Roman")
                .fontSize(5)
                .block(LATIN_EXTENDED_A)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testRealExample2Latin.png")
                .build();

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageArabicRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager<Color, Font, BufferedImage> manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName("Times New Roman")
                .fontSize(50)
                .block(ARABIC)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testRealExample2Arabic.png")
                .build();

        final BufferedImage generateConvertedImage = manager.generateConvertedImage();
        manager.saveImage(generateConvertedImage);
    }

    @Test
    public void testGenerateConvertedImageHebrewRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName("Times New Roman")
                .fontSize(20)
                .block(HEBREW)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testRealExample2Hebrew.png")
                .build();
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSyriacRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName("Times New Roman")
                .fontSize(20)
                .block(SYRIAC)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testRealExample2Syriac.png")
                .build();

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSamaritanRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName("Times New Roman")
                .fontSize(20)
                .block(SAMARITAN)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testRealExample2Samaritan.png")
                .build();

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageMandaicRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.BLACK)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName("Times New Roman")
                .fontSize(20)
                .block(MANDAIC)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testRealExample2Mandaic.png")
                .build();

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageThaanaRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();

        final ChartizateManager manager = new ChartizateManagerBuilderImpl()
                .backgroundColor(Color.RED)
                .densityPercentage(100)
                .rangePercentage(100)
                .distributionType(Linear)
                .fontName("Times New Roman")
                .fontSize(20)
                .block(THAANA)
                .imageFullStream(imageFullStream)
                .destinationImagePath("/tmp/testRealExample2Thaana.png")
                .build();

        manager.generateConvertedImage();
    }
}
