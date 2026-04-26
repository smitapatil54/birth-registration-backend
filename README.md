# Birth Registration System – Backend

This repository contains the backend API for the Birth Registration System. It manages the core business logic, data processing, and secure communication required for the complete lifecycle of birth registration and digital certificate issuance.

The backend architecture is designed to support a multi-tier government workflow, ensuring seamless data transitions from citizen submission to hospital verification and municipal approval.

## Overview

The backend is built as a RESTful API service that powers the frontend application. It manages the persistence of registration records, enforces role-based verification workflows, and handles the logic for official certificate generation while ensuring data integrity across the system.

## Core Functionalities

* Registration Management: Processes and stores birth registration requests initiated by citizens.
* Workflow Automation: Orchestrates the multi-level approval process (Hospital -> BMC).
* Certificate Logic: Generates unique registration numbers and finalizes data for official certificates upon approval.
* Data Security: Maintains a unique Application ID system for tracking and secure retrieval of sensitive records.
* Consistency: Ensures data synchronization across Citizen, Hospital, and BMC modules.

## System Workflow

1. Citizen Submission: User submits birth details; the system generates a unique Application ID.
2. Data Persistence: Records are securely stored with a "Pending" status.
3. Hospital Verification: Medical authorities audit the submission against clinical records to approve or reject.
4. BMC Adjudication: Hospital-approved requests are forwarded to the Municipal Authority (BMC) for final review.
5. Issuance: BMC grants final approval, triggering the generation of a permanent registration number and digital certificate.

## API Modules

### Citizen APIs
* Submit Registration: Endpoint to ingest new birth records.
* Fetch Details: Retrieve application status and submitted data.

### Hospital APIs
* Pending Queue: List all applications awaiting institutional verification.
* Verification Action: Endpoints to approve or reject specific applications with remarks.

### BMC APIs
* Review Queue: Access records vetted by hospitals.
* Final Approval: Authorized endpoint to finalize the registration process.
* Certificate Generation: Logic to trigger the creation of the official record.

### Certificate APIs
* Record Retrieval: Fetch finalized certificate data via Registration ID.
* Digital Rendering Support: Provides the backend data required for print-ready certificate views.

## Technology Stack

* Framework: ASP.NET Core Web API
* Language: C#
* Database: SQL Server
* ORM: Entity Framework Core

## Project Structure

* Controllers: Defines the API endpoints and handles incoming HTTP requests.
* Models / Entities: Represents the database schema and data transfer objects (DTOs).
* Services: Contains the core business logic and workflow rules.
* Data: Manages the Database Context, migrations, and repository configurations.

## Setup Instructions

1. Clone the Repository:
git clone [https://github.com/smitapatil54/birth-registration-backend.git]

2. Open Project: Launch the solution file in Visual Studio or VS Code.

3. Configuration: Update the database connection string in the appsettings.json file.

4. Database Migration:
Apply migrations using the Package Manager Console: Update-Database or via CLI: dotnet ef database update.

5. Execution: Run the application to start the development server.

## API Endpoint (Live)

The backend service is hosted at:
(https://birth-registration-backend.onrender.com)
