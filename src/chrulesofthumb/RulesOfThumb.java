/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrulesofthumb;

import java.awt.Desktop;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
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
    public RulesOfThumb() {
        initComponents();
        jLabMorgulis.setEnabled(false);
        jFormTxtMorgulisLevel.setEnabled(false);
        setLocationRelativeTo(null);
        setSize(1010, 565);
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        showAncientLevels();
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
        Calculating stuff
    */
    
    // Argaiv
    public int calculateArgaivLevel(){
        return Integer.parseInt(jSpinnerSiyaLvl.getValue().toString());
    }
    
    // Morgulis
    public int calculateMorgulisLevel(){        
        //siya^2+(43.67*siya)+33.58
        Double morgulisLvl = Math.pow(Integer.parseInt(jSpinnerSiyaLvl.getValue().toString()), 2) + (43.67 * Integer.parseInt(jSpinnerSiyaLvl.getValue().toString())) + 33.58;
        return morgulisLvl.intValue();               
    }
    
    // Unspent souls
    public int calculateUnspentSouls(){
        Double unspentSouls = Double.parseDouble(jFormTxtMorgulisLevel.getValue().toString())  * 1.1;
        return unspentSouls.intValue();
    }
    
    // Gold (Libertas, Mammon and Mimzee)
    public int calculateGoldLevels(){
        Double goldLevel = Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * 0.93;
        return goldLevel.intValue();
    }
    
    // Click (Fragsworth, Bhaal and Pluto)
    public int calculateClickLevels(){
        Double clickLevel = Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * 0.5;        
        return clickLevel.intValue();
    }
    
    // Juggernaut
    public int calculateJuggernautLevel(){
        Double juggernautLevel = calculateClickLevels() * 0.2;
        return juggernautLevel.intValue();
    }     
    
    // Solomon
    public int calculateSolomonLevel(){
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
        
        Double solomonLevel = Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * multiplier;
        
        return solomonLevel.intValue();
    }
    
    public void solomonMultiplierChanged(java.awt.event.ActionEvent evt){
        jFormTxtSolomonLevel.setValue(calculateSolomonLevel());
    }
    
    // Iris (mid)
    public int calculateIrisMidLevel(){
        Double irisMid = (Double.parseDouble(jSpinnerSiyaLvl.getValue().toString()) * 0.75) - 300;
        return irisMid.intValue();
    }
    
    // Iris (late)
    public int calculateIrisLateLevel(){
        return Integer.parseInt(jSpinnerOptZone.getValue().toString()) - 1001;
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
        jButCalculateTargerSiyaCost = new javax.swing.JButton();
        jLabTargetSiya = new javax.swing.JLabel();
        jSpinnerTargetSiya = new javax.swing.JSpinner();
        jPanelTotalHSCosts = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clicker Heroes Rules of Thumb - app v1.4");
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButShowCredits.setText("Credits");
        jButShowCredits.setFocusable(false);
        jButShowCredits.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButShowCredits.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButShowCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCredits(evt);
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
                showROTGildRegild(evt);
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
                haveMorgulis(evt);
            }
        });

        jButCalculateTargerSiyaCost.setText("Calculate");
        jButCalculateTargerSiyaCost.setToolTipText("Calculates total Hero Soul cost from current Siya level to target Siya level");
        jButCalculateTargerSiyaCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateTargetSiyaHSCost(evt);
            }
        });

        jLabTargetSiya.setText("Target Siya");

        jSpinnerTargetSiya.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

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
                                            .addComponent(jFormTxtBhaalLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jFormTxtPlutoLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinnerOptZone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                                .addComponent(jLabSiyaLvl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerSiyaLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabTargetSiya)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerTargetSiya)
                                .addGap(18, 18, 18)
                                .addComponent(jButCalculateTargerSiyaCost)))
                        .addContainerGap())))
        );
        jPanelRulesOfThumbLayout.setVerticalGroup(
            jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRulesOfThumbLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRulesOfThumbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabSiyaLvl)
                    .addComponent(jSpinnerSiyaLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButCalculateTargerSiyaCost)
                    .addComponent(jLabTargetSiya)
                    .addComponent(jSpinnerTargetSiya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanelTotalHSCostsLayout = new javax.swing.GroupLayout(jPanelTotalHSCosts);
        jPanelTotalHSCosts.setLayout(jPanelTotalHSCostsLayout);
        jPanelTotalHSCostsLayout.setHorizontalGroup(
            jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        jPanelTotalHSCostsLayout.setVerticalGroup(
            jPanelTotalHSCostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jTabRulesOfThumb.addTab("Ancients target HS cost", jPanelTotalHSCosts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabRulesOfThumb, javax.swing.GroupLayout.PREFERRED_SIZE, 555, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabRulesOfThumb, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabCHImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabAncientsImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void haveMorgulis(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haveMorgulis
        if(jChkBoxHaveMorgulis.isSelected()){
            jLabUnspentSouls.setEnabled(false);
            jFormTxtUnspentSouls.setEnabled(false);
            jLabMorgulis.setEnabled(true);
            jFormTxtMorgulisLevel.setEnabled(true);
        }else{
            jLabUnspentSouls.setEnabled(true);
            jFormTxtUnspentSouls.setEnabled(true);
            jLabMorgulis.setEnabled(false);
            jFormTxtMorgulisLevel.setEnabled(false);
        }
    }//GEN-LAST:event_haveMorgulis

    // Show credits
    private void showCredits(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCredits
        
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
    }//GEN-LAST:event_showCredits

    // Show ROT about gilds/regilds
    private void showROTGildRegild(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showROTGildRegild
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
    }//GEN-LAST:event_showROTGildRegild

    // Get total HS cost to level Siyalatas from current level to target level
    private void calculateTargetSiyaHSCost(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateTargetSiyaHSCost
        int siyaLvl = (int) jSpinnerSiyaLvl.getValue();
        int targetSiya = (int) jSpinnerTargetSiya.getValue();
        if (targetSiya > siyaLvl) {
            int targetSiyaCost = 0;
            for (int x = siyaLvl; x < targetSiya; x++) {
                targetSiyaCost += (x + 1);
            }
            JOptionPane.showMessageDialog(this, "To level Siyalatas from level " + jSpinnerSiyaLvl.getValue() + " to level "
                    + jSpinnerTargetSiya.getValue() + ", you need " + targetSiyaCost + " Hero Souls.", "Total HS cost", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Target Siyalatas level cant be lower nor equal than current Siyalatas level.", "Bad input", JOptionPane.WARNING_MESSAGE);
        }
        
                
    }//GEN-LAST:event_calculateTargetSiyaHSCost

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
    private javax.swing.JButton jButCalculateTargerSiyaCost;
    private javax.swing.JButton jButShowCredits;
    private javax.swing.JButton jButShowGildsROT;
    private javax.swing.JCheckBox jChkBoxHaveMorgulis;
    private javax.swing.JComboBox jComboBoxGameState;
    private javax.swing.JFormattedTextField jFormTxtArgaivLevel;
    private javax.swing.JFormattedTextField jFormTxtBhaalLevel;
    private javax.swing.JFormattedTextField jFormTxtFragsworthLevel;
    private javax.swing.JFormattedTextField jFormTxtIrisLateLevel;
    private javax.swing.JFormattedTextField jFormTxtIrisMidLevel;
    private javax.swing.JFormattedTextField jFormTxtJuggernautLevel;
    private javax.swing.JFormattedTextField jFormTxtLibertasLevel;
    private javax.swing.JFormattedTextField jFormTxtMammonLevel;
    private javax.swing.JFormattedTextField jFormTxtMimzeeLevel;
    private javax.swing.JFormattedTextField jFormTxtMorgulisLevel;
    private javax.swing.JFormattedTextField jFormTxtPlutoLevel;
    private javax.swing.JFormattedTextField jFormTxtSolomonLevel;
    private javax.swing.JFormattedTextField jFormTxtUnspentSouls;
    private javax.swing.JLabel jLabAncientsImage;
    private javax.swing.JLabel jLabArgaiv;
    private javax.swing.JLabel jLabBhaal;
    private javax.swing.JLabel jLabCHImage;
    private javax.swing.JLabel jLabFragsworth;
    private javax.swing.JLabel jLabGameState;
    private javax.swing.JLabel jLabIrisLate;
    private javax.swing.JLabel jLabIrisMid;
    private javax.swing.JLabel jLabJuggernaut;
    private javax.swing.JLabel jLabLibertas;
    private javax.swing.JLabel jLabMammon;
    private javax.swing.JLabel jLabMimzee;
    private javax.swing.JLabel jLabMorgulis;
    private javax.swing.JLabel jLabOptZone;
    private javax.swing.JLabel jLabPluto;
    private javax.swing.JLabel jLabSiyaLvl;
    private javax.swing.JLabel jLabSolomon;
    private javax.swing.JLabel jLabTargetSiya;
    private javax.swing.JLabel jLabUnspentSouls;
    private javax.swing.JPanel jPanelRulesOfThumb;
    private javax.swing.JPanel jPanelTotalHSCosts;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparatorStart;
    private javax.swing.JSpinner jSpinnerOptZone;
    private javax.swing.JSpinner jSpinnerSiyaLvl;
    private javax.swing.JSpinner jSpinnerTargetSiya;
    private javax.swing.JTabbedPane jTabRulesOfThumb;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
