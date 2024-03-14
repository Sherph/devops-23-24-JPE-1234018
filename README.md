# CA1

## Description

This project aims to implement requirements for managing employees in a company. The requirements include creating an Employee entity with attributes such as first name, last name, description, email, and years in the company. Additionally, the system should enforce validation rules to ensure that attributes meet certain criteria, such as not allowing null or empty values for certain fields and validating the email format.

## Tutorial

### Development of New Feature: Adding a New Field

1. **Create a Branch**: 
    - Begin by creating a new branch named "jobYears-field" to develop the new feature:
      ```
      git checkout -b jobYears-field
      ```

2. **Add Support for New Field**: 
    - Modify the `Employee` entity to include a new field named "jobYears" to record the years of the employee in the company. Ensure appropriate getters, setters, and database mappings are updated.

3. **Unit Tests**:
    - Implement unit tests to validate the creation of Employees with the new field and ensure that the field only accepts integer values. Also, include tests to validate other attributes for null or empty values.

4. **Debugging**:
    - Debug both server and client parts of the solution to ensure the new feature functions correctly and does not introduce any unintended issues.

5. **Commit and Push**:
    - After completing and testing the new feature, commit the changes to the branch and push them to the remote repository:
      ```
      git add .
      git commit -m "Add support for jobYears field"
      git push origin jobYears-field
      ```

### Branching and Merging for New Features and Bug Fixes

1. **Create Branch for Adding Email Field**:
    - Create a new branch named "email-field" to add support for the email field and implement related unit tests and debugging.

2. **Create Branch for Fixing Invalid Email**:
    - Create a branch named "fix-invalid-email" to address the bug related to invalid email acceptance by the server.

3. **Merge and Tag**:
    - After completing and testing each feature or bug fix, merge the changes into the master branch and create a new tag to mark the version.

4. **Debugging**:
    - Debug the server and client parts of the solution after each merge to ensure the overall stability and functionality of the application.

### Analysis, Design, and Implementation

1. **Entity Creation**:
    - We start by creating an `Employee` entity class in Java using JPA annotations to map it to a database table. The entity includes attributes such as first name, last name, description, email, and years in the company.

2. **Validation Rules**:
    - To enforce validation rules, we utilize annotations from the `javax.validation.constraints` package. For example, we use `@Email` to validate the email format.

3. **Branch Creation and Committing Changes**:
    - We create a new branch named "fix-invalid-email" to address the requirement of only accepting valid email addresses. This branch includes changes to the `Employee` entity to add validation for the email field.

### Analysis of Alternatives

- **Comparison with Git**:
    - The alternative tool compared to Git regarding version control features might lack some of the advanced functionalities provided by Git, such as extensive branching and merging capabilities, distributed nature, and strong community support. However, depending on the specific requirements and preferences of the team, the alternative tool might offer simplicity and ease of use.

- **Usage of the Alternative Tool**:
    - To achieve the same goals as presented in this assignment, the alternative tool could be used by following similar steps for creating and managing code repositories, branches, and commits. However, specific features and commands may differ, requiring adjustments in workflows and procedures. For example, instead of using Git commands like `git checkout` and `git commit`, users might utilize alternative commands or interfaces provided by the chosen tool.
