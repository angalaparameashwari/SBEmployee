package application.Examples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListParallelProcess {

    public static void main(String args[]) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(processorCount);
        List<Person> listPerson = new ArrayList<>();
        long startTime = 0;
        long endTime = 0;
        Person person = new Person("AP","K","CB","OMR",
                "chennai","India","TamilNadu",600096,"3456789","3456789");
        listPerson.add(person);
        person = new Person("AP1","K1","CB1","OMR1",
                "chennai1","India1","TamilNadu1",600096,"34567891","34567891");
        listPerson.add(person);
        person = new Person("AP2","K2","CB2","OMR2",
                "chennai2","India2","TamilNadu2",600096,"34567892","34567892");
        listPerson.add(person);
        person = new Person("AP3","K3","CB3","OMR3",
                "chennai3","India3","TamilNadu3",600096,"34567893","34567893");
        listPerson.add(person);
        person = new Person("AP4","K4","CB4","OMR4",
                "chennai4","India4","TamilNadu4",600096,"34567894","34567894");
        listPerson.add(person);
        person = new Person("AP5","K5","CB5","OMR5",
                "chennai5","India5","TamilNadu5",600096,"34567895","34567895");
        listPerson.add(person);
        person = new Person("AP6","K6","CB6","OMR6",
                "chennai6","India6","TamilNadu6",600096,"34567896","34567896");
        listPerson.add(person);
        person = new Person("AP7","K7","CB7","OMR7",
                "chennai7","India7","TamilNadu7",600096,"34567896","34567896");
        listPerson.add(person);
        person = new Person("AP8","K8","CB8","OMR8",
                "chennai8","India8","TamilNadu8",600096,"34567896","34567896");
        listPerson.add(person);
        person = new Person("AP9","K9","CB9","OMR9",
                "chennai9","India9","TamilNadu9",600096,"34567896","34567896");
        listPerson.add(person);
        person = new Person("AP10","K10","CB10","OMR10",
                "chennai10","India10","TamilNadu10",600096,"34567896","34567896");
        listPerson.add(person);

        //Completable future
        startTime = ListParallelProcess.getCurrentTime();
                listPerson.stream().forEach(per -> CompletableFuture.completedFuture("done")
                        .runAsync(() -> {
                            try {
                                ListParallelProcess.streamImp(per, "completable1");
                                ListParallelProcess.streamImp1(per, "completable2");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                ));

        endTime = ListParallelProcess.getCurrentTime();
        long processTime = endTime - startTime;
        System.out.println("thread Execution time completable future :" + processTime);
////
//        String s1 = "AP";
//        System.out.println(s1);
//        s1 = "sdf";
//        System.out.println(s1);
//        String s="Sachin";
//        s.concat(" Tendulkar");//concat() method appends the string at the end
//        System.out.println(s);//will print Sachin because strings are immutable objects
//
//        final StringBuffer sb = new StringBuffer("Hello");

        // Even though reference varibale sb is final
        // We can perform any changes

    //    System.out.println(sb);
        String s1 = "Java";
        String s2 = "Java";
        System.out.println(s1);
        System.out.println(s2);
        s1 = "C++";
        System.out.println(s1);
        System.out.println(s2);



        //Completable future
        startTime = ListParallelProcess.getCurrentTime();
        listPerson.stream().forEach(per -> CompletableFuture.runAsync(() -> {
                    try {
                        ListParallelProcess.streamImp(per, "completableService1");
                        ListParallelProcess.streamImp1(per, "completableService2");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                },service
        ));

        endTime = ListParallelProcess.getCurrentTime();
        processTime = endTime - startTime;
        System.out.println("thread Execution time completable future :" + processTime);


        startTime = ListParallelProcess.getCurrentTime();
        //Implemetation two
        for(Person person1 : listPerson){
            service.execute(new RunnableImpl(person1));
            service.execute(new Runnable2(person1));
        }
        endTime = ListParallelProcess.getCurrentTime();
        processTime = endTime - startTime;
        System.out.println("thread Execution time Thread :" + processTime);

        // Implementaion Three
        String stream1 = "stream1.txt";
        String stream2 = "stream2.txt";
        String listStream1 = "listStream1.txt";
        String listStream2 = "listStream2.txt";
        startTime = ListParallelProcess.getCurrentTime();
        listPerson.stream().forEach(per ->{
                    try {
                        ListParallelProcess.streamImp(per, stream1);
                        ListParallelProcess.streamImp1(per, stream2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        endTime = ListParallelProcess.getCurrentTime();
        processTime = endTime - startTime;
        System.out.println("thread Execution time Stream :" + processTime);


        //implementation Four
        startTime = ListParallelProcess.getCurrentTime();
        listPerson.parallelStream().forEach(per -> {
            try {
                ListParallelProcess.streamImp(per, listStream1);
                ListParallelProcess.streamImp1(per, listStream2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        endTime = ListParallelProcess.getCurrentTime();
        processTime = endTime - startTime;
//        System.out.println("thread Execution time parallel stream :" + processTime);

        }

    private static void streamImp(Person person, String fileName) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
        out.write("name : " + person.getFirstname() + person.getLastName() + "\n");
        out.write("comapany name : " + person.getCompanyName() + "\n");
        out.write("phone : " + person.getPhone1() + "\n");
        out.close();
    }

    private static void streamImp1(Person person, String fileName) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
        out.write("Address : " + person.getAddress() + "\n");
        out.write("City : " + person.getCity() + "\n");
        out.write("Country : " + person.getCountry() + "\n");
        out.close();
    }

    private static class RunnableImpl implements Runnable {
        Person person;

        public RunnableImpl(Person person) {
            this.person = person;
        }
        @Override
        public void run()
        {
            //process the record
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("ThreadBasic.txt", true));
               // FileWriter out = new FileWriter("ThreadBasic.txt");
                out.write("name : " + person.getFirstname() + " " + person.getLastName() + "\n");
                out.write("company name : " + person.getCompanyName() + "\n");
                out.write("phone : " + person.getPhone1() + "\n");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Runnable2 implements Runnable {
        Person person;

        public Runnable2(Person person) {
            this.person = person;
        }

        @Override
        public void run() {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("ThreadBasic.txt", true));
                out.write("Address : " + person.getAddress() + "\n");
                out.write("City : " + person.getCity() + "\n");
                out.write("Country : " + person.getCountry() + "\n");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private static long getCurrentTime(){
        return System.currentTimeMillis();
    }
}
