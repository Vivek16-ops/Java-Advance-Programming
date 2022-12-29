/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author ASUS
 */
import java.util.*;

public class Project1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO Vivek Project1 with database");
        while (true) {
            System.out.println("1.INSERT");
            System.out.println("2.DELETE");
            System.out.println("3.SEARCH");
            System.out.println("4.GET ALL");
            System.out.println("5.EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int v = sc.nextInt();
            switch (v) {
                case 1: {
                    RackBean rb = new RackBean();
                    rb.setRackno(3);
                    rb.setSubject("Singhal");

                    RackData rd = new RackData();
                    try {
                        String s = rd.insert(rb);
                        //String s=rd.delete(3);
                        //RackBean s;
                        //s=rd.search(1);

                        if (s.equals("success")) {
                            System.out.println("Data Saved");

                        } else {
                            System.out.println("Some Data Error");
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 2: {
                    RackData rd = new RackData();
                    try {
                        String s = rd.delete(6);
                        if (s.equals("success")) {
                            System.out.println("Data Deleted");

                        } else {
                            System.out.println("Some Data Error");
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 3: {
                    RackData rd = new RackData();

                    try {
                        RackBean rb = rd.search(4);
                        if (rb != null) {
                            System.out.println(rb.getSubject());
                        } else {
                            System.out.println("Sorry this rack not exists");
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 4: {
                    RackData rd = new RackData();
                    RackBean rb = null;
                    try {
                        ArrayList al = rd.getAll();
                        for (int i = 0; i < al.size(); i++) {
                            rb = (RackBean) al.get(i);
                            System.out.println(rb.getRackno() + "\t" + rb.getSubject());
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Now Exit");
                    System.exit(0);
                }
                default: {
                    System.out.println("Wrong choice please enter correct choice");
                }
            }
        }
    }

}
