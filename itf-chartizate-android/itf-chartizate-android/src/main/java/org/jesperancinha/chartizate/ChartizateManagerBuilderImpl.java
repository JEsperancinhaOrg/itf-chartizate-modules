package org.jesperancinha.chartizate;

import android.graphics.Bitmap;
import android.graphics.Typeface;

import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;

import java.io.IOException;
import java.io.InputStream;

public class ChartizateManagerBuilderImpl extends ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> {

    private int densityPercentage;
    private int rangePercentage;

    private String fontName;
    private ChartizateDistributionType distributionType;
    private InputStream imageFullStream;

    @Override
    public ChartizateImageManager<Integer, Typeface, Bitmap> createImageManager(InputStream inputStream) {
        return new ChartizateImageManagerImpl(inputStream, this.destinationImagePath);
    }

    @Override
    public ChartizateEncodingManager<Typeface> createEncodingManager(Character.UnicodeBlock unicodeBlock) {
        return new ChartizateEncodingManagerImpl(unicodeBlock, fontManager);
    }

    @Override
    public ChartizateFontManager<Typeface> createFontManager(String fontString, int fontSize) {
        return new ChartizateFontManagerImpl(fontString, fontSize);
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> backgroundColor(Integer backgroundColor) {
        this.withBackground(backgroundColor);
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> densityPercentage(int densityPercentage) {
        this.densityPercentage = densityPercentage;
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> rangePercentage(int rangePercentage) {
        this.rangePercentage = rangePercentage;
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> distributionType(ChartizateDistributionType distributionType) {
        this.distributionType = distributionType;
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> fontName(String fontName) {
        this.fontName = fontName;
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> fontSize(int fontSize) {
        this.withFontManager(this.fontName, fontSize);
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> block(Character.UnicodeBlock block) {
        this.withEncodingManager(block);
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> imageFullStream(InputStream imageFullStream) {
        this.imageFullStream = imageFullStream;
        return this;
    }

    @Override
    public ChartizateManagerBuilderAbstract<Integer, Typeface, Bitmap> destinationImagePath(String destinationImagePath) {
        this.withDestinationPath(destinationImagePath);
        return this;
    }

    public ChartizateManager<Integer, Typeface, Bitmap> build() throws IOException {
        this.withDistribution(this.distributionType, this.densityPercentage, this.rangePercentage);
        this.withImageManager(imageFullStream);
        this.withChartizateBoard();
        return ChartizateManagerImpl.<Integer, Typeface, Bitmap>builder()
                .chartizateBoard(super.chartizateBoard)
                .fontManager(this.fontManager)
                .background(this.background)
                .distribution(this.distribution)
                .encodingManager(this.encodingManager)
                .imageManager(this.imageManager)
                .destinationImagePath(this.destinationImagePath)
                .build();
    }
}