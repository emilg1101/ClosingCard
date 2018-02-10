package com.emilg1101.closingcard;

import android.graphics.Color;

/**
 * Created by emilg1101 on 04.02.18.
 * ClosingCard
 * Themes for buttons that can be used
 */

public enum Theme {

    /**
     * White theme
     */
    WHITE(Color.BLACK, Color.WHITE),

    /**
     * Black theme
     */
    BLACK(Color.WHITE, Color.BLACK),


    /**
     * Red theme
     */
    RED(Color.WHITE, Color.RED),

    /**
     * Green theme
     */
    GREEN(Color.WHITE, Color.GREEN),

    /**
     * Blue theme
     */
    BLUE(Color.WHITE, Color.BLUE),

    /**
     * Cyan theme
     */
    CYAN(Color.BLACK, Color.CYAN),

    /**
     * Gray theme
     */
    GRAY(Color.BLACK, Color.GRAY),

    /**
     * Yellow theme
     */
    YELLOW(Color.BLACK, Color.YELLOW);

    protected int textColor;
    protected int backgroundColor;

    /**
     * @param textColor         Button text color
     * @param backgroundColor   Button background color
     */
    Theme(int textColor, int backgroundColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }
}