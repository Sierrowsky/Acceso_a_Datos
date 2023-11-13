/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ignorar;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author a21pablosp
 */
public class MyObjectOutputStream extends ObjectOutputStream{
    protected MyObjectOutputStream() throws IOException, SecurityException {
        super();
    }
    public MyObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        
    }

    
}
