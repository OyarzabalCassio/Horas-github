/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import mirine.Mirine;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Cassio
 */
public class ComboDAO {
    ResultSet resultado = null;

    
    public void preencherCombo(String tabela, JComboBox combo) {

        combo.removeAllItems();

        Mirine item = new Mirine();
        item.setId(0);
        item.setMetodo("Selecione");
        combo.addItem(item);

        try {
            resultado = new Conexao().getConnection().createStatement().executeQuery(""
                    + "select * "
                    + "from " + tabela + " "
                    + "order by 2");

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new Metodo();
                    item.setId(resultado.getInt(1));
                    item.setMetodo(resultado.getString(2));

                    combo.addItem(item);
                    
                   
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao preencher = " + e.toString());
        }
    }

   

   public void definirItemCombo(JComboBox combo, Metodo item) {
       for (int i = 0; i < combo.getItemCount(); i++) {
           if (((Metodo) combo.getItemAt(i)).getId()== (item.getId())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
