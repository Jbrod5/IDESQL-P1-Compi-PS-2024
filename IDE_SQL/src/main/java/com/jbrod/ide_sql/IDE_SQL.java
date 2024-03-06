package com.jbrod.ide_sql;

import com.jbrod.ide_sql.app.CsvDriver.Analyzer;
import com.jbrod.ide_sql.app.CsvDriver.FileManager;
import com.jbrod.ide_sql.ui.AppFrame;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


import com.jbrod.ide_sql.app.analyzer.SqlParser;
import com.jbrod.ide_sql.app.analyzer.SqlLexer;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbravo
 */
public class IDE_SQL {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        String cadena = "ELIMINAR EN proyecto.archivo1 FILTRAR columna1=\"hola\";"; 
        StringReader rd = new StringReader(cadena);
        SqlLexer lexer = new SqlLexer(rd);
        SqlParser parser = new SqlParser(lexer);
        
        try {
            parser.parse();
        } catch (Exception ex) {
            Logger.getLogger(IDE_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //1. Obtener el directorio
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Selecciona un directorio:");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String selectedPath = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Ruta del directorio seleccionado: " + selectedPath);
            
            
            
            FileManager fileManager = new FileManager();
            Analyzer analyzer = new Analyzer(selectedPath, fileManager);
            AppFrame appFrame = new AppFrame(selectedPath, analyzer);
            analyzer.setAppFrame(appFrame);
            
            appFrame.setVisible(true);
            
            
            
        } else {
            System.out.println("No se ha seleccionado ningún directorio.");
        }
    }
    
}
