package org.example;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
  @Override
  public int compare(Patient o1, Patient o2) {

    int result = 0;

    if (o2.getMale()) {
      result = -1;
    }

    if (!o2.getMale()) {
      result = 1;
    }

    if (o1.getMale() == o2.getMale()) {
      result = o1.getAge().compareTo(o2.getAge());
    }

    return result;
  }
}

