package com.example.blogsystem.util;

import com.example.blogsystem.exception.CustomException;

import java.io.ByteArrayOutputStream;

import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class FileUtil {
    public static byte[] compressFile(byte[] data) throws CustomException {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] temp = new byte[5*1024];
        while(!deflater.finished()){
            int size = deflater.deflate(temp);
            outputStream.write(temp,0,size);
        }
        try{
            outputStream.close();
        } catch (Exception e) {
            throw new CustomException("Something went wrong"+e);
        }
        return outputStream.toByteArray();

   }

   public static byte[] decompressFile(byte[] data)throws CustomException{
       Inflater inflater = new Inflater();
       inflater.setInput(data);
       ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
       byte[] temp = new byte[5*1024];
       try{
           while(!inflater.finished()){
               int count = inflater.inflate(temp);
               outputStream.write(temp,0,count);
           }
           outputStream.close();

       }catch (Exception e){
           throw new CustomException("Something went wrong"+ e);
       }
       return outputStream.toByteArray();
   }
}
