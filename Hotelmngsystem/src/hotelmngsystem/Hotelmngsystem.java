/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmngsystem;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class Hotelmngsystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.BOOK ROOM");
            System.out.println("2.CANCEL ROOM");
            System.out.println("3.SEARCH RROM");
            System.out.println("4.DISPLAY ROOM");
            System.out.println("5.EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Bean bn = new Bean();

                    System.out.println("Enter Room number:");
                    int room_no = sc.nextInt();
                    System.out.println("Enter Your name:");
                    String name = sc.next();
                    System.out.println("Enter Number:");
                    int number = sc.nextInt();
                    System.out.println("Enter Address:");
                    String address = sc.next();

                    bn.setRoom_no(room_no);
                    bn.setName(name);
                    bn.setNumber(number);
                    bn.setAddress(address);

                    Data dt = new Data();
                    try {
                        String s = dt.BookRoom(bn);

                        if (s.equals("success")) {
                            System.out.println("Room Booked");

                        } else {
                            System.out.println("Some Data Error");
                        }
                    } catch (Exception e) {
                        System.out.println("Error while booking");
                    }
                    break;

                case 2:
                    Data dt1 = new Data();
                    try {
                        System.out.println("Enter Room Number to Cancel");
                        int del_room = sc.nextInt();
                        String s = dt1.DeleteRoom(del_room);
                        if (s.equals("success")) {
                            System.out.println("Room Cancelled");

                        } else {
                            System.out.println("Some Data Error");
                        }
                    } catch (Exception e) {
                        System.out.println("Error Occured");
                    }
                    break;

                case 3:
                    Data dt2 = new Data();
                    try {
                        System.out.println("Enter room no to saerch: ");
                        int r1 = sc.nextInt();
                        Bean bn1 = dt2.Search(r1);
                        if (bn1 != null) {
                            System.out.println(bn1.getRoom_no() + "\t" + bn1.getName() + "\t" + bn1.getNumber() + "\t" + bn1.getAddress());
                        } else {
                            System.out.println("This room is not beign alocated to anyone");
                        }
                    } catch (Exception e) {
                        System.out.println("Some System error while searching please wait");
                    }
                    break;

                case 4:
                    Data dt3 = new Data();
                    Bean bn2 = null;
                    try {
                        ArrayList al = dt3.Display();
                        for (int i = 0; i < al.size(); i++) {
                            bn = (Bean) al.get(i);
                            System.out.println(bn.getRoom_no() + "\t" + bn.getName() + "\t" + bn.getNumber() + "\t" + bn.getAddress());
                        }
                    } catch (Exception e) {
                        System.out.println("Some error occured while displaying info");
                    }
                    break;

                case 5:
                    System.out.println("Now Exit");
                    System.exit(0);

                default:
                    System.out.println("Wrong Choice please enter right choice");

            }
        }
    }

}
