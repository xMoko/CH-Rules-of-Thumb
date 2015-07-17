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

//TODO pass suggested lvls as target lvls

package chrulesofthumb;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


/**
 *
 * @author xMoko
 */
public final class RulesOfThumb extends javax.swing.JFrame {

    /**
     * Creates new form RulesOfThumb
     */
    
    HashMap<String, JFormattedTextField> targetLvlCostsFields;
    
    HashMap<String, JSpinner> currentLvlSpinnerFields;
    HashMap<String, JSpinner> targetLvlSpinnerFields;   
    
    final String ancientNames[] = new String[]{"Siyalatas", "Argaiv", "Morgulis", 
                                                "Libertas", "Mammon", "Mimzee",
                                                "Fragsworth", "Bhaal", "Pluto",
                                                "Juggernaut", "Solomon", "Iris"};
    
    public RulesOfThumb() {
        // Initialize UI components
        initComponents();
        
        // Initialize HashMap
        initHashMaps();       
        
        jLabMorgulis.setEnabled(false);
        jFormTxtMorgulisLevel.setEnabled(false);
        
        // We set the frame to center
        setLocationRelativeTo(null);
        
        // Frame size
        setSize(1010, 610);
        
        // Frame icon
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        
        // We start showing a starting value
        showAncientLevels();
        
        loadAncientsData();
    }
    
    // Init hashmap
    private void initHashMaps() {
        targetLvlCostsFields = new HashMap<>();
        targetLvlCostsFields.put("Siyalatas", jFormTxtSiyaHSCost);
        targetLvlCostsFields.put("Argaiv", jFormTxtArgaivHSCost);
        targetLvlCostsFields.put("Morgulis", jFormTxtMorgulisHSCost);
        targetLvlCostsFields.put("Libertas", jFormTxtLibertasHSCost);
        targetLvlCostsFields.put("Mammon", jFormTxtMammonHSCost);
        targetLvlCostsFields.put("Mimzee", jFormTxtMimzeeHSCost);
        targetLvlCostsFields.put("Fragsworth", jFormTxtFragsworthHSCost);
        targetLvlCostsFields.put("Bhaal", jFormTxtBhaalHSCost);
        targetLvlCostsFields.put("Pluto", jFormTxtPlutoHSCost);
        targetLvlCostsFields.put("Juggernaut", jFormTxtJuggernautHSCost);
        targetLvlCostsFields.put("Solomon", jFormTxtSolomonHSCost);
        targetLvlCostsFields.put("Iris", jFormTxtIrisHSCost);        
        
        currentLvlSpinnerFields = new HashMap<>();
        currentLvlSpinnerFields.put("Siyalatas", jSpinnerSiyaCurrentLvl);
        currentLvlSpinnerFields.put("Argaiv", jSpinnerArgaivCurrentLvl);
        currentLvlSpinnerFields.put("Morgulis", jSpinnerMorgulisCurrentLvl);
        currentLvlSpinnerFields.put("Libertas", jSpinnerLibertasCurrentLvl);
        currentLvlSpinnerFields.put("Mammon", jSpinnerMammonCurrentLvl);
        currentLvlSpinnerFields.put("Mimzee", jSpinnerMimzeeCurrentLvl);
        currentLvlSpinnerFields.put("Fragsworth", jSpinnerFragsworthCurrentLvl);
        currentLvlSpinnerFields.put("Bhaal", jSpinnerBhaalCurrentLvl);
        currentLvlSpinnerFields.put("Pluto", jSpinnerPlutoCurrentLvl);
        currentLvlSpinnerFields.put("Juggernaut", jSpinnerJuggernautCurrentLvl);
        currentLvlSpinnerFields.put("Solomon", jSpinnerSolomonCurrentLvl);
        currentLvlSpinnerFields.put("Iris", jSpinnerIrisCurrentLvl);
        
        targetLvlSpinnerFields = new HashMap<>();
        targetLvlSpinnerFields.put("Siyalatas", jSpinnerSiyaTargetLvl);
        targetLvlSpinnerFields.put("Argaiv", jSpinnerArgaivTargetLvl);
        targetLvlSpinnerFields.put("Morgulis", jSpinnerMorgulisTargetLvl);
        targetLvlSpinnerFields.put("Libertas", jSpinnerLibertasTargetLvl);
        targetLvlSpinnerFields.put("Mammon", jSpinnerMammonTargetLvl);
        targetLvlSpinnerFields.put("Mimzee", jSpinnerMimzeeTargetLvl);
        targetLvlSpinnerFields.put("Fragsworth", jSpinnerFragsworthTargetLvl);
        targetLvlSpinnerFields.put("Bhaal", jSpinnerBhaalTargetLvl);
        targetLvlSpinnerFields.put("Pluto", jSpinnerPlutoTargetLvl);
        targetLvlSpinnerFields.put("Juggernaut", jSpinnerJuggernautTargetLvl);
        targetLvlSpinnerFields.put("Solomon", jSpinnerSolomonTargetLvl);
        targetLvlSpinnerFields.put("Iris", jSpinnerIrisTargetLvl);       
    }

    /*
        Showing Ancient's levels
    */
    public void showAncientLevels(){
        jFormTxtArgaivLevel.setValue(calculateArgaivLevel());
        jFormTxtMorgulisLevel.setValue(calculateMorgulisLevel());
        jFormTxtUnspentSouls.setValue(calculateUnspentSouls());
        jFormTxtLibertasLevel.setValue(calculateGoldLevels());
        jFormTxtMammonLevel.setValue(calculateGoldLevels());
        jFormTxtMimzeeLevel.setValue(calculateGoldLevels());
        jFormTxtFragsworthLevel.setValue(calculateClickLevels());
        jFormTxtBhaalLevel.setValue(calculateClickLevels());
        jFormTxtPlutoLevel.setValue(calculateClickLevels());
        jFormTxtJuggernautLevel.setValue(calculateJuggernautLevel());
        jFormTxtSolomonLevel.setValue(calculateSolomonLevel());
        jFormTxtIrisMidLevel.setValue(calculateIrisMidLevel());
        jFormTxtIrisLateLevel.setValue(calculateIrisLateLevel());
    }

    
    /*
        Calculating Ancients suggested levels (Rules of Thumb)
    */
    
    // Argaiv
    public int calculateArgaivLevel(){
        return Integer.parseInt(jSpinnerSiyaLvl.getValue().toString());
    }
    
    // Morgulis
    public int calculateMorgulisLevel(){        
        // siya^2 + (43.67 * siya) + 33.58
        int morgulisLvl = (int) Math.round(Math.pow(Integer.parseInt(jSpinnerSiyaLvl.getValue().toString()), 2) + (43.67 * Integer.parseInt(jSpinnerSiyaLvl.getValue().toString())) + 33.58);
        return morgulisLvl;               
    }
    
