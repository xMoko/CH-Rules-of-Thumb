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

import java.util.HashMap;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Moko
 */
public class TargetCostCalculator {
    
    // Empty constructor, we dont need, relevant data is received on the methods
    public TargetCostCalculator(){        
    }

    /*
     Calculating ancients target level hero soul cost
     */
    // Siyalatas, Argaiv, Gold (Libertas, Mammon and Mimzee) and Click (Fragsworth, Bhaal and Pluto) -> same formula for them all
    public int calculateSimilars(int currentLevel, int targetLevel) {

        int HSCost = 0;
        for (int x = currentLevel; x < targetLevel; x++) {
            HSCost += x + 1;
        }
        return HSCost;
    }

    // Morgulis
    public int calculateTargetMorgulisHSCost(int currentLevel, int targetLevel) {

        int HSCost = 0;
        for (int x = currentLevel; x < targetLevel; x++) {
            HSCost++;
        }
        return HSCost;        
    }
    
    // Solomon and Iris (same formula)
    public int calculateTargetSolomonIrisHSCost(int currentLevel, int targetLevel) {

        int HSCost = 0;
        for (int x = currentLevel; x < targetLevel; x++) {
            HSCost += Math.round(Math.pow(x + 1, 1.5));
        }
        
        return HSCost;
    }

    // All ancients target level total HS cost
    public int calculateTargetHSCost(HashMap<String, JFormattedTextField> targetCosts, String[] ancientNames) {
        int totalTargetHSCost = 0;
        for (int x = 0; x < targetCosts.size(); x++) {
            totalTargetHSCost += (int) targetCosts.get(ancientNames[x]).getValue();
        }
        
        return totalTargetHSCost;
    }
}
