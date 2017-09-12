package com.java.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @auther Administrator TianHangYu
 * @create 2017-09-12
 */
public class TestNio {
    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    private static void test5() throws Exception {
        SocketChannel channel = SocketChannel.open();
        boolean connect = channel.connect(new InetSocketAddress("http://localhost", 8089));
        System.err.println("connect : " + connect);

        ByteBuffer buf = ByteBuffer.allocate(48);
        int read = channel.read(buf);
        System.err.println("read : " + read);

        while (read != -1){
            System.err.println((char)buf.get());
        }
    }

    private static void test4() throws Exception{
        RandomAccessFile fromFile = new RandomAccessFile("data-nio.txt", "rw");
        FileChannel channel = fromFile.getChannel();

//        String data = "New  String to file ..." + System.currentTimeMillis();
        String data = "mmmmmmmm";
        System.err.println(channel.size());
        ByteBuffer buf = ByteBuffer.allocate(11);
        buf.clear();
        buf.put(data.getBytes());
        buf.flip();

        channel.position(channel.position() + channel.size());
        while (buf.hasRemaining()) {
            channel.write(buf);
        }

        channel.close();

    }

    private static void test3() throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("data-nio.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("file2", "rw");
        FileChannel toChannle = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannle.transferFrom(fromChannel, position, count);

    }
    private static void test2() throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("data-nio.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(48);

        int read = channel.read(allocate);
        while (read != -1){
            allocate.flip();
            System.err.println("---");
            while (allocate.hasRemaining()) {
                System.err.print((char)allocate.get());
            }

            allocate.clear();
            read = channel.read(allocate);
        }
        accessFile.close();
    }

    private static void test1() throws Exception {
        File f = new File("data-nio.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        RandomAccessFile accessFile = new RandomAccessFile("data-nio.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        int read = channel.read(buf);
        while (read != -1){
            System.err.println("Read : " + read);
            buf.flip();

            while (buf.hasRemaining()){
                System.err.print((char)buf.get());
            }

            buf.clear();
            read = channel.read(buf);
        }

        accessFile.close();
    }
}
