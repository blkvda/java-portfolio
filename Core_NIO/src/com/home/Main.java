package com.home;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        //Различные способы создания экземпляра Path
        Path path1 = Paths.get("./test.txt");
        Path path2 = FileSystems.getDefault().getPath("./test.txt");
        //FileSystems дает возможность получить доступ к удаленной файловой системе
//        FileSystem fileSystem = FileSystems.getFileSystem(new URI("ftp://admin:admin@localhost/test/"));
//        Path path3 = fileSystem.getPath("test.txt");

        File file = new File("test.txt");
        Path path4 = file.toPath();
        file = path4.toFile();

        System.out.println(path1.toUri());
        //проход по каждому элементу пути
        for(int i = 0; i < path1.getNameCount(); i++){
            System.out.println(path1.getName(i));
        }

        try{
            //Запись и чтение символьных потоков(также есть байтовые потоки) в/из файла
            //BufferedWriter bufferedWriter = Files.newBufferedWriter(path1, Charset.forName("US-ASCII"));
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path1);
            Scanner scanner = new Scanner(System.in);
            String temp;
            System.out.println("Enter some text for writing in file, 'exit' to stop");
            while(!(temp = scanner.nextLine()).equals("exit")){
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            System.out.println("Read (newBufferedReader()) and print text from file");
            BufferedReader bufferedReader = Files.newBufferedReader(path1, Charset.forName("UTF-8"));
            while((temp = bufferedReader.readLine()) != null){
                System.out.println(temp);
            }

            System.out.println("Read (readAllLines()) and print text from file");
            //readAllLines - сохр весь файл в память мб краши и проблемы с производительностью
            for(String s : Files.readAllLines(path1)){
                System.out.println(s);
            }

            //создание копии файла
            Files.copy(path1, Paths.get("./testCopy.txt"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("is source and copy same files: " + Files.isSameFile(path1, Paths.get("./testCopy.txt")));

            //печать атрибутов файла
            printFileAttributes(path1);

            //редактирование у файла атрубутов времени доступа
            //BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path1, BasicFileAttributeView.class);
            //basicFileAttributeView.setTimes(FileTime.fromMillis(System.currentTimeMillis()), null, null);
            //printFileAttributes(path1);

            //печать директорий, на указанную глубину (2 ур.)
            printDirsByFind(Paths.get("./"),2);

            //печать директорий, фиксировано на одном уровне
            printDirsByList(Paths.get("./"));

            //удаление txt файлов
            deleteAllTxt();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void deleteAllTxt() throws IOException{
        Files.walk(Paths.get("./")).filter(p -> p.toString().endsWith(".txt")).map(Path::toFile).forEach(File::delete);
    }

    private static void printFileAttributes(Path path) throws IOException{
        //или с исп BasicFileAttributes
        //BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("Is directory: " + Files.isDirectory(path));
        System.out.println("Is regular file: " + Files.isRegularFile(path));
        System.out.println("Is symbolic link: " + Files.isSymbolicLink(path));
        System.out.println("Is hidden: " + Files.isHidden(path));
        System.out.println("Is readable: " + Files.isReadable(path));
        System.out.println("Is executable: " + Files.isExecutable(path));
        System.out.println("Last modified time: " + Files.getLastModifiedTime(path).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        System.out.println("Owner: " + Files.getOwner(path));
    }

    private static void printDirsByFind(Path path, int depth) throws IOException{
        System.out.println("printDirectoriesForDepth():");
        Stream<Path> stream = Files.find(path, depth, (p, basicFileAttributes) -> Files.isDirectory(p));
        stream.forEach(System.out::println);
    }

    private static void printDirsByList(Path path)throws IOException{
        System.out.println("printDirsByList():");
        Files.list(path).filter(p -> Files.isDirectory(p)).map(p -> p.toAbsolutePath()).forEach(System.out::println);
    }
}
