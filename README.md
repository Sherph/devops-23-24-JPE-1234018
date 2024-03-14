# CA1

## Description

This project aims to implement requirements for managing employees in a company. The requirements include creating an Employee entity with attributes such as first name, last name, description, email, and years in the company. Additionally, the system should enforce validation rules to ensure that attributes meet certain criteria, such as not allowing null or empty values for certain fields and validating the email format.

## Tutorial

### Add New Field To The Application

1. **Modify the Entity**:
- Open the `Employee` entity class in your IDE.
- Add a new field named "jobYears" to record the years of the employee in the company.
- Implement getters, setters, and database mappings for the new field.

2. **Implement Unit Tests**:
   - Create unit tests to validate the creation of Employees with the new field and ensure that the field only accepts integer values. Also, include tests to validate other attributes for null or empty values.
   - Run the unit tests to verify their correctness.

3. **Debugging**:
   - Run the server and client parts of the solution.
   - Debug any issues or errors that arise during testing.
   - Ensure that the new feature functions correctly and does not introduce any unintended issues.

4. **Commit Changes**:
   - Once the new feature is completed and tested, stage the changes:
     ```
     git add .
     ```
   - Commit the changes with a descriptive message:
     ```
     git commit -m "Add support for jobYears field and unit tests"
     ```

5. **Push Changes to Remote Repository**:
   - Push the committed changes to the remote repository:
     ```
     git push origin jobYears-field
     ```
### Create a email-field Branch

1. **Create a Branch**:
    - Create a new branch named "email-field" to develop the new feature:
      ```
      git checkout -b email-field
      ```

2. **Modify the Entity**:
    - Open the `Employee` entity class in your IDE.
    - Add a new field named "email" to record the email address of the employee.
    - Implement getters, setters, and database mappings for the new field.

3. **Implement Unit Tests**:
    - Create unit tests to validate the creation of Employees with the new email field and ensure that the field only accepts valid email addresses. Also, include tests to validate other attributes for null or empty values.
    - Run the unit tests to verify their correctness.

4. **Debugging**:
    - Run the server and client parts of the solution.
    - Debug any issues or errors that arise during testing.
    - Ensure that the new feature functions correctly and does not introduce any unintended issues.

5. **Commit Changes**:
    - Once the new feature is completed and tested, stage the changes:
      ```
      git add .
      ```
    - Commit the changes with a descriptive message:
      ```
      git commit -m "Add support for email field and unit tests"
      ```

6. **Merge with Main Branch**:
    - After completing and testing the new feature, merge the changes into the main branch:
      ```
      git checkout main
      git merge email-field
      ```

### Fixing Invalid Email Bug

1. **Create a Branch**:
    - Create a new branch named "fix-invalid-email" to address the bug related to invalid email acceptance by the server:
      ```
      git checkout -b fix-invalid-email
      ```

2. **Debugging**:
    - Run the server and client parts of the solution.
    - Debug any issues or errors that arise during testing.
    - Identify the root cause of the bug related to invalid email acceptance by the server.

3. **Fix the Bug**:
    - Modify the server code to ensure that it only accepts Employees with a valid email (i.e., containing the "@" sign).
    - Implement appropriate validation logic or update existing validation rules as needed.

4. **Test the Fix**:
    - Run the server and client parts of the solution to test the fix.
    - Ensure that the server now correctly validates email addresses and rejects invalid ones.

5. **Commit Changes**:
    - Once the bug fix is completed and tested, stage the changes:
      ```
      git add .
      ```
    - Commit the changes with a descriptive message:
      ```
      git commit -m "Fix bug related to invalid email acceptance by the server"
      ```

6. **Merge into Main Branch**:
    - After testing the bug fix, merge the changes into the main branch:
      ```
      git checkout main
      git merge fix-invalid-email
      ```
     


### Analysis of Alternatives

- **Comparison with Git**:
    - The alternative tool compared to Git regarding version control features might lack some of the advanced functionalities provided by Git, such as extensive branching and merging capabilities, distributed nature, and strong community support. However, depending on the specific requirements and preferences of the team, the alternative tool might offer simplicity and ease of use.

- **Usage of the Alternative Tool**:
    - To achieve the same goals as presented in this assignment, the alternative tool could be used by following similar steps for creating and managing code repositories, branches, and commits. However, specific features and commands may differ, requiring adjustments in workflows and procedures. For example, instead of using Git commands like `git checkout` and `git commit`, users might utilize alternative commands or interfaces provided by the chosen tool.
