
package controlador;

import java.util.*;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.VistaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCliente implements ActionListener {
    //Atributos
    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente c = new Cliente();
    VistaCliente vista = new VistaCliente();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Métodos
    //Constructor
    public ControladorCliente(VistaCliente v){
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnListar){
            Listar(vista.tablaCliente);
        }
    }
    
    public void Listar(JTable tabla){
        Limpiar(tabla);
        modelo = (DefaultTableModel)tabla.getModel();
        List<Cliente> lista = clienteDAO.Listar();
        Object[] object = new Object[7];
        
        for(int i = 0; i<lista.size() ; i++){
            object[0] = lista.get(i).getIdCliente();
            object[1] = lista.get(i).getNombres();
            object[2] = lista.get(i).getApellidos();
            object[3] = lista.get(i).getDocumentoIdentidad();
            object[4] = lista.get(i).getDireccion();
            object[5] = lista.get(i).getCorreo();
            object[6] = lista.get(i).getCelular();
            
            modelo.addRow(object);
        }
        
        vista.tablaCliente.setModel(modelo);
    }
    
    
    public void Limpiar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        for(int i = 0; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
        }
        vista.tablaCliente.setModel(modelo);
    }
    
    
}
