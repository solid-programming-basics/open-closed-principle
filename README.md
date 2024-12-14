# Task 1: Refactoring Code to Comply with the Open Closed Principle (OCP)

## Problem Statement
The provided code is not closed for modifications related to supporting new arithmetic operations hence violates the **Open Closed Principle (OCP)** in that context. Your goal is to refactor the code so that it adheres to OCP while ensuring that its functionality remains unchanged.

## Requirements
1. Refactor the code to make it closed for modifications related to supporting new arithmetic operations, while being open for extension, allowing these operations to be added.
2. The **interface of the `Calculator` class** must remain unchanged. Specifically, the public method signatures cannot be modified.
3. The provided **test case** must pass after your refactoring.
4. Add support for the multiplication and division operations.
5. Add test cases for the multiplication and divisions operation.

## Constraints
- You may create additional classes or interfaces as needed.
- Do not change the method names or parameters in the `Calculator` class.
- Follow clean code principles while focusing on OCP.