    // Unspent souls
    public int calculateUnspentSouls(){
        // morgulis * 1.1
        int unspentSouls = (int) Math.round(Double.parseDouble(jFormTxtMorgulisLevel.getValue().toString())  * 1.1);
        return unspentSouls;
    }
    
    // Gold (Libertas, Mammon and Mimzee)
    public int calculateGoldLevels(){
        // siya * 0.93
        int goldLevel = (int) Math.round(Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * 0.93);
        return goldLevel;
    }
    
    // Click (Fragsworth, Bhaal and Pluto)
    public int calculateClickLevels(){
        // siya * 0.5
        int clickLevel = (int) Math.round(Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * 0.5);        
        return clickLevel;
    }
    
    // Juggernaut
    public int calculateJuggernautLevel(){
        int juggernautLevel = (int) Math.round(calculateClickLevels() * 0.2);
        return juggernautLevel;
    }     
    
    // Solomon
    public int calculateSolomonLevel(){
        /*
        early: siya * 1.0
        mid: siya * 0.75
        late: siya * 0.5
        */
        Double multiplier = 0.0;
        switch(jComboBoxGameState.getSelectedIndex()){
            case 0:
                multiplier = 1.0;
                break;
            case 1:
                multiplier = 0.75;
                break;
            case 2:   
                multiplier = 0.5;
                break;
        }
        
        int solomonLevel = (int) Math.round(Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * multiplier);
        
        return solomonLevel;
    }
    
    // Solomon multiplier combobox state changed event, solomon suggested level updated
    public void solomonMultiplierChanged(java.awt.event.ActionEvent evt){
        jFormTxtSolomonLevel.setValue(calculateSolomonLevel());
    }
    
    // Iris (mid)
    public int calculateIrisMidLevel(){
        // (siya * 0.75) - 300
        int irisMid = (int) Math.round((Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * 0.75) - 300);
        return irisMid;
    }
    
    // Iris (late)
    public int calculateIrisLateLevel(){
        // optimal zone - 1001
        return Integer.parseInt(jSpinnerOptZone.getValue().toString()) - 1001;
    }
    
    /*
        Calculating ancients target level hero soul cost
    */
    
    // Siyalatas, Argaiv, Gold (Libertas, Mammon and Mimzee) and Click (Fragsworth, Bhaal and Pluto) -> same formula for them all
    private void calculateSimilars(String ancient){
        int currentLvl = (int) currentLvlSpinnerFields.get(ancient).getValue();
        int targetLvl = (int) targetLvlSpinnerFields.get(ancient).getValue();    
        
        int HSCost = 0;
        for (int x = currentLvl; x < targetLvl; x++) {
            HSCost += x + 1;
        }
        targetLvlCostsFields.get(ancient).setValue(HSCost);
    }
    
    // Morgulis
    private void calculateTargetMorgulisHSCost(String ancient){
        int currentLvl = (int) currentLvlSpinnerFields.get(ancient).getValue();
        int targetLvl = (int) targetLvlSpinnerFields.get(ancient).getValue();

        int HSCost = 0;
        for (int x = currentLvl; x < targetLvl; x++) {
            HSCost++;
        }
        targetLvlCostsFields.get(ancient).setValue(HSCost);
    }

    // Solomon and Iris (same formula)
    private void calculateTargetSolomonIrisHSCost(String ancient){
        int currentLvl = (int) currentLvlSpinnerFields.get(ancient).getValue();
        int targetLvl = (int) targetLvlSpinnerFields.get(ancient).getValue();           
        
        int HSCost = 0;
        for (int x = currentLvl; x < targetLvl; x++) {
            HSCost += Math.round(Math.pow(x + 1, 1.5));
        }
        targetLvlCostsFields.get(ancient).setValue(HSCost);
    }     
    
    // All ancients target total HS cost
    private void calculateTargetHSCost(){
        int totalTargetHSCost = 0;
        for(int x = 0; x < targetLvlCostsFields.size(); x++){            
            totalTargetHSCost += (int) targetLvlCostsFields.get(ancientNames[x]).getValue();
        }
        jFormTxtTotalHSCost.setValue(totalTargetHSCost);
    }
    
    /*
        Other stuff
    */
    
    // Hide/unhide morgulis/unspent souls components
    private void haveMorgulis() {
        if (jChkBoxHaveMorgulis.isSelected()) {
            jLabUnspentSouls.setEnabled(false);
            jFormTxtUnspentSouls.setEnabled(false);
            jLabMorgulis.setEnabled(true);
            jFormTxtMorgulisLevel.setEnabled(true);
        } else {
            jLabUnspentSouls.setEnabled(true);
            jFormTxtUnspentSouls.setEnabled(true);
            jLabMorgulis.setEnabled(false);
            jFormTxtMorgulisLevel.setEnabled(false);
        }
    }
    
