package pharmacymanagmentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


//import static java.util.Collections.swap;
public class LinkedList {

    public Node Head;
    int size;

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public void loadData(String filepath) throws FileNotFoundException, ParseException {
        File fileobj = new File(filepath);
        Scanner sc = new Scanner(fileobj);
        while (sc.hasNext()) {
            Node temp = new Node();
            String id = sc.nextLine();
            temp.medicineID = Integer.parseInt(id);
            String quantity = sc.nextLine();
            temp.quantity = Integer.parseInt(quantity);
            temp.medicineName = sc.nextLine();
            temp.place = sc.nextLine();
            String price = sc.nextLine();
            temp.price = Double.parseDouble(price);
            temp.type = sc.nextLine();
            temp.manufacture = sc.nextLine();
            String date = sc.nextLine();
            temp.expireDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            add(temp);
        }
    }

    private void add(Node node) {
        size++;
        if (Head == null) {//if there is no list
            Head = node;
        } else {// if there is list
            Node temp = Head;
            while (temp.next != null) {//to catch the last node
                temp = temp.next;
            }
            temp.next = node;

        }
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("There are no Medicines Available");
        } else {// if there is medicines
            Node temp = Head;
            while (temp != null) {
                System.out.println("{ Medicine ID : " + temp.medicineID + " ");
                System.out.println("Medicine Name : " + temp.medicineName + " ");
                System.out.println("Type : " + temp.type + " ");
                System.out.println("Qunatity : " + temp.quantity + " ");
                System.out.println("Price : " + temp.price + " EGP  ");
                System.out.println("Place : " + temp.place + " ");
                System.out.println("Manufacturer  : " + temp.manufacture + " ");
                System.out.println("Expire Date  : " + temp.expireDate + " } ");
                temp = temp.next;
                System.out.println("");
            }

        }
    }

    public void printMedicineData() {
        System.out.println("Please Enter Medicine Name : ");
        String medName = sc.next();
        Node n1 = Head;
        while (n1 != null) {
            if (medName.equalsIgnoreCase(n1.medicineName)) {
                System.out.println("{ Medicine ID : " + n1.medicineID + " ");
                System.out.println("Medicine Name : " + n1.medicineName + " ");
                System.out.println("Type : " + n1.type + " ");
                System.out.println("Qunatity : " + n1.quantity + " ");
                System.out.println("Price : " + n1.price + " EGP  ");
                System.out.println("Place : " + n1.place + " ");
                System.out.println("Manufacturer  : " + n1.manufacture + " ");
                System.out.println("Expire Date  : " + n1.expireDate + " } ");
                return;
            }
            n1 = n1.next;

        }
    }

    public boolean update() throws ParseException {
        if (isEmpty()) {
            return false;
        } else {
            System.out.println("Please Enter Medicine ID : ");
            int medID = sc.nextInt();
            Node temp = Head;
            while (temp != null) {
                if ((temp.medicineID == medID)) {
                    System.out.println("Do you want to change Medicine ID ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine ID ");
                        temp.medicineID = sc.nextInt();
                    }
                    System.out.println("Do you want to change Medicine Name ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine Name ");

                        temp.medicineName = sc.next();
                    }
                    System.out.println("Do you want to change Medicine Type ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine Type ");

                        temp.type = sc.next();
                    }
                    System.out.println("Do you want to change Medicine Quantity ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine Quantity ");

                        temp.quantity = sc.nextInt();
                    }
                    System.out.println("Do you want to change Medicine Price ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine Price ");

                        temp.price = sc.nextDouble();
                    }
                    System.out.println("Do you want to change Medicine Place ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine Place ");

                        temp.place = sc.next();
                    }
                    System.out.println("Do you want to change Medicine Manufacture ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine Manufacture ");

                        temp.manufacture = sc.next();
                    }
                    System.out.println("Do you want to change Medicine Date ? y / n");
                    if (sc.next().charAt(0) == 'y') {
                        System.out.print("Enter New Medicine Date ");
                        String d = sc.next();
                        temp.expireDate = new SimpleDateFormat("dd/MM/yyyy").parse(d);

                    }
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public boolean sellMedicine() {
        boolean retval = false;
        System.out.println("Enter the medicine name you want sell : ");
        String medName = sc.nextLine();
        Node temp = Head;
        while (!medName.equalsIgnoreCase(temp.medicineName)) {
            temp = temp.next;
        }//exit the while loop holding the medicine we want to sell
        System.out.println("Then , Enter the Quantity you want buy : ");
        int quant = sc.nextInt();
        temp.quantity = temp.quantity - quant;
        System.out.println("You have Sold The medicine " + temp.medicineName + " with qauntity " + quant);
        System.out.println("You have to pay for " + quant + " medicine(s) with each for " + temp.price + " So , " + quant + " * " + temp.price + " = " + quant * temp.price + " EGP");
        return true;
    }

    public boolean addNewMedicine() throws ParseException {
        boolean retval = false;
        Node med = new Node();
        if (med != null) {//if node is created successfully
            if (Head == null) {//there is no list
                Head = med;
                System.out.print("Enter the Medicine ID : ");
                med.medicineID = sc.nextInt();

                System.out.print("Enter the Quantity : ");
                med.quantity = sc.nextInt();

                System.out.print("Enter the Medicine Name : ");
                med.medicineName = sc.next();

                System.out.print("Enter the Place : ");
                med.place = sc.next();

                System.out.print("Enter the Price : ");
                med.price = sc.nextDouble();

                System.out.print("Enter the Type : ");
                med.type = sc.next();

                System.out.print("Enter the Manufacturer : ");
                med.manufacture = sc.next();

                System.out.print("Enter the expire Date : ");
                String d = sc.nextLine();
                med.expireDate = new SimpleDateFormat().parse(d);

                System.out.println(" ");
                med.next = null;
                retval = true;
            } else {// there is medicines
                Node temp = Head;
                while (temp.next != null) {//to catch the last element
                    temp = temp.next;
                }
                med.next = temp.next;
                temp.next = med;
                System.out.print("Enter the Medicine ID : ");
                med.medicineID = sc.nextInt();

                System.out.print("Enter the Quantity : ");
                med.quantity = sc.nextInt();

                System.out.print("Enter the Medicine Name : ");
                med.medicineName = sc.next();

                System.out.print("Enter the Place : ");
                med.place = sc.next();

                System.out.print("Enter the Price : ");
                med.price = sc.nextDouble();

                System.out.print("Enter the Type : ");
                med.type = sc.next();

                System.out.print("Enter the Manufacturer : ");
                med.manufacture = sc.next();

                System.out.print("Enter the expire Date : ");
                String d = sc.next();
                med.expireDate = new SimpleDateFormat("dd/MM/yyyy").parse(d);

                System.out.println(" ");
                retval = true;
            }
        }

        return retval;
    }

    public void delete() {
        System.out.println("Enter the name of medicine you want to delete : ");
        String v = sc.nextLine();
        Node newNode = Head, temp = null;
        if (newNode != null && v.equalsIgnoreCase(newNode.medicineName)) {
            Head = newNode.next;
            return;
        }
        while (newNode != null && !v.equalsIgnoreCase(newNode.medicineName)) {
            temp = newNode;
            newNode = newNode.next;
        }
        if (newNode == null) {
            return;
        }
        temp.next = newNode.next;

    }

    private void saveData() throws IOException {
        Node temp = Head;
        FileWriter fWriter = new FileWriter("D:\\University\\Level 2\\Third Semester\\Data Structures\\Final Project\\MedicineList.txt");
        while (temp != null) {
            String id = String.valueOf(temp.medicineID);
            fWriter.write(id + "\n");
            String quantity = String.valueOf(temp.quantity);
            fWriter.write(quantity + "\n");
            fWriter.write(temp.medicineName + "\n");
            fWriter.write(temp.place + "\n");
            String price = String.valueOf(temp.price);
            fWriter.write(price + "\n");
            fWriter.write(temp.type + "\n");
            fWriter.write(temp.manufacture + "\n");
            String strDate = formatter.format(temp.expireDate);
            fWriter.write(strDate + "\n");
            temp = temp.next;
        }
        fWriter.close();
    }

    public void sortID(int o) {
        if (o == 1) {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.medicineID > next.medicineID) {
                            /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        } else {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.medicineID < next.medicineID) {
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        }
    }

    public void sortPrice(int o) {
        if (o == 1) {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.price > next.price) {
                            /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        } else {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.price < next.price) {
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        }
    }

    public void sortQuantity(int o) {
        if (o == 1) {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.quantity > next.quantity) {
                            /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        } else {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.quantity < next.quantity) {
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        }
    }

    public void sortDate(int o) {
        if (o == 1) {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.expireDate.compareTo(next.expireDate) > 0) {
                            /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        } else {
            if (size > 1) {
                boolean wasChanged;

                do {
                    Node current = Head;
                    Node previous = null;
                    Node next = Head.next;
                    wasChanged = false;

                    while (next != null) {
                        if (current.expireDate.compareTo(next.expireDate) < 0) {
                            wasChanged = true;

                            if (previous != null) {
                                Node sig = next.next;

                                previous.next = next;
                                next.next = current;
                                current.next = sig;
                            } else {
                                Node sig = next.next;

                                Head = next;
                                next.next = current;
                                current.next = sig;
                            }

                            previous = next;
                            next = current.next;
                        } else {
                            previous = current;
                            current = next;
                            next = next.next;
                        }
                    }
                } while (wasChanged);
            }
        }
    }

    public void expireAtDate(String month, String year) throws ParseException {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        String date = month + "/01" + "/" + year;
        c2.setTime(formatter.parse(date));
        Node temp = Head;
        while (temp != null) {
            c1.setTime(temp.expireDate);
            if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
                if (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)) {
                    System.out.println("The Medicine(s) that matches the entered Expiration Date : " + temp.medicineName);
                }
            }
            temp = temp.next;
        }
    }

    public void exit() throws IOException {
//        System.out.println("Enter the file directory you want to save in ");
//        String filepath = sc.nextLine();
        System.out.println("See You Soon .... ");
        saveData();
        System.exit(0);
    }

}
