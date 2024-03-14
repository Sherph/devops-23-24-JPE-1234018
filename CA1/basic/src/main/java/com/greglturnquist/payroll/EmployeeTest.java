package com.greglturnquist.payroll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee("John", "Doe", "Description", 5);
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("Description", employee.getDescription());
        assertEquals(5, employee.getYearsInCompany());
    }

    @Test
    public void testEmptyFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("", "Doe", "Description", 5));
    }

    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Doe", "Description", 5));
    }

    @Test
    public void testEmptyLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", "", "Description", 5));
    }

    @Test
    public void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", null, "Description", 5));
    }

    @Test
    public void testEmptyDescription() {
        assertDoesNotThrow(() -> new Employee("John", "Doe", "", 5));
    }

    @Test
    public void testNullDescription() {
        assertDoesNotThrow(() -> new Employee("John", "Doe", null, 5));
    }

    @Test
    public void testInvalidYearsInCompany() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", "Doe", "Description", -5));
    }
}