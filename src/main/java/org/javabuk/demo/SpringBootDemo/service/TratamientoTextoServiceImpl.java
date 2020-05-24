package org.javabuk.demo.SpringBootDemo.service;

import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class TratamientoTextoServiceImpl  implements  TratamientoTextoService{

    @Override
    public String convertirStringEncoding(String cadenaTexto, Charset encoding) {
        return new String(cadenaTexto.getBytes(encoding));
    }

    @Override
    public boolean comprobarEncoding(String cadenaTextoOriginal, String cadenatextoEncoding, Charset encodingEsperado) {
        byte[] bytesOriginal = cadenaTextoOriginal.getBytes(encodingEsperado);
        byte[] bytesEncoding = cadenatextoEncoding.getBytes();
        return Arrays.equals(bytesOriginal, bytesEncoding);
    }

    @Override
    public String getCharset(String cadenaTexto) throws IOException {
        InputStreamReader isr = null;
        String s = null;
        try {
            InputStream is = new ByteArrayInputStream(cadenaTexto.getBytes());
            isr = new InputStreamReader(is);
            s = isr.getEncoding();
        } catch (Exception e) {
            System.out.print("The stream is already closed");
        } finally {
            if(isr!=null)
                isr.close();
        }
        return s;
    }
}
