package org.example;

import java.util.Objects;

public class Patient implements Comparable<Patient> {

  private String name;
  private String lastName;
  private Integer age;
  private Boolean isMale;

  public Patient(String name, String lastName, Integer age, Boolean isMale) {
    this.name = name;
    this.lastName = lastName;
    this.age = age;
    this.isMale = isMale;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }

  public Boolean getMale() {
    return isMale;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Patient)) return false;
    Patient patient = (Patient) o;
    return name.equals(patient.name) &&
      lastName.equals(patient.lastName) &&
      age.equals(patient.age) &&
      isMale.equals(patient.isMale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName, age, isMale);
  }

  @Override
  public String toString() {
    return "Patient{" +
      "name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      ", age=" + age +
      ", isMale=" + isMale +
      '}';
  }

  @Override
  public int compareTo(Patient o) {
    return o.age.compareTo(this.age);
  }
}
