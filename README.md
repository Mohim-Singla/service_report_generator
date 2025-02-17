# service_report_generator
The Report Generator Application is built using Spring Boot to process input and reference data from CSV files, apply transformation rules, and generate reports in CSV format.

#### Features

- **Upload CSV Files:** Upload `input.csv` and `reference.csv` files via API endpoint (`/api/reports/generate`).
- **Data Processing:** Parse and process input and reference data.
- **Transformation Rules:** Apply configurable transformation rules to derive output fields.
- **Output Generation:** Write transformed data to `output.csv`.

#### Technologies Used

- Java
- Spring Boot
- Apache Commons CSV
- Maven (for dependency management)

#### File Structure

```
src/main/java
            └── com.example.reportgenerator
                                    ├── controller       // Contains controller classes
                                    ├── model            // Contains data model classes
                                    ├── service          // Contains service classes
                                    └── utils            // Contains utility classes, e.g., FileStorageService
```

#### Setup Instructions

1. **Clone the repository:**

```
git clone https://github.com/Mohim-Singla/service_report_generator
cd report-generator
```

### Build and Run the Project

To build the project, run the following command:

```
mvn clean install
```

To run the application locally, use:
```
mvn spring-boot:run
```

### Usage

#### Upload Input and Reference CSV Files

1. Use the API endpoint to upload `input.csv` and `reference.csv` files.
```
// Sample cURL:
            curl --location 'http://localhost:8080/api/reports/generate' \
            --form 'inputFile=@"/Users/mohim.singla/Desktop/input.csv"' \
            --form 'referenceFile=@"/Users/mohim.singla/Desktop/referance.csv"'
```
2. After uploading files, initiate report generation.

#### Generate Reports

1. The application will:
   - Save the input files in `/uploads` directory.
   - Parse and process input and reference data.
   - Apply transformation rules to derive output fields.
   - Write the transformed data to `output.csv`.
#### Sample Files:
1. `input.csv`
<img width="753" alt="Screenshot 2024-07-21 at 12 00 35 PM" src="https://github.com/user-attachments/assets/f9e457bc-a61e-417e-9a37-1563b9959c94">

2. `reference.csv`
<img width="799" alt="Screenshot 2024-07-21 at 12 00 42 PM" src="https://github.com/user-attachments/assets/a73c5f80-4a2a-47ff-b220-0d7bacdce128">

3. `output.csv`
<img width="997" alt="Screenshot 2024-07-21 at 12 00 54 PM" src="https://github.com/user-attachments/assets/009480a2-ac85-4709-83f0-befe81ff6173">

### Configuration

The application uses a default upload directory `uploads` for storing uploaded files. You can configure this directory in `application.properties`.
The default PORT for the application is `8080` which is configurable in `application.properties`
