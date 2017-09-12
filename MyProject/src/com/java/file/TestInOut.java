package com.java.file;

import java.io.*;

/**
 * @auther Administrator TianHangYu
 * @create 2017-09-08
 */
public class TestInOut {
    public static void main(String[] args){
        write();
        read();
    }
    private static final String fileName = "file.txt";
    private static final String fileName2 = "file2.txt";
    private static void write(){
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        try {
            File file = new File(fileName);
            File file2 = new File(fileName2);
            if(!file.exists()){
                file.createNewFile();
            }
            if(!file2.exists()){
                file2.createNewFile();
            }
            fis = new FileInputStream(file);
//            FileOutputStream out1 = new FileOutputStream(file);
            FileOutputStream out2 = new FileOutputStream(file2);

            byte[] b = new byte[fis.available()];
            fis.read(b);

            bos = new BufferedOutputStream(out2);
            bos.write(b);


//            PrintStream ps1 = new PrintStream(out1);
//            ps1.print("��2�$�8�5\n" +
//                    "v��+jD�\u000EV\u0012p�=]ǋ�e�5/�kw\u00174�:٧��\u001Bݒ͓\f2��sJ!�W\u000F�v:b|Z���\u000Es42Y\u007F�Z�\u0010��D�%  @�E�>�~�\u000F3�I��E���\u000F��ϲ�\u001C��QI\u0010Q�Պ(g�n9g\u0007K��rك\u00164S���0��O����\\�_�^$��b��$P��,{����߳9�v�V\u0014$Q7; ���\u0010B݅�&'��\u001EUw��6&��\u001B�+ɩb��t\u000E��G����R�?��1�01YL��݄��\u0005\u007Fq_\u07FB\\�Kv� \u0016�Y뽐8�p��\u0018+��pfl��\\'\u000EI��(\u001C!�7�i|�֊\u007F\u0017ܹ=���mU���&n�`�\u0010;\u007F@v��+t�s�M,z\u0011�}gB\u000E��\u000F\u0015\u000B���FT`Ձ�iyo&)�Yh�P6�bK�h���2p�φ��q�\u001E�F�\u0005����Qs(\u001A֞\u001D�9@��F\n" +
//                    "~����p\\�*Z�#���Д[B�t��z\u0012�,l�e��g.�C*S[$\u001Frc)\u0004��!o��Q�~Z�P_�!�\u0004��}�8\u0013:}O��\u000Fȓ����J\u0004q���\u0018�\u007Fw��\u008F�\u0012�K���\u0018O\u007F���\u0016B�:�l@!Y�����\u0012TM��#�\u0014���;��vQ�*�\"�\u001E��-�\u0012  L ��l\\]��j�\u000F<\u0014V-:�}�=�ia�Q�+�\n" +
//                    "��g�H��C\u0019�\u0018���c���XT  \u0010E������\u000EK��+\"��\u007F?_\u0010���:\u0004!\u000B��C�N\n" +
//                    "Fs#<�\u0007Ȕ��");
//            ps1.close();
//            out1.close();

//            OutputStream out2 = new FileOutputStream(file, true);
//            PrintStream ps2 = new PrintStream(out2);
//            ps2.print("-------0123456789");
//            ps2.close();
            bos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void read(){
        File file = new File(fileName);
        try {
            FileInputStream is1 = new FileInputStream(file);

            FileInputStream is2 = new FileInputStream(fileName);

            FileDescriptor fd = is2.getFD();
            System.err.println(fd.toString());
            FileInputStream is3 = new FileInputStream(fd);

            char c1 = (char) is1.read();
            System.err.println("c1 : " + c1);


            is1.skip(25);

            byte[] buf = new byte[10];
            is1.read(buf, 0, buf.length);
            System.err.println("buf : " + (new String(buf)));

            BufferedInputStream bufIn = new BufferedInputStream(is3);
            char c2 = (char) bufIn.read();
            System.err.println("c2 : " + c2);

            is1.close();
            is2.close();
            is1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
