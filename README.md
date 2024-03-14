# CA1

## Description

This project aims to implement requirements for managing employees in a company. The requirements include creating an Employee entity with attributes such as first name, last name, description, email, and years in the company. Additionally, the system should enforce validation rules to ensure that attributes meet certain criteria, such as not allowing null or empty values for certain fields and validating the email format.

## Tutorial

### Analysis, Design, and Implementation

1. **Entity Creation**:
    - We start by creating an `Employee` entity class in Java using JPA annotations to map it to a database table. The entity includes attributes such as first name, last name, description, email, and years in the company.

2. **Validation Rules**:
    - To enforce validation rules, we utilize annotations from the `javax.validation.constraints` package. For example, we use `@NotEmpty` to ensure that first name and last name are not empty, and `@Email` to validate the email format.

3. **Branch Creation and Committing Changes**:
    - We create a new branch named "fix-invalid-email" to address the requirement of only accepting valid email addresses. This branch includes changes to the `Employee` entity to add validation for the email field.

### Analysis of Alternatives

- **Comparison with Git**:
    - The alternative tool compared to Git regarding version control features might lack some of the advanced functionalities provided by Git, such as extensive branching and merging capabilities, distributed nature, and strong community support. However, depending on the specific requirements and preferences of the team, the alternative tool might offer simplicity and ease of use.

- **Usage of the Alternative Tool**:
    - To achieve the same goals as presented in this assignment, the alternative tool could be used by following similar steps for creating and managing code repositories, branches, and commits. However, specific features and commands may differ, requiring adjustments in workflows and procedures. For example, instead of using Git commands like `git checkout` and `git commit`, users might utilize alternative commands or interfaces provided by the chosen tool.
