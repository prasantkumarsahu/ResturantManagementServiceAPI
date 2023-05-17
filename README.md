# Restaurant Management Service APIs
This is a API project for insert, read, update, and delete `Users`, `Products`, `Address`,and `Orders` using **`MySQL` Database** and `CrudRepository`.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot "Spring Boot") ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white "Java") ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white "Postman") ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white "Google Chrome")

## Frameworks and Languages
![Java v17](https://img.shields.io/badge/Java-v17-green "Java 17") ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.6-brightgreen "Spring Boot v3.0.6")
---

## Browser / Tools

## ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-v112.0.5615.138-yellow "Google Chrome") ![Postman](https://img.shields.io/badge/Postman-v10.13.0-orange "Postman")

## Model

- ### User Properties
  - ```java
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    ```
  - ```java
    @NotEmpty
    private String title;
    ```
  - ```java
    private String description;
    ```
  - ```java
    @NotEmpty
    private String location;
    ```
  - ```java
    private Double salary;
    ```
  - ```java
    @NotEmpty
    private String companyName;
    ```
  - ```java
    private String employerName;
    ```
  - ```java
    @Enumerated(value = EnumType.STRING)
    private JobType jobType;
    ```
  - ```java
    private LocalDate appliedDate;
    ```
- ### JobType Enum
  ```java
  public enum JobType {
    IT,
    HR,
    SALES,
    MARKETING,
    ACCOUNTANT,
    PLANNER
  }
  ```

---

## Dataflow

- ### End Points / Controllers
  - _Using CrudRepository Methods_
    - `@PostMapping(value = "jobs")`
    - `@GetMapping(value = "jobs")`
    - `@PutMapping(value = "job")`
    - `@DeleteMapping(value = "job/{id}")`
  - _Using Custom Finder Methods_
    - `@GetMapping(value = "jobs/{salary}")`
    - `@GetMapping(value = "jobs/salary/greater/{salary}/sort/desc/appliedDate")`
    - `@GetMapping(value = "/jobs/description/contain/{str}")`
    - `@GetMapping(value = "jobs/jobType/not/{myType}")`
  - _Using Native Query Methods_
    - `@PutMapping(value = "jobs/location/{location}/id/{id}")`
    - `@DeleteMapping(value = "job/native/{id}")`
    - `@GetMapping(value = "jobs/title/{title}")`
    - `@GetMapping(value = "jobs/description/{description}")`
- ### Services
  - _Using CrudRepository Methods_
    ```java
    public String addJobsToDb(List<Job> jobs)
    ```
    ```java
    public List<Job> getJobsFromDb()
    ```
    ```java
    public String updateJobById(Job updatedJob)
    ```
    ```java
    public String deleteJobByIdFromDb(Long id)
    ```
  - _Using Custom Finder Methods_
    ```java
    public List<Job> getJobBySalaryFromDb(Double salary)
    ```
    ```java
    public List<Job> getJobsBySalaryGreaterDescAppliedDate(Double salary)
    ```
    ```java
    public List<Job> getJobsDescriptionHaving(String str)
    ```
    ```java
    public List<Job> getJobsByJobTypeNot(JobType jobType)
    ```
  - _Using Native Query Methods_
    ```java
    @Transactional
    public String updateLocationById(String location, Long id)
    ```
    ```java
    @Transactional
    public String deleteByIdNative(Long id)
    ```
    ```java
    public List<Job> getAllJobsByTitle(String title)
    ```
    ```java
    public List<Job> getAllJobsByDescription(String description)
    ```
- ### Repository

  ```java
  @Repository
  public interface IJobRepository extends CrudRepository<Job, Long> {

    // Custom Finder Methods -->>
    public List<Job> findBySalary(Double salary);
    public List<Job> findBySalaryGreaterThanOrderByAppliedDateDesc(Double salary);
    public List<Job> findByDescriptionContains(String str);
    public List<Job> findByJobTypeNot(JobType jobType);

    // Native Custom Query -->>
    @Modifying
    @Query(value = "update jobs set location = :location where id = :id", nativeQuery = true)
    public void updateLocationById(Long id, String location);
    @Modifying
    @Query(value = "delete from jobs where id = :id", nativeQuery = true)
    public void deleteJobById(Long id);
    @Query(value = "select * from jobs where title = :title", nativeQuery = true)
    public List<Job> selectJobByTitle(String title);
    @Query(value = "select * from jobs where description = :description", nativeQuery = true)
    public List<Job> selectJobByDescription(String description);
  }
  ```

- ### Database
  In this project for datasource I've used **`MySQL` Database**'s in memory type with `SpringDataJPA`.

---

## Datastructures

- `List<>`/`Inumrable<>`

---

## Summary

This API is a `Spring Boot` project that is about managing jobs. We can create, read, update, and delete jobs. In this project request is sent from the client on HTTP in JSON format or from path variable with server side validations and stored in object then response is sent back from the server by JSON format to the client.
