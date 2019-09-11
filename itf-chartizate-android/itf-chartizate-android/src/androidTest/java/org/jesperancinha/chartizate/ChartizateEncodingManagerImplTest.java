package org.jesperancinha.chartizate;

import junit.framework.TestCase;

/**
 * Created by joaofilipesabinoesperancinha on 11-02-16.
 */
public class ChartizateEncodingManagerImplTest extends TestCase {

    public void testGetCharacterFullness() {
        final ChartizateFontManager fontManager = new ChartizateFontManagerImpl("Default", 10);
        final ChartizateEncodingManager encodingManager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A, fontManager);

        assertEquals(33, encodingManager.getCharacterFullness('.'));
        assertEquals(228, encodingManager.getCharacterFullness('O'));
        assertEquals(216, encodingManager.getCharacterFullness('0'));
    }

}