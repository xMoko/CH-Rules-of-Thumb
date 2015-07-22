/*
 * Copyright (C) 2015 Moko
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package chrulesofthumb;

/**
 *
 * @author Moko
 */
public class RulesOfThumb {
    
    // Empty constructor, we dont need it, al relevant data (siya level) is received in the methods
    public RulesOfThumb() {
    }

    /*
     Calculating Ancients suggested levels (Rules of Thumb)
     */
    // Argaiv
    public int calculateArgaivLevel(int siyaLevel) {
        return siyaLevel;
    }

    // Morgulis
    public int calculateMorgulisLevel(int siyaLevel) {
        // siya^2 + (43.67 * siya) + 33.58
        int morgulisLvl = (int) Math.round(Math.pow(siyaLevel, 2) + (43.67 * siyaLevel) + 33.58);
        return morgulisLvl;
    }

    // Unspent souls
    public int calculateUnspentSouls(int morgulisLevel) {
        // morgulis * 1.1
        int unspentSouls = (int) Math.round(morgulisLevel * 1.1);
        return unspentSouls;
    }

    // Gold (Libertas, Mammon and Mimzee)
    public int calculateGoldLevels(int siyaLevel) {
        // siya * 0.93
        int goldLevel = (int) Math.round(siyaLevel * 0.93);
        return goldLevel;
    }

    // Click (Fragsworth, Bhaal and Pluto)
    public int calculateClickLevels(int siyaLevel) {
        // siya * 0.5
        int clickLevel = (int) Math.round(siyaLevel * 0.5);
        return clickLevel;
    }

    // Juggernaut
    public int calculateJuggernautLevel(int fragsworthLevel) {
        int juggernautLevel = (int) Math.round(fragsworthLevel * 0.2);
        return juggernautLevel;
    }

    // Solomon
    public int calculateSolomonLevel(int siyaLevel, int gameState) {
        /*
         early: siya * 1.0
         mid: siya * 0.75
         late: siya * 0.5
         */
        Double multiplier = 0.0;
        switch (gameState) {
            case 0: // Early
                multiplier = 1.0;
                break;
            case 1: // Mid
                multiplier = 0.75;
                break;
            case 2: // Late   
                multiplier = 0.5;
                break;
        }

        int solomonLevel = (int) Math.round(siyaLevel * multiplier);

        return solomonLevel;
    }

    // Solomon multiplier combobox state changed event, solomon suggested level updated
    public int solomonMultiplierChanged(int siyaLevel, int gameState) {
        return calculateSolomonLevel(siyaLevel, gameState);
        //gui.jFormTxtSolomonLevel.setValue(calculateSolomonLevel());
    }

    // Iris mid
    public int calculateIrisMidLevel(int siyaLevel) {
        // (siya * 0.75) - 300
        int irisMid = (int) Math.round((siyaLevel * 0.75) - 300);
        return irisMid;
    }

    // Iris late
    public int calculateIrisLateLevel(int optimalZone) {
        // optimal zone - 1001
        return optimalZone - 1001;
    }
}