
package Vista;

import Modelo.Alumnos;
import Modelo.CarreraProfesional;
import Modelo.Identificacion;
import controlador.ControladorAlumnos;
import controlador.ControladorCarreraProfesional;
import controlador.ControladorIdentificacion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CarnetVista extends javax.swing.JFrame {

    String dni;
    /**
     * Creates new form CarnetVista
     */
    public CarnetVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargarFacultades();
        llamarLista();
    }
   private void cargarFacultades() {
    cboFacultad.addItem("INGENIERIA");
    cboFacultad.addItem("MEDICINA");
    cboFacultad.addItem("DERECHO");
    cboFacultad.addItem("CIENCIAS DE LA SALUD");
    cboFacultad.addItem("CONTABILIDAD");
}

    private void limpiarCampos(){
        txtCodigo.setText("");
        txtDni.setText("");
        txtApellidoMaterno.setText("");
        txtApellidoPaterno.setText("");
        txtNombres.setText("");
        cboFacultad.setSelectedIndex(0);
        cboCarrera.setSelectedIndex(0);
    }
    private void llamarLista(){
        DefaultTableModel model = (DefaultTableModel) tableDatos.getModel();

        // Limpiar datos existentes en la tabla
        model.setRowCount(0);
        
        ControladorCarreraProfesional controlProfesional = new ControladorCarreraProfesional();
        ControladorIdentificacion controlIdentificacion = new ControladorIdentificacion();
        ControladorAlumnos controlAlumnos = new ControladorAlumnos();
        
        List<Alumnos> alumnos = controlAlumnos.obtenerAlumno();
        List<CarreraProfesional> carreras = controlProfesional.obtenerCarreraProfesional();
        List<Identificacion> identificaciones = controlIdentificacion.obtenerIdentificacion();
        
        int size = alumnos.size();
        
        for (int i = 0; i < size; i++) {
            Alumnos alumno = alumnos.get(i);
            CarreraProfesional carrera = (i < carreras.size()) ? carreras.get(i) : new CarreraProfesional(); // Manejar si faltan cursos
            Identificacion identificacion = (i < identificaciones.size()) ? identificaciones.get(i) : new Identificacion(); // Manejar si faltan matrículas

            // Añadir fila a la tabla con los datos combinados
            Object[] row = {
                alumno.getApellidoMaterno(),
                alumno.getApellidoPaterno(),
                alumno.getNombres(),
                alumno.getDni(),
                identificacion.getCodigo(),
                carrera.getFacultad(),
                identificacion.getCorreo(),
                carrera.getCarrera(),
                carrera.getFechaIngreso(),
            };
             model.addRow(row);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        panelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboFacultad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        cboCarrera = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();

        txtSalida.setBackground(new java.awt.Color(0, 0, 0));
        txtSalida.setColumns(20);
        txtSalida.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtSalida.setForeground(new java.awt.Color(255, 255, 255));
        txtSalida.setRows(5);
        jScrollPane1.setViewportView(txtSalida);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDatos.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setBackground(new java.awt.Color(51, 0, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Codigo.");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Apellido Paterno:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 255));
        jLabel4.setText("Nombres");

        cboFacultad.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        cboFacultad.setForeground(new java.awt.Color(51, 0, 255));
        cboFacultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFacultadActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 255));
        jLabel6.setText("Carrera:");

        txtCodigo.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtDni.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        txtApellidoPaterno.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });

        txtNombres.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 255));
        jLabel5.setText("Facultad");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Apellido Materno:");

        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        panelBotones.setBackground(new java.awt.Color(255, 102, 204));

        btnAgregar.setBackground(new java.awt.Color(51, 51, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(51, 0, 255));
        btnEliminar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(51, 51, 255));
        btnActualizar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnListar.setBackground(new java.awt.Color(0, 51, 255));
        btnListar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnListar.setText("Aplicar Modificaciones");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        cboCarrera.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        cboCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellidoMaterno)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(cboCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboFacultad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombres)
                    .addComponent(txtDni)
                    .addComponent(txtCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tableDatos.setBackground(new java.awt.Color(153, 51, 255));
        tableDatos.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "DNI", "Codigo", "Facultad", "Correo", "Carrera", "Fecha_Creacion"
            }
        ));
        jScrollPane2.setViewportView(tableDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 123, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFacultadActionPerformed
String facultadSeleccionada = (String) cboFacultad.getSelectedItem();
    cboCarrera.removeAllItems(); // Limpia el combo box de carreras

    switch (facultadSeleccionada) {
        case "CIENCIAS DE LA SALUD":
            cboCarrera.addItem("Enfermería");
            cboCarrera.addItem("Farmacia y Bioquímica");
            cboCarrera.addItem("Medicina Veterinaria y Zootecnia");
            cboCarrera.addItem("Nutrición Humana");
            cboCarrera.addItem("Obstetricia");
            cboCarrera.addItem("Odontología");
            cboCarrera.addItem("Psicología");
            cboCarrera.addItem("Tecnología Médica");
            break;
        case "MEDICINA":
            cboCarrera.addItem("Medicina Humana");
            break;
        case "CONTABILIDAD":
            cboCarrera.addItem("Administración y Sistemas");
            cboCarrera.addItem("Contabilidad y Finanzas");
            break;
        case "DERECHO":
            cboCarrera.addItem("Derecho");
            cboCarrera.addItem("Educación Inicial");
            cboCarrera.addItem("Educación Primaria");
            break;
        case "INGENIERIA":
            cboCarrera.addItem("Arquitectura");
            cboCarrera.addItem("Ingeniería Civil");
            cboCarrera.addItem("Ingeniería del Medio Ambiente y Desarrollo");
            cboCarrera.addItem("Ingeniería Industrial");
            cboCarrera.addItem("Ingeniería de Sistemas y Computación");
            break;
        default:
            cboCarrera.addItem("Seleccione una facultad");
            break;
    }


    }//GEN-LAST:event_cboFacultadActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        
        String nombre = txtNombres.getText();
        String paterno = txtApellidoPaterno.getText();
        String materno = txtApellidoMaterno.getText();
        String facultad = cboFacultad.getSelectedItem().toString();
        String carrera = cboCarrera.getSelectedItem().toString();
        
        if (nombre.isEmpty() || paterno.isEmpty() || materno.isEmpty()  ) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos para el registro");
            return;
        }
        
        ControladorCarreraProfesional controlProfesional = new ControladorCarreraProfesional();
        ControladorAlumnos controlAlumnos = new ControladorAlumnos();
        
        int id_carreraprofesional = controlProfesional.actualizarCarreraProfesional(dni, facultad, carrera);
        boolean verificar = controlAlumnos.actualizarAlumno(id_carreraprofesional, nombre, paterno, materno);
        
        if (verificar) {
            JOptionPane.showMessageDialog(this, "Cambios realizados con exito");
            llamarLista();
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo aplicar los cambios");
        }
        
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        String codigo= txtCodigo.getText();
        String dni = txtDni.getText();
        String paterno =txtApellidoPaterno.getText();
        String materno = txtApellidoMaterno.getText();
        String nombres = txtNombres.getText();
        String facultad = cboFacultad.getSelectedItem().toString();
        String carrera = cboCarrera.getSelectedItem().toString();
        
        if (codigo.isEmpty() || dni.isEmpty() || paterno.isEmpty() || materno.isEmpty() || nombres.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos para el registro");
            return;
        }
        
        ControladorCarreraProfesional controlProfesional = new ControladorCarreraProfesional();
        ControladorIdentificacion controlIdentificacion = new ControladorIdentificacion();
        ControladorAlumnos controlAlumnos = new ControladorAlumnos();
        
        int id_carreraprofesional = controlProfesional.agregarCarreraProfesional(facultad, carrera);
        int id_identificacion = controlIdentificacion.agregarIdentificacion(codigo);
        boolean verificardor = controlAlumnos.agregarAlumno(id_carreraprofesional, id_identificacion, nombres, paterno, materno, dni);
        
        if (id_carreraprofesional > 0) {
            if (id_identificacion > 0) {
                if (verificardor) {
                   JOptionPane.showMessageDialog(this, "Se registro el alumno");
                   limpiarCampos();
                   llamarLista();
                }
            }
        }
        
       
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

         dni = JOptionPane.showInputDialog(null, "Por favor, ingrese su DNI:");
        
         if (dni != null && !dni.trim().isEmpty()) {
             ControladorAlumnos conAlum = new ControladorAlumnos();
             ControladorCarreraProfesional conCarrera = new ControladorCarreraProfesional();
             
             Alumnos alumno = conAlum.obtenerLosCamposAlumnosModificar(dni);
             CarreraProfesional carrera = conCarrera.obtenerLosCamposCarreraModificar(dni);
             
                if (alumno != null) {
               txtNombres.setText(alumno.getNombres());
               txtApellidoPaterno.setText(alumno.getApellidoPaterno());
               txtApellidoMaterno.setText(alumno.getApellidoMaterno());
               
               if (carrera.getFacultad().equals("Cajero")) {
                   cboFacultad.setSelectedIndex(0);
               }else if(carrera.getFacultad().equals("INGENIERIA")){
                   cboFacultad.setSelectedIndex(1);
               }
               
               if (carrera.getCarrera().equals("Ingeniería Industria")) {
                   cboCarrera.setSelectedIndex(0);
               }else if(carrera.getCarrera().equals("Ingeniería Civil")){
                   cboCarrera.setSelectedIndex(1);
               }
               
               } else {
                   JOptionPane.showMessageDialog(null, "No se encontró el Alumno asociado a este DNI .");
               }
           } else {
               JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el DNI ingresado.");
           }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            String codigo = JOptionPane.showInputDialog(null, "Por favor, ingrese el código:");
        if (codigo != null && !codigo.trim().isEmpty()) {
            ControladorCarreraProfesional controlProfesional = new ControladorCarreraProfesional();
            ControladorIdentificacion controlIdentificacion = new ControladorIdentificacion();
            ControladorAlumnos controlAlumnos = new ControladorAlumnos();

            boolean ve1 = controlAlumnos.eliminarAlumnos(codigo);
            boolean ve2 = controlProfesional.eliminarCarrera(codigo);
            boolean ve3 = controlIdentificacion.eliminarIdentificacion(codigo);

            if (ve1 && ve2 && ve3) {
                JOptionPane.showMessageDialog(null, "Se eliminó el registro correctamente.");
                llamarLista();    
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar uno de los registros.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed

    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed

    }//GEN-LAST:event_txtDniActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void cboCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCarreraActionPerformed

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
            java.util.logging.Logger.getLogger(CarnetVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarnetVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarnetVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarnetVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarnetVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cboCarrera;
    private javax.swing.JComboBox<String> cboFacultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JTable tableDatos;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
