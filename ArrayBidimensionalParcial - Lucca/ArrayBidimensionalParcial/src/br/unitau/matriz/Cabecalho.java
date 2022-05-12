package br.unitau.matriz;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class Cabecalho extends DefaultTableCellRenderer{
    @Override
    public void setValue(Object value) {
        setBackground(new Color(238, 238, 238));
        setForeground(Color.BLACK);
        setHorizontalAlignment(JLabel.CENTER);
        super.setValue(value);
    }   
}


