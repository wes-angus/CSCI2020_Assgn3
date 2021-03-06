
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100449718
 */
public class PieChart extends javax.swing.JPanel {

    List<Double> pieValues;
    List<String> pieLabels;
    /**
     * Creates new form PieChart
     * @param values
     */
    public PieChart(Map<String, Double> values)
    {
        pieValues = new ArrayList<>();
        pieLabels = new ArrayList<>();
        Map<String, Double> labelToValueMap = new LinkedHashMap<>(values);
        for(Map.Entry<String, Double> entry : labelToValueMap.entrySet())
        {
            pieLabels.add(entry.getKey());
            pieValues.add(entry.getValue());
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(1120, 720));

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel1.setText("Legend");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(857, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addContainerGap(641, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g)
    {
        Color[] colors = {Color.blue, Color.green, Color.magenta, Color.orange, Color.yellow, Color.cyan, Color.pink, Color.red, Color.gray};
        
        double total = 0.0;
        for(Double value : pieValues)
        {
            total += value;
        }
        
        Dimension d = getPreferredSize();
        //int clientHeight = d.height;
        int clientWidth = d.width;
        
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
        //FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
        g.setFont(labelFont);
        Font legendFont = new Font("Verdana", Font.BOLD, 12);
        FontMetrics legendFontMetrics = g.getFontMetrics(labelFont);
        
        int rectX = clientWidth - 440;
        int rectY = 90;
        int rectHeight = 540;
        int rectWidth = 400;
        int circX = 90;
        int circY = 100;
        int circWidth = 520;
        int circHeight = 520;
        int legendPosY;
        int startAngle = 0;
        int arcAngle;
        int roundedTotal;
        
        //draw circle outline
        g.drawOval(circX, circY, circWidth, circHeight);
        g.drawOval(circX-1, circY, circWidth, circHeight);
        g.drawOval(circX, circY-1, circWidth, circHeight);
        g.drawOval(circX, circY, circWidth+1, circHeight);
        g.drawOval(circX, circY, circWidth, circHeight+1);
        
        for (int i = 0; i < pieValues.size(); i++)
        {
            //draw legend info
            g.setColor(Color.black);
            legendPosY = rectY + ((i + 1) * 60) - 30;
            g.drawRect(rectX + 5, legendPosY, 6, 6);
            g.setFont(legendFont);
            g.drawString(pieLabels.get(i), rectX + 16, legendPosY + (int) Math.rint((double)legendFontMetrics.getHeight() / 2.0));
            g.setFont(labelFont);
            g.setColor(colors[i]);
            g.fillRect(rectX + 5, legendPosY, 6, 6);
            //draw arc
            arcAngle = (int) Math.rint(pieValues.get(i) * 360.0 / total);
            //g.fillArc(circX, circY, circWidth, circHeight, startAngle, arcAngle);
            startAngle += arcAngle;
        }
        roundedTotal = startAngle;
        
        startAngle = 0;
        int a = 360;
        int ceilAngle;
        //if there is rounding error, adjust some pie slices to compensate
        if(roundedTotal < 360)
        {
            for (int i = 0; i < pieValues.size(); i++)
            {
                g.setColor(colors[i]);
                arcAngle = (int) Math.rint(pieValues.get(i) * 360.0 / total);
                ceilAngle = (int) Math.ceil(pieValues.get(i) * 360.0 / total);
                if(ceilAngle > arcAngle && a > roundedTotal)
                {
                    //draw arc
                    arcAngle += 1;
                    g.fillArc(circX, circY, circWidth, circHeight, startAngle, arcAngle);
                    startAngle += arcAngle;
                    a--;
                }
                else
                {
                    //draw arc
                    g.fillArc(circX, circY, circWidth, circHeight, startAngle, arcAngle);
                    startAngle += arcAngle;                    
                }
            }
        }
        
        g.setColor(Color.black);
        
        //Legend outline
        g.drawRect(rectX, rectY, rectWidth, rectHeight);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
