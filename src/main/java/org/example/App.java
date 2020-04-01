package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {

    Patient johny = new Patient("Johny", "Bravo", 23, true);
    Patient anna = new Patient("Anna", "Kowalska", 21, false);
    Patient pablo = new Patient("Pablo", "Escabo", 32, true);
    Patient grazyna = new Patient("Grazyna", "Grazka", 38, false);
    List<Patient> patients = new LinkedList<>();
    patients.add(johny);
    patients.add(anna);
    patients.add(pablo);
    patients.add(grazyna);

    Collections.sort(patients);

    patients.sort(new PatientComparator());

    System.out.println(patients);

  }
}