    // Show credits
    private void showCredits() {
        JEditorPane jep = new JEditorPane();
        jep.setContentType("text/html");//set content as html
        jep.setText("This a basic app to calculate ancients level based on /u/Awlcer \"Rules of Thumb\". <br>"
                + "All credits goes to him and everyone who contributed to build the ROT, go check it: <br>"
                + "<br>"
                + "<a href='http://redd.it/339m3j'>http://redd.it/339m3j</a> <br>"
                + "<br>"
                + "Also, thanks to /u/XG549 who made the spreadsheet this app/layout is based on: <br>"
                + "<br>"
                + "<a href='http://redd.it/3cwhl2'>http://redd.it/3cwhl2</a>");

        jep.setEditable(false);//so its not editable
        //jep.setOpaque(false);//so we dont see whit background

        jep.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(hle.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        JOptionPane.showMessageDialog(this, jep);
    }
    
    // Show ROT about gilds/regilds
    private void showROTGildRegild() {
        JOptionPane.showMessageDialog(this, "These are rough references on when gilding should take place. These values are often used by community members, "
                + "\n and may or may not be the most optimal.\n"
                + "\n"
                + "Zone 300-499:\n"
                + "    * Should have gilds in the early efficient heroes (Treebeast, Ivan, Brit, Sam, and Seer).\n"
                + "\n"
                + "Zone 500+:\n"
                + "    * Should around now have or be looking for Argaiv, once a player does they should move gilds to Masked Samurai.\n"
                + "\n"
                + "Masked Samurai 2500+:\n"
                + "    * If instantly killing through Sam level 2500+ one should regild to Atlas.\n"
                + "\n"
                + "Ranger 1500+:\n"
                + "    * At this stage once you're instantly killing through ranger level 1500+ one should regild to the next ranger (Atlas>Terra>Phthalo>Banana>Etc). ",
                "Gilds and Regilds", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Save ancients data
    private void saveAncientsData() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("ancients.data");

            // set the properties value
            for (int x = 0; x < currentLvlSpinnerFields.size(); x++) {
                prop.setProperty(ancientNames[x], currentLvlSpinnerFields.get(ancientNames[x]).getValue().toString());
            }

            // save properties to project root folder
            prop.store(output, null);
            JOptionPane.showMessageDialog(this, "Data successfully saved.", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // Load ancients data
    private void loadAncientsData() {
        Properties prop = new Properties();
        InputStream input = null;
        File file = new File("ancients.data");
        if (file.exists()) {
            try {

                input = new FileInputStream("ancients.data");

                // load a properties file                
                prop.load(input);
                
                for(int x = 0; x < currentLvlSpinnerFields.size(); x++){
                    currentLvlSpinnerFields.get(ancientNames[x]).setValue(Integer.parseInt(prop.getProperty(ancientNames[x])));
                    targetLvlSpinnerFields.get(ancientNames[x]).setValue(Integer.parseInt(prop.getProperty(ancientNames[x])));
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButShowCredits = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButShowGildsROT = new javax.swing.JButton();
        jLabCHImage = new javax.swing.JLabel();
        jLabAncientsImage = new javax.swing.JLabel();
        jTabRulesOfThumb = new javax.swing.JTabbedPane();
        jPanelRulesOfThumb = new javax.swing.JPanel();
        jLabSiyaLvl = new javax.swing.JLabel();
        jSpinnerSiyaLvl = new javax.swing.JSpinner();
        jSeparatorStart = new javax.swing.JSeparator();
        jLabArgaiv = new javax.swing.JLabel();
        jLabMorgulis = new javax.swing.JLabel();
        jLabUnspentSouls = new javax.swing.JLabel();
        jLabLibertas = new javax.swing.JLabel();
        jLabMammon = new javax.swing.JLabel();
        jLabMimzee = new javax.swing.JLabel();
        jLabFragsworth = new javax.swing.JLabel();
        jLabBhaal = new javax.swing.JLabel();
        jLabPluto = new javax.swing.JLabel();
        jLabJuggernaut = new javax.swing.JLabel();
        jLabSolomon = new javax.swing.JLabel();
        jLabGameState = new javax.swing.JLabel();
        jComboBoxGameState = new javax.swing.JComboBox();
        jLabIrisMid = new javax.swing.JLabel();
        jLabIrisLate = new javax.swing.JLabel();
        jFormTxtArgaivLevel = new javax.swing.JFormattedTextField();
        jFormTxtMorgulisLevel = new javax.swing.JFormattedTextField();
        jFormTxtUnspentSouls = new javax.swing.JFormattedTextField();
        jFormTxtLibertasLevel = new javax.swing.JFormattedTextField();
        jFormTxtMammonLevel = new javax.swing.JFormattedTextField();
        jFormTxtMimzeeLevel = new javax.swing.JFormattedTextField();
        jFormTxtJuggernautLevel = new javax.swing.JFormattedTextField();
        jFormTxtSolomonLevel = new javax.swing.JFormattedTextField();
        jFormTxtIrisMidLevel = new javax.swing.JFormattedTextField();
        jFormTxtIrisLateLevel = new javax.swing.JFormattedTextField();
        jFormTxtFragsworthLevel = new javax.swing.JFormattedTextField();
        jFormTxtBhaalLevel = new javax.swing.JFormattedTextField();
        jFormTxtPlutoLevel = new javax.swing.JFormattedTextField();
        jLabOptZone = new javax.swing.JLabel();
        jSpinnerOptZone = new javax.swing.JSpinner();
        jChkBoxHaveMorgulis = new javax.swing.JCheckBox();
        jPanelTotalHSCosts = new javax.swing.JPanel();
        jSpinnerSiyaTargetLvl = new javax.swing.JSpinner();
        jSpinnerSiyaCurrentLvl = new javax.swing.JSpinner();
        jLabSiyaCurrentLvl = new javax.swing.JLabel();
        jLabArgaivCurrentLvl = new javax.swing.JLabel();
        jLabMorgulisCurrentLvl = new javax.swing.JLabel();
        jLabLibertasLevel = new javax.swing.JLabel();
        jLabMammonCurrentLvl = new javax.swing.JLabel();
        jLabSolomonCurrentLvl = new javax.swing.JLabel();
        jLabIrisCurrentLvl = new javax.swing.JLabel();
        jSpinnerArgaivCurrentLvl = new javax.swing.JSpinner();
        jSpinnerMorgulisCurrentLvl = new javax.swing.JSpinner();
        jSpinnerLibertasCurrentLvl = new javax.swing.JSpinner();
        jSpinnerMammonCurrentLvl = new javax.swing.JSpinner();
        jSpinnerSolomonCurrentLvl = new javax.swing.JSpinner();
        jSpinnerIrisCurrentLvl = new javax.swing.JSpinner();
        jLabCurrentLvlColumn = new javax.swing.JLabel();
        jLabSiyaToTargetLvl = new javax.swing.JLabel();
        jLabTargetLvlColumn = new javax.swing.JLabel();
        jFormTxtSiyaHSCost = new javax.swing.JFormattedTextField();
        jLabHSCost = new javax.swing.JLabel();
        jLabSiyaToHSCost = new javax.swing.JLabel();
        jLabArgaivToTargetLvl = new javax.swing.JLabel();
        jLabMorgulisToTargetLvl = new javax.swing.JLabel();
        jLabLibertasToTargettLvl = new javax.swing.JLabel();
        jLabToMammonTargetLvl = new javax.swing.JLabel();
        jLabSolomonToTargetLvl = new javax.swing.JLabel();
        jLabIrisToTargetLvl = new javax.swing.JLabel();
        jLabArgaivToHSCost = new javax.swing.JLabel();
        jLabMorgulisToHSCost = new javax.swing.JLabel();
        jLabLibertasToHSCost = new javax.swing.JLabel();
        jLabMammonToHSCost = new javax.swing.JLabel();
        jLabSolomonToHSCost = new javax.swing.JLabel();
        jLabIrisToHSCost = new javax.swing.JLabel();
        jSpinnerArgaivTargetLvl = new javax.swing.JSpinner();
        jSpinnerMorgulisTargetLvl = new javax.swing.JSpinner();
        jSpinnerLibertasTargetLvl = new javax.swing.JSpinner();
        jSpinnerMammonTargetLvl = new javax.swing.JSpinner();
        jSpinnerSolomonTargetLvl = new javax.swing.JSpinner();
        jSpinnerIrisTargetLvl = new javax.swing.JSpinner();
        jFormTxtArgaivHSCost = new javax.swing.JFormattedTextField();
        jFormTxtMorgulisHSCost = new javax.swing.JFormattedTextField();
        jFormTxtLibertasHSCost = new javax.swing.JFormattedTextField();
        jFormTxtMammonHSCost = new javax.swing.JFormattedTextField();
        jFormTxtSolomonHSCost = new javax.swing.JFormattedTextField();
        jFormTxtIrisHSCost = new javax.swing.JFormattedTextField();
        jLabTotalHSCost = new javax.swing.JLabel();
        jLabToTotalHSCost = new javax.swing.JLabel();
        jFormTxtTotalHSCost = new javax.swing.JFormattedTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabMimzeeCurrentLvl = new javax.swing.JLabel();
        jSpinnerMimzeeCurrentLvl = new javax.swing.JSpinner();
        jLabMimzeeToTargetLvl = new javax.swing.JLabel();
        jSpinnerMimzeeTargetLvl = new javax.swing.JSpinner();
        jLabMimzeeToHSCost = new javax.swing.JLabel();
        jFormTxtMimzeeHSCost = new javax.swing.JFormattedTextField();
        jLabFragsworthCurrentLvl = new javax.swing.JLabel();
        jSpinnerFragsworthCurrentLvl = new javax.swing.JSpinner();
        jLabFragsworthToTargetLvl = new javax.swing.JLabel();
        jSpinnerFragsworthTargetLvl = new javax.swing.JSpinner();
        jLabFragsworthToHSCost = new javax.swing.JLabel();
        jFormTxtFragsworthHSCost = new javax.swing.JFormattedTextField();
        jLabBhaalCurrentLvl = new javax.swing.JLabel();
        jSpinnerBhaalCurrentLvl = new javax.swing.JSpinner();
        jLabBhaalToTargetLvl = new javax.swing.JLabel();
        jSpinnerBhaalTargetLvl = new javax.swing.JSpinner();
        jLabBhaalToHSCost = new javax.swing.JLabel();
        jFormTxtBhaalHSCost = new javax.swing.JFormattedTextField();
        jLabPlutoCurrentLvl = new javax.swing.JLabel();
        jSpinnerPlutoCurrentLvl = new javax.swing.JSpinner();
        jLabPlutoToTargetLvl = new javax.swing.JLabel();
        jSpinnerPlutoTargetLvl = new javax.swing.JSpinner();
        jLabPlutoToHSCost = new javax.swing.JLabel();
        jFormTxtPlutoHSCost = new javax.swing.JFormattedTextField();
        jButSaveAncientsData = new javax.swing.JButton();
        jLabJuggernautCurrentLvl = new javax.swing.JLabel();
        jSpinnerJuggernautCurrentLvl = new javax.swing.JSpinner();
        jLabJuggernatutToTargetLvl = new javax.swing.JLabel();
        jSpinnerJuggernautTargetLvl = new javax.swing.JSpinner();
        jLabJuggernautToHSCost = new javax.swing.JLabel();
        jFormTxtJuggernautHSCost = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clicker Heroes Rules of Thumb - app v1.5");
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButShowCredits.setText("Credits");
        jButShowCredits.setFocusable(false);
        jButShowCredits.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButShowCredits.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButShowCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCreditsActionEvent(evt);
            }
        });
        jToolBar1.add(jButShowCredits);
        jToolBar1.add(jSeparator1);

        jButShowGildsROT.setText("ROT: Gilds and Regilding");
        jButShowGildsROT.setFocusable(false);
        jButShowGildsROT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButShowGildsROT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButShowGildsROT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showROTGildRegildActionEvent(evt);
            }
        });
        jToolBar1.add(jButShowGildsROT);

        jLabCHImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/header.jpg"))); // NOI18N

        jLabAncientsImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ancients.png"))); // NOI18N

        jPanelRulesOfThumb.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        /*JScrollPane test = new JScrollPane(jPanelRulesOfThumb);
        test.setViewportView(jPanelRulesOfThumb);
        jTabRulesOfThumb.addTab("Rules of Thumb", test);*/

        jLabSiyaLvl.setText("Siyalatas Level");

        jSpinnerSiyaLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                showAncientLevels();
            }
        });
        jSpinnerSiyaLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabArgaiv.setText("Argaiv");

        jLabMorgulis.setText("Morgulis");

        jLabUnspentSouls.setText("Unspent souls");
        jLabUnspentSouls.setToolTipText("If no Morgulis");

        jLabLibertas.setText("Libertas");

        jLabMammon.setText("Mammon");

        jLabMimzee.setText("Mimzee");

        jLabFragsworth.setText("Fragsworth");

        jLabBhaal.setText("Bhaal");

        jLabPluto.setText("Pluto");

        jLabJuggernaut.setText("Juggernaut");

        jLabSolomon.setText("Solomon");

        jLabGameState.setText("Choose");

        jComboBoxGameState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Early: Gilds before Atlas", "Mid: Gilds between Atlas and Orntchya\t", "Late: Gilds from Lilin and on" }));
        jComboBoxGameState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solomonMultiplierChanged(evt);
            }
        });

        jLabIrisMid.setText("Iris Mid");

        jLabIrisLate.setText("Iris Late");

        jFormTxtArgaivLevel.setEditable(false);
        jFormTxtArgaivLevel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormTxtArgaivLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtMorgulisLevel.setEditable(false);
        jFormTxtMorgulisLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtUnspentSouls.setEditable(false);
        jFormTxtUnspentSouls.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtLibertasLevel.setEditable(false);
        jFormTxtLibertasLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtMammonLevel.setEditable(false);
        jFormTxtMammonLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtMimzeeLevel.setEditable(false);
        jFormTxtMimzeeLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtJuggernautLevel.setEditable(false);
        jFormTxtJuggernautLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtSolomonLevel.setEditable(false);
        jFormTxtSolomonLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtIrisMidLevel.setEditable(false);
        jFormTxtIrisMidLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtIrisLateLevel.setEditable(false);
        jFormTxtIrisLateLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtFragsworthLevel.setEditable(false);
        jFormTxtFragsworthLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtBhaalLevel.setEditable(false);
        jFormTxtBhaalLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jFormTxtPlutoLevel.setEditable(false);
        jFormTxtPlutoLevel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabOptZone.setText("Op. Zone");

        jSpinnerOptZone.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerOptZone.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                jFormTxtIrisLateLevel.setValue(calculateIrisLateLevel());
            }

        });

        jChkBoxHaveMorgulis.setText("Check if you have Morgulis");
        jChkBoxHaveMorgulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haveMorgulisActionEvent(evt);
            }
        });

        javax.swing.GroupLayout jPanelRulesOfThumbLayout = new javax.swing.GroupLayout(jPanelRulesOfThumb);
        jPanelRulesOfThumb.setLayout(jPanelRulesOfThumbLayout);
        jPanelRulesOfThumbLayout.setHorizontalGroup(
            jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorStart)
                    .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabArgaiv)
                            .addComponent(jLabMorgulis)
                            .addComponent(jLabUnspentSouls)
                            .addComponent(jLabLibertas)
                            .addComponent(jLabMammon)
                            .addComponent(jLabMimzee)
                            .addComponent(jLabJuggernaut)
                            .addComponent(jLabSolomon)
                            .addComponent(jLabIrisMid)
                            .addComponent(jLabIrisLate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormTxtArgaivLevel)
                            .addComponent(jFormTxtMorgulisLevel)
                            .addComponent(jFormTxtUnspentSouls)
                            .addComponent(jFormTxtLibertasLevel)
                            .addComponent(jFormTxtMammonLevel)
                            .addComponent(jFormTxtMimzeeLevel)
                            .addComponent(jFormTxtJuggernautLevel)
                            .addComponent(jFormTxtSolomonLevel)
                            .addComponent(jFormTxtIrisMidLevel)
                            .addComponent(jFormTxtIrisLateLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkBoxHaveMorgulis)
                            .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                                .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabFragsworth)
                                    .addComponent(jLabBhaal)
                                    .addComponent(jLabPluto)
                                    .addComponent(jLabGameState)
                                    .addComponent(jLabOptZone))
                                .addGap(7, 7, 7)
                                .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxGameState, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormTxtFragsworthLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerOptZone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jFormTxtBhaalLevel, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFormTxtPlutoLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))))
                    .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                        .addComponent(jLabSiyaLvl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerSiyaLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelRulesOfThumbLayout.setVerticalGroup(
            jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabSiyaLvl)
                    .addComponent(jSpinnerSiyaLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorStart, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabArgaiv)
                            .addComponent(jFormTxtArgaivLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChkBoxHaveMorgulis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabMorgulis)
                            .addComponent(jFormTxtMorgulisLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabUnspentSouls)
                            .addComponent(jFormTxtUnspentSouls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabLibertas)
                            .addComponent(jFormTxtLibertasLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabMammon)
                            .addComponent(jFormTxtMammonLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabMimzee)
                            .addComponent(jFormTxtMimzeeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabJuggernaut)
                            .addComponent(jFormTxtJuggernautLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabSolomon)
                            .addComponent(jFormTxtSolomonLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabIrisMid)
                            .addComponent(jFormTxtIrisMidLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormTxtIrisLateLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabIrisLate)))
                    .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabFragsworth)
                            .addComponent(jFormTxtFragsworthLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabBhaal)
                            .addComponent(jFormTxtBhaalLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabPluto)
                            .addComponent(jFormTxtPlutoLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabGameState)
                            .addComponent(jComboBoxGameState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabOptZone)
                            .addComponent(jSpinnerOptZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        jTabRulesOfThumb.addTab("Rules of Thumb", jPanelRulesOfThumb);

        jPanelTotalHSCosts.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jSpinnerSiyaTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Siyalatas");
                calculateTargetHSCost();
            }
        });
        jSpinnerSiyaTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerSiyaCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabSiyaCurrentLvl.setText("Siyalatas");

        jLabArgaivCurrentLvl.setText("Argaiv");

        jLabMorgulisCurrentLvl.setText("Morgulis");

        jLabLibertasLevel.setText("Libertas");
        jLabLibertasLevel.setToolTipText("The calculation is the same for Libertas, Mammon and Mimzee");

        jLabMammonCurrentLvl.setText("Mammon");
        jLabMammonCurrentLvl.setToolTipText("The calculation is the same for Fragsworth, Pluto and Bhaal");

        jLabSolomonCurrentLvl.setText("Solomon");

        jLabIrisCurrentLvl.setText("Iris");

        jSpinnerArgaivCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerMorgulisCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerLibertasCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerMammonCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerSolomonCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerIrisCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabCurrentLvlColumn.setText("Current level");

        jLabSiyaToTargetLvl.setText(">>>");

        jLabTargetLvlColumn.setText("Target level");

        jFormTxtSiyaHSCost.setEditable(false);
        jFormTxtSiyaHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtSiyaHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtSiyaHSCost.setValue(0);

        jLabHSCost.setText("Hero Souls cost");

        jLabSiyaToHSCost.setText(">>>");

        jLabArgaivToTargetLvl.setText(">>>");

        jLabMorgulisToTargetLvl.setText(">>>");

        jLabLibertasToTargettLvl.setText(">>>");

        jLabToMammonTargetLvl.setText(">>>");

        jLabSolomonToTargetLvl.setText(">>>");

        jLabIrisToTargetLvl.setText(">>>");

        jLabArgaivToHSCost.setText(">>>");

        jLabMorgulisToHSCost.setText(">>>");

        jLabLibertasToHSCost.setText(">>>");

        jLabMammonToHSCost.setText(">>>");

        jLabSolomonToHSCost.setText(">>>");

        jLabIrisToHSCost.setText(">>>");

        jSpinnerArgaivTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Argaiv");
                calculateTargetHSCost();
            }
        });
        jSpinnerArgaivTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerMorgulisTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateTargetMorgulisHSCost("Morgulis");
                calculateTargetHSCost();
            }
        });
        jSpinnerMorgulisTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerLibertasTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Libertas");
                calculateTargetHSCost();
            }
        });
        jSpinnerLibertasTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerMammonTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Mammon");
                calculateTargetHSCost();
            }
        });
        jSpinnerMammonTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerSolomonTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateTargetSolomonIrisHSCost("Solomon");
                calculateTargetHSCost();
            }
        });
        jSpinnerSolomonTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jSpinnerIrisTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateTargetSolomonIrisHSCost("Iris");
                calculateTargetHSCost();
            }
        });
        jSpinnerIrisTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jFormTxtArgaivHSCost.setEditable(false);
        jFormTxtArgaivHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtArgaivHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtArgaivHSCost.setValue(0);

        jFormTxtMorgulisHSCost.setEditable(false);
        jFormTxtMorgulisHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtMorgulisHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtMorgulisHSCost.setValue(0);

        jFormTxtLibertasHSCost.setEditable(false);
        jFormTxtLibertasHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtLibertasHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtLibertasHSCost.setValue(0);

        jFormTxtMammonHSCost.setEditable(false);
        jFormTxtMammonHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtMammonHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtMammonHSCost.setValue(0);

        jFormTxtSolomonHSCost.setEditable(false);
        jFormTxtSolomonHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtSolomonHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtSolomonHSCost.setValue(0);

        jFormTxtIrisHSCost.setEditable(false);
        jFormTxtIrisHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtIrisHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtIrisHSCost.setValue(0);

        jLabTotalHSCost.setText("Total Hero Souls cost");

        jLabToTotalHSCost.setText(">>>");

        jFormTxtTotalHSCost.setEditable(false);
        jFormTxtTotalHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtTotalHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtTotalHSCost.setValue(0);

        jLabMimzeeCurrentLvl.setText("Mimzee");

        jSpinnerMimzeeCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabMimzeeToTargetLvl.setText(">>>");

        jSpinnerMimzeeTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Mimzee");
                calculateTargetHSCost();
            }
        });
        jSpinnerMimzeeTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabMimzeeToHSCost.setText(">>>");

        jFormTxtMimzeeHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtMimzeeHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtMimzeeHSCost.setValue(0);

        jLabFragsworthCurrentLvl.setText("Fragsworth");

        jSpinnerFragsworthCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabFragsworthToTargetLvl.setText(">>>");

        jSpinnerFragsworthTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Fragsworth");
                calculateTargetHSCost();
            }
        });
        jSpinnerFragsworthTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabFragsworthToHSCost.setText(">>>");

        jFormTxtFragsworthHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtFragsworthHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtFragsworthHSCost.setValue(0);

        jLabBhaalCurrentLvl.setText("Bhaal");

        jSpinnerBhaalCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabBhaalToTargetLvl.setText(">>>");

        jSpinnerBhaalTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Bhaal");
                calculateTargetHSCost();
            }
        });
        jSpinnerBhaalTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabBhaalToHSCost.setText(">>>");

        jFormTxtBhaalHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtBhaalHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtBhaalHSCost.setValue(0);

        jLabPlutoCurrentLvl.setText("Pluto");

        jSpinnerPlutoCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabPlutoToTargetLvl.setText(">>>");

        jSpinnerPlutoTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateSimilars("Pluto");
                calculateTargetHSCost();
            }
        });
        jSpinnerPlutoTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabPlutoToHSCost.setText(">>>");

        jFormTxtPlutoHSCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        jFormTxtPlutoHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtPlutoHSCost.setValue(0);

        jButSaveAncientsData.setText("Save data");
        jButSaveAncientsData.setToolTipText("Saves the current ancient level, so that current levels are loaded upon program start");
        jButSaveAncientsData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAncientsDataActionEvent(evt);
            }
        });

        jLabJuggernautCurrentLvl.setText("Jugger");

        jSpinnerJuggernautCurrentLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabJuggernatutToTargetLvl.setText(">>>");

        jSpinnerJuggernautTargetLvl.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                calculateTargetSolomonIrisHSCost("Juggernaut");
                calculateTargetHSCost();
            }
        });
        jSpinnerJuggernautTargetLvl.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabJuggernautToHSCost.setText(">>>");

        jFormTxtJuggernautHSCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormTxtJuggernautHSCost.setValue(0);

        javax.swing.GroupLayout jPanelTotalHSCostsLayout = new javax.swing.GroupLayout(jPanelTotalHSCosts);
        jPanelTotalHSCosts.setLayout(jPanelTotalHSCostsLayout);
        jPanelTotalHSCostsLayout.setHorizontalGroup(
            jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                            .addComponent(jLabTotalHSCost)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabToTotalHSCost)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jFormTxtTotalHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabSiyaCurrentLvl)
                                                        .addComponent(jLabArgaivCurrentLvl)
                                                        .addComponent(jLabMorgulisCurrentLvl)
                                                        .addComponent(jLabLibertasLevel)
                                                        .addComponent(jLabMammonCurrentLvl)
                                                        .addComponent(jLabFragsworthCurrentLvl)
                                                        .addComponent(jLabBhaalCurrentLvl)
                                                        .addComponent(jLabPlutoCurrentLvl))
                                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabCurrentLvlColumn)
                                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jSpinnerMimzeeCurrentLvl, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSpinnerSiyaCurrentLvl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                                        .addComponent(jSpinnerArgaivCurrentLvl, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSpinnerMorgulisCurrentLvl, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSpinnerLibertasCurrentLvl, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSpinnerMammonCurrentLvl, javax.swing.GroupLayout.Alignment.LEADING))
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabSiyaToTargetLvl)
                                                                        .addComponent(jLabArgaivToTargetLvl)
                                                                        .addComponent(jLabMorgulisToTargetLvl)
                                                                        .addComponent(jLabLibertasToTargettLvl)
                                                                        .addComponent(jLabToMammonTargetLvl)
                                                                        .addComponent(jLabMimzeeToTargetLvl)))
                                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                                    .addComponent(jSpinnerFragsworthCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabFragsworthToTargetLvl))))
                                                        .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                            .addGap(138, 138, 138)
                                                            .addComponent(jLabPlutoToTargetLvl))))
                                                .addComponent(jLabMimzeeCurrentLvl))
                                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabTargetLvlColumn)
                                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jSpinnerSiyaTargetLvl, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                                        .addComponent(jSpinnerArgaivTargetLvl)
                                                                        .addComponent(jSpinnerMorgulisTargetLvl)
                                                                        .addComponent(jSpinnerLibertasTargetLvl)
                                                                        .addComponent(jSpinnerMammonTargetLvl))
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabArgaivToHSCost)
                                                                        .addComponent(jLabSiyaToHSCost)
                                                                        .addComponent(jLabMorgulisToHSCost)
                                                                        .addComponent(jLabLibertasToHSCost)
                                                                        .addComponent(jLabMammonToHSCost))))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabHSCost)
                                                                .addComponent(jFormTxtSiyaHSCost, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                                .addComponent(jFormTxtArgaivHSCost)
                                                                .addComponent(jFormTxtMorgulisHSCost)
                                                                .addComponent(jFormTxtLibertasHSCost)
                                                                .addComponent(jFormTxtMammonHSCost)))
                                                        .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jSpinnerFragsworthTargetLvl, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jSpinnerMimzeeTargetLvl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                                    .addComponent(jLabMimzeeToHSCost)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jFormTxtMimzeeHSCost))
                                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                                    .addComponent(jLabFragsworthToHSCost)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jFormTxtFragsworthHSCost))))))
                                                .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                                    .addGap(138, 138, 138)
                                                    .addComponent(jLabPlutoToHSCost)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jFormTxtPlutoHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jButSaveAncientsData, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabSolomonCurrentLvl)
                                            .addComponent(jLabIrisCurrentLvl))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSpinnerSolomonCurrentLvl, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(jSpinnerIrisCurrentLvl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabSolomonToTargetLvl)
                                            .addComponent(jLabIrisToTargetLvl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSpinnerSolomonTargetLvl, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(jSpinnerIrisTargetLvl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabSolomonToHSCost)
                                            .addComponent(jLabIrisToHSCost))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jFormTxtSolomonHSCost)
                                            .addComponent(jFormTxtIrisHSCost)))
                                    .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                        .addComponent(jLabJuggernautCurrentLvl)
                                        .addGap(321, 321, 321)
                                        .addComponent(jLabJuggernautToHSCost)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormTxtJuggernautHSCost))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTotalHSCostsLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSpinnerPlutoTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSpinnerPlutoCurrentLvl, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(jSpinnerBhaalCurrentLvl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabBhaalToTargetLvl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerBhaalTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelTotalHSCostsLayout.createSequentialGroup()
                                .addComponent(jSpinnerJuggernautCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabJuggernatutToTargetLvl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerJuggernautTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabBhaalToHSCost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormTxtBhaalHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanelTotalHSCostsLayout.setVerticalGroup(
            jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalHSCostsLayout.createSequentialGroup()
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabCurrentLvlColumn)
                    .addComponent(jLabTargetLvlColumn)
                    .addComponent(jLabHSCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerSiyaTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabSiyaCurrentLvl)
                    .addComponent(jSpinnerSiyaCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabSiyaToTargetLvl)
                    .addComponent(jFormTxtSiyaHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabSiyaToHSCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabArgaivCurrentLvl)
                    .addComponent(jSpinnerArgaivCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabArgaivToTargetLvl)
                    .addComponent(jLabArgaivToHSCost)
                    .addComponent(jSpinnerArgaivTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormTxtArgaivHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabMorgulisCurrentLvl)
                    .addComponent(jSpinnerMorgulisCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabMorgulisToTargetLvl)
                    .addComponent(jLabMorgulisToHSCost)
                    .addComponent(jSpinnerMorgulisTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormTxtMorgulisHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabLibertasLevel)
                    .addComponent(jSpinnerLibertasCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabLibertasToTargettLvl)
                    .addComponent(jLabLibertasToHSCost)
                    .addComponent(jSpinnerLibertasTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormTxtLibertasHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabMammonCurrentLvl)
                    .addComponent(jSpinnerMammonCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabToMammonTargetLvl)
                    .addComponent(jLabMammonToHSCost)
                    .addComponent(jSpinnerMammonTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormTxtMammonHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabMimzeeCurrentLvl)
                    .addComponent(jSpinnerMimzeeCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabMimzeeToTargetLvl)
                    .addComponent(jSpinnerMimzeeTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabMimzeeToHSCost)
                    .addComponent(jFormTxtMimzeeHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabFragsworthCurrentLvl)
                    .addComponent(jSpinnerFragsworthCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabFragsworthToTargetLvl)
                    .addComponent(jSpinnerFragsworthTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabFragsworthToHSCost)
                    .addComponent(jFormTxtFragsworthHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabBhaalCurrentLvl)
                    .addComponent(jSpinnerBhaalCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabBhaalToTargetLvl)
                    .addComponent(jSpinnerBhaalTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabBhaalToHSCost)
                    .addComponent(jFormTxtBhaalHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabPlutoCurrentLvl)
                    .addComponent(jSpinnerPlutoCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabPlutoToTargetLvl)
                    .addComponent(jSpinnerPlutoTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabPlutoToHSCost)
                    .addComponent(jFormTxtPlutoHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabJuggernautCurrentLvl)
                    .addComponent(jSpinnerJuggernautCurrentLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabJuggernatutToTargetLvl)
                    .addComponent(jSpinnerJuggernautTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabJuggernautToHSCost)
                    .addComponent(jFormTxtJuggernautHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerSolomonCurrentLvl)
                    .addComponent(jLabSolomonCurrentLvl)
                    .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabSolomonToTargetLvl)
                        .addComponent(jLabSolomonToHSCost)
                        .addComponent(jSpinnerSolomonTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormTxtSolomonHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabIrisCurrentLvl)
                    .addComponent(jLabIrisToTargetLvl)
                    .addComponent(jLabIrisToHSCost)
                    .addComponent(jSpinnerIrisTargetLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormTxtIrisHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerIrisCurrentLvl))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormTxtTotalHSCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabTotalHSCost)
                    .addComponent(jLabToTotalHSCost)
                    .addComponent(jButSaveAncientsData))
                .addContainerGap())
        );

        jTabRulesOfThumb.addTab("Ancient target level HS total cost", jPanelTotalHSCosts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabRulesOfThumb, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabAncientsImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabCHImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabRulesOfThumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(jLabCHImage)
                        .addGap(18, 18, 18)
                        .addComponent(jLabAncientsImage)
                        .addGap(50, 50, 50))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void haveMorgulisActionEvent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haveMorgulisActionEvent
        haveMorgulis();
    }//GEN-LAST:event_haveMorgulisActionEvent

    private void showCreditsActionEvent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCreditsActionEvent
        showCredits();
    }//GEN-LAST:event_showCreditsActionEvent
    
    private void showROTGildRegildActionEvent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showROTGildRegildActionEvent
        showROTGildRegild();
    }//GEN-LAST:event_showROTGildRegildActionEvent

    private void saveAncientsDataActionEvent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAncientsDataActionEvent
        saveAncientsData();        
    }//GEN-LAST:event_saveAncientsDataActionEvent

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RulesOfThumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RulesOfThumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RulesOfThumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RulesOfThumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RulesOfThumb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButSaveAncientsData;
    private javax.swing.JButton jButShowCredits;
    private javax.swing.JButton jButShowGildsROT;
    private javax.swing.JCheckBox jChkBoxHaveMorgulis;
    private javax.swing.JComboBox jComboBoxGameState;
    private javax.swing.JFormattedTextField jFormTxtArgaivHSCost;
    private javax.swing.JFormattedTextField jFormTxtArgaivLevel;
    private javax.swing.JFormattedTextField jFormTxtBhaalHSCost;
    private javax.swing.JFormattedTextField jFormTxtBhaalLevel;
    private javax.swing.JFormattedTextField jFormTxtFragsworthHSCost;
    private javax.swing.JFormattedTextField jFormTxtFragsworthLevel;
    private javax.swing.JFormattedTextField jFormTxtIrisHSCost;
    private javax.swing.JFormattedTextField jFormTxtIrisLateLevel;
    private javax.swing.JFormattedTextField jFormTxtIrisMidLevel;
    private javax.swing.JFormattedTextField jFormTxtJuggernautHSCost;
    private javax.swing.JFormattedTextField jFormTxtJuggernautLevel;
    private javax.swing.JFormattedTextField jFormTxtLibertasHSCost;
    private javax.swing.JFormattedTextField jFormTxtLibertasLevel;
    private javax.swing.JFormattedTextField jFormTxtMammonHSCost;
    private javax.swing.JFormattedTextField jFormTxtMammonLevel;
    private javax.swing.JFormattedTextField jFormTxtMimzeeHSCost;
    private javax.swing.JFormattedTextField jFormTxtMimzeeLevel;
    private javax.swing.JFormattedTextField jFormTxtMorgulisHSCost;
    private javax.swing.JFormattedTextField jFormTxtMorgulisLevel;
    private javax.swing.JFormattedTextField jFormTxtPlutoHSCost;
    private javax.swing.JFormattedTextField jFormTxtPlutoLevel;
    private javax.swing.JFormattedTextField jFormTxtSiyaHSCost;
    private javax.swing.JFormattedTextField jFormTxtSolomonHSCost;
    private javax.swing.JFormattedTextField jFormTxtSolomonLevel;
    private javax.swing.JFormattedTextField jFormTxtTotalHSCost;
    private javax.swing.JFormattedTextField jFormTxtUnspentSouls;
    private javax.swing.JLabel jLabAncientsImage;
    private javax.swing.JLabel jLabArgaiv;
    private javax.swing.JLabel jLabArgaivCurrentLvl;
    private javax.swing.JLabel jLabArgaivToHSCost;
    private javax.swing.JLabel jLabArgaivToTargetLvl;
    private javax.swing.JLabel jLabBhaal;
    private javax.swing.JLabel jLabBhaalCurrentLvl;
    private javax.swing.JLabel jLabBhaalToHSCost;
    private javax.swing.JLabel jLabBhaalToTargetLvl;
    private javax.swing.JLabel jLabCHImage;
    private javax.swing.JLabel jLabCurrentLvlColumn;
    private javax.swing.JLabel jLabFragsworth;
    private javax.swing.JLabel jLabFragsworthCurrentLvl;
    private javax.swing.JLabel jLabFragsworthToHSCost;
    private javax.swing.JLabel jLabFragsworthToTargetLvl;
    private javax.swing.JLabel jLabGameState;
    private javax.swing.JLabel jLabHSCost;
    private javax.swing.JLabel jLabIrisCurrentLvl;
    private javax.swing.JLabel jLabIrisLate;
    private javax.swing.JLabel jLabIrisMid;
    private javax.swing.JLabel jLabIrisToHSCost;
    private javax.swing.JLabel jLabIrisToTargetLvl;
    private javax.swing.JLabel jLabJuggernatutToTargetLvl;
    private javax.swing.JLabel jLabJuggernaut;
    private javax.swing.JLabel jLabJuggernautCurrentLvl;
    private javax.swing.JLabel jLabJuggernautToHSCost;
    private javax.swing.JLabel jLabLibertas;
    private javax.swing.JLabel jLabLibertasLevel;
    private javax.swing.JLabel jLabLibertasToHSCost;
    private javax.swing.JLabel jLabLibertasToTargettLvl;
    private javax.swing.JLabel jLabMammon;
    private javax.swing.JLabel jLabMammonCurrentLvl;
    private javax.swing.JLabel jLabMammonToHSCost;
    private javax.swing.JLabel jLabMimzee;
    private javax.swing.JLabel jLabMimzeeCurrentLvl;
    private javax.swing.JLabel jLabMimzeeToHSCost;
    private javax.swing.JLabel jLabMimzeeToTargetLvl;
    private javax.swing.JLabel jLabMorgulis;
    private javax.swing.JLabel jLabMorgulisCurrentLvl;
    private javax.swing.JLabel jLabMorgulisToHSCost;
    private javax.swing.JLabel jLabMorgulisToTargetLvl;
    private javax.swing.JLabel jLabOptZone;
    private javax.swing.JLabel jLabPluto;
    private javax.swing.JLabel jLabPlutoCurrentLvl;
    private javax.swing.JLabel jLabPlutoToHSCost;
    private javax.swing.JLabel jLabPlutoToTargetLvl;
    private javax.swing.JLabel jLabSiyaCurrentLvl;
    private javax.swing.JLabel jLabSiyaLvl;
    private javax.swing.JLabel jLabSiyaToHSCost;
    private javax.swing.JLabel jLabSiyaToTargetLvl;
    private javax.swing.JLabel jLabSolomon;
    private javax.swing.JLabel jLabSolomonCurrentLvl;
    private javax.swing.JLabel jLabSolomonToHSCost;
    private javax.swing.JLabel jLabSolomonToTargetLvl;
    private javax.swing.JLabel jLabTargetLvlColumn;
    private javax.swing.JLabel jLabToMammonTargetLvl;
    private javax.swing.JLabel jLabToTotalHSCost;
    private javax.swing.JLabel jLabTotalHSCost;
    private javax.swing.JLabel jLabUnspentSouls;
    private javax.swing.JPanel jPanelRulesOfThumb;
    private javax.swing.JPanel jPanelTotalHSCosts;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparatorStart;
    private javax.swing.JSpinner jSpinnerArgaivCurrentLvl;
    private javax.swing.JSpinner jSpinnerArgaivTargetLvl;
    private javax.swing.JSpinner jSpinnerBhaalCurrentLvl;
    private javax.swing.JSpinner jSpinnerBhaalTargetLvl;
    private javax.swing.JSpinner jSpinnerFragsworthCurrentLvl;
    private javax.swing.JSpinner jSpinnerFragsworthTargetLvl;
    private javax.swing.JSpinner jSpinnerIrisCurrentLvl;
    private javax.swing.JSpinner jSpinnerIrisTargetLvl;
    private javax.swing.JSpinner jSpinnerJuggernautCurrentLvl;
    private javax.swing.JSpinner jSpinnerJuggernautTargetLvl;
    private javax.swing.JSpinner jSpinnerLibertasCurrentLvl;
    private javax.swing.JSpinner jSpinnerLibertasTargetLvl;
    private javax.swing.JSpinner jSpinnerMammonCurrentLvl;
    private javax.swing.JSpinner jSpinnerMammonTargetLvl;
    private javax.swing.JSpinner jSpinnerMimzeeCurrentLvl;
    private javax.swing.JSpinner jSpinnerMimzeeTargetLvl;
    private javax.swing.JSpinner jSpinnerMorgulisCurrentLvl;
    private javax.swing.JSpinner jSpinnerMorgulisTargetLvl;
    private javax.swing.JSpinner jSpinnerOptZone;
    private javax.swing.JSpinner jSpinnerPlutoCurrentLvl;
    private javax.swing.JSpinner jSpinnerPlutoTargetLvl;
    private javax.swing.JSpinner jSpinnerSiyaCurrentLvl;
    private javax.swing.JSpinner jSpinnerSiyaLvl;
    private javax.swing.JSpinner jSpinnerSiyaTargetLvl;
    private javax.swing.JSpinner jSpinnerSolomonCurrentLvl;
    private javax.swing.JSpinner jSpinnerSolomonTargetLvl;
    private javax.swing.JTabbedPane jTabRulesOfThumb;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
