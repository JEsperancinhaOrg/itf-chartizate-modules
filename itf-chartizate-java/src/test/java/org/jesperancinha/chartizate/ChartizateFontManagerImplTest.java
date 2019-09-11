package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import org.junit.Test;

import java.awt.*;
import java.lang.Character.UnicodeBlock;
import java.util.List;

import static java.lang.Character.UnicodeBlock.BASIC_LATIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.chartizate.ChartizateUnicodes.getAllUniCodeBlocksJava;
import static org.junit.Assert.assertArrayEquals;

public class ChartizateFontManagerImplTest {

    @Test
    public void testGetCharacterWidth() {
        final ChartizateFontManagerAbstract<Font> manager = new ChartizateFontManagerImpl("Arial", 10);

        assertThat(manager.getCharacterWidth('a')).isEqualTo(6);
        assertThat(manager.getCharacterWidth('A')).isEqualTo(7);
    }

    @Test
    public void testGetAllUniCodeBlocks() {
        final UnicodeBlock[] testUnicodes = new UnicodeBlock[]{
                BASIC_LATIN,
        };

        final List<UnicodeBlock> result = getAllUniCodeBlocksJava();

        assertThat(result).isNotEmpty();
        assertThat(result).contains(testUnicodes);
    }

    @Test
    public void testGetAllDistributionTypes() {
        final String[] testDistributions = new String[]{
                "Linear",
                "Gaussian",
                "Poisson",
                "Skellam"
        };

        final List<String> result = ChartizateDistributionType.getAllDistributionTypes();

        assertArrayEquals(testDistributions, result.toArray());
    }

    @Test
    public void testGetAllFontTypes() {
        List<String> allFontTypes = ChartizateFontManagerImpl.getAllFontTypes();
        assertThat(allFontTypes).hasAtLeastOneElementOfType(String.class);
    }
}
