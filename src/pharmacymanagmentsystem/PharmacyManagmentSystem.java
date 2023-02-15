/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class PharmacyManagmentSystem {

    public static void main(String[] args) throws IOException, ParseException {
        LinkedList l = new LinkedList();
        l.loadData("D:\\University\\Level 2\\Third Semester\\Data Structures\\Final Project\\MedicineList.txt");
        menu(l);

    }

    public static void menu(LinkedList l) throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("       Pharmacy Management System   ");
        System.out.println("   ===================================");
        System.out.println();
        System.out.println("  -------------------------------------");
        System.out.println("   ||       1.printAll               ||");
        System.out.println("   ||       2.print Medicine Data    ||");
        System.out.println("   ||       3.Add new Medicine       ||");
        System.out.println("   ||       4.Update Medicine        ||");
        System.out.println("   ||       5.Delete Medicine        ||");
        System.out.println("   ||       6.Expire At Date         ||");
        System.out.println("   ||       7.Sell Medicine          ||");
        System.out.println("   ||       8.Sort By Price          ||");
        System.out.println("   ||       9.Sort By Quantity       ||");
        System.out.println("   ||       10.Sorting By Exp. Date  ||");
        System.out.println("   ||       11.Sorting By ID         ||");
        System.out.println("   ||       12.Exit                  ||");
        System.out.println("  -------------------------------------");
        System.out.println("Enter Choice: ");
        int x = sc.nextInt();
        if (x == 1) {
            l.printAll();
        } else {
            if (x == 2) {
                l.printMedicineData();
            } else {
                if (x == 3) {
                    l.addNewMedicine();
                } else {
                    if (x == 4) {
                        l.update();
                    } else {
                        if (x == 5) {
                            l.delete();
                        } else {

                            if (x == 6) {
                                sc.nextLine();
                                System.out.println("Enter The Month of Expiration : ");
                                String m = sc.nextLine();
                                System.out.println("Enter The Year of Expiration : ");
                                String y = sc.nextLine();
                                l.expireAtDate(m, y);

                            } else {
                                if (x == 7) {
                                    l.sellMedicine();
                                } else {
                                    if (x == 8) {
                                        System.out.print("Enter 1 if you want ascending order and 2 for descending : ");
                                        int o = sc.nextInt();
                                        l.sortPrice(o);
                                    } else {
                                        if (x == 9) {
                                            System.out.print("Enter 1 if you want ascending order and 2 for descending : ");
                                            int o = sc.nextInt();
                                            l.sortQuantity(o);
                                        } else {
                                            if (x == 10) {
                                                System.out.print("Enter 1 if you want ascending order and 2 for descending : ");
                                                int o = sc.nextInt();
                                                l.sortDate(o);
                                            } else {
                                                if (x == 11) {
                                                    System.out.print("Enter 1 if you want ascending order and 2 for descending : ");
                                                    int o = sc.nextInt();
                                                    l.sortID(o);
                                                } else {
                                                    if (x == 12) {
                                                        l.exit();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        menu(l);

    }

}
