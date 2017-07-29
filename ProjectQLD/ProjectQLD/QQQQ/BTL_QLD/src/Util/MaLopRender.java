/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.Lop;
import Model.MonHoc;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Admin
 */
public class MaLopRender implements ListCellRenderer {

    DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // gọi method giống hệt method cần viết, truyền vào tham số y như nguyên
        JLabel label = (JLabel) dlcr.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value != null) {
            label.setText(((Lop) value).getTenLop());
        }
        return label;
    }

}
