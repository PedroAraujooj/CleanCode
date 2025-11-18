package org.example.tp2;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class E6 {
    public List<Color> getFlagColors(Nationality nationality) {
        return nationality.getFlagColors();
    }
}

enum Nationality {
    GERMAN(Arrays.asList(Color.BLACK, Color.RED, Color.YELLOW)),
    BELGIAN(Arrays.asList(Color.BLACK, Color.YELLOW, Color.RED)),
    FRENCH(Arrays.asList(Color.BLUE, Color.WHITE, Color.RED)),
    ITALIAN(Arrays.asList(Color.GREEN, Color.WHITE, Color.RED)),
    UNCLASSIFIED(Arrays.asList(Color.GRAY));

    private final List<Color> flagColors;

    Nationality(List<Color> flagColors) {
        this.flagColors = flagColors;
    }

    public List<Color> getFlagColors() {
        return flagColors;
    }
}
