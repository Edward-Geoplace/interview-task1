# Welcome to Event repo

### Spring boot project to test candidates in Spring Data JPA, Spring Service and TDD approach for writing code

## Requirements

The project requires [Java 11] or higher.


* Program Description

    A service component to determine whether the input event is a replacement of previous failed event; and return 
    ```
        a. the event id to be replaced
        b. an indicate whether it is a replacement
    ```


`Tasks`
```
    a. To update EventService.getResultEvent & EventRepositoryImpl.getResultEvent methods to return correct . Free Feel to use querydsl, JPA query, SQL query or any other that you are confortable with  
    b. To Update and Run all tests cases under EventServiceTest. And all cases should be passed
```

* Table Structure

| Table        | Column          | Description & Possible values                                                                                                                                     |
|--------------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| EVENT        | EVENT_ID        | Unique Event Id                                                                                                                                                   |
|              | ACCOUNT_ID      | Account Id links to Account Tale                                                                                                                                 |
|              | EVENT_STATUS_ID | Event Status Id links to Event Status Table                                                                                                                       |
|              | TEST_SUBMISSION | Is it a Test Submission<br/><br/>Y - Is a Test Submission<br/> N - Not a Test Submission                                                                          |
| FILE_DETAILS | FILE_ID         | Unique File Id                                                                                                                                                    |
|              | EVENT_ID        | Event Id links to Event Table                                                                                                                                     |
|              | FILE_NAME       | File Name<br/><br/> In format {Account_code}_YYYYMMDD_01.csv                                                                                                      |
|              | FILE_STATUS_ID  | File Status Id links to File Status Table                                                                                                                         |
| ACCOUNT      | ACCOUNT_ID      | Unique Account Id                                                                                                                                                 |
|              | ACCOUNT_CODE    | Account Code<br/><br/> 4 digit number in text format                                                                                                              |
| EVENT_STATUS | EVENT_STATUS_ID | Unique Event Status Id <br/><br/>1 - LOADED<br/>2 - ASSURED<br/>3 - VALIDATED                                                                   |
|              | EVENT_STATUS    | Event Status description                                                                                                                                          |
| FILE_STATUS  | FILE_STATUS_ID  | Unique File Status Id<br/><br/>1 - LOAD_FAILED<br/>2 - LOAD_PASSED<br/>3 - ASSURE_FAILED<br/>4 - ASSURE_PASSED<br/>5 - VALIDATION_FAILED<br/>6 - VALIDATION_PASSED |
|              | FILE_STATUS     | File Status description                                                                                                                                           |

* Assumption

```
    a. Event that is a test submission should not be taken into consideration and should be skipped
    b. Event with its file status equal to 'LOAD_FAILED' or 'ASSURE_FAILED' or 'VALIDATION_FAILED' is treated as Failed 
    c. Previous failed event will be reprocssed when Event with same file name arrives. (Refer to point d. for details)  
    d. A replacement Event is defined as below
        - Event Id is greater than the Id of the failed Event; and
        - File name is same as the file name of the failed Event               
    e. When there are mutliple failed events, should return the earliest failed event. (Refer to Test Scenarios details)    
```

* Scenarios

  * Case 1  
    ```
    Program: EventServiceTest
    Method: getResultEvent_Case1
    ```
    * Test Data (For Account Code: 1111)

      | Event Id | File Name            | Event Status | File Status       | Test Submission |
      |----------|----------------------|--------------|-----------------|-----------------|
      | 1000     | 1111_20220930_01.csv | VALIDATED    | VALIDATION_PASSED | No              |
      | 1001     | 1111_20221001_01.csv | VALIDATED    | VALIDATION_PASSED | No              |
      | 1002     | 1111_20221002_01.csv | VALIDATED    | VALIDATION_FAILED | Yes             |
      | 1003     | 1111_20221003_01.csv | LOADED       | LOAD_PASSED       | No              |

    * Parameter
      ```
      Account Code: 1111
      Input Event Id: 1003
      ```
    * Expected Result
      ```
      Event to be replaced: N/A
      Is Replacement: No
      ```

  * Case 2
    ```
    Program: EventServiceTest
    Method: getResultEvent_Case2
    ```
    * Test Data (For Account Code: 2222)

      | Event Id | File Name            | Event Status | File Status       | Test Submission |
      |----------------------|----------------------|--------------|-------------------|-----------------|
      | 1004     | 2222_20220930_01.csv | VALIDATED    | VALIDATION_PASSED | No              |
      | 1005     | 2222_20221001_01.csv | LOADED       | LOAD_FAILED       | No              |
      | 1006     | 2222_20221002_01.csv | LOADED       | LOAD_FAILED       | No              |
      | 1007     | 2222_20221001_01.csv | LOADED       | LOAD_PASSED       | No              |

    * Parameter
      ```
      Account Code: 2222
      Input Event Id: 1007
      ```
    * Expected Result
      ```
      Event to be replaced: 1005
      Is Replacement: Yes
      ```
  * Case 3
    ```
    Program: EventServiceTest
    Method: getResultEvent_Case3
    ```
      * Test Data (For Account Code: 3333)

        | Event Id | File Name            | Event Status      | File Status         | Test Submission |
        |----------------------|-------------------|---------------------|-----------------|-----------------|
        | 1008     | 3333_20220930_01.csv | LOADED            | LOAD_FAILED         | No              |
        | 1009     | 3333_20220930_01.csv | VALIDATED         | VALIDATION_FAILED   | No              |
        | 1010     | 3333_20221001_01.csv | VALIDATED         | VALIDATION_FAILED   | No              |
        | 1011     | 3333_20221002_01.csv | LOADED            | LOAD_FAILED         | No             |
        | 1012     | 3333_20220930_01.csv | VALIDATED         | VALIDATION_PASSED   | No              |
        | 1013     | 3333_20221003_01.csv | LOADED            | LOAD_PASSED         | No              |

      * Parameter
        ```
        Account Code: 3333
        Input Event Id: 1013
        ```
      * Expected Result
        ```
        Event to be replaced: 1010
        Is Replacement: No
        ```
  * Case 4
    ```
    Program: EventServiceTest
    Method: getResultEvent_Case4
    ```
      * Test Data (For Account Code: 4444)

        | Event Id  | File Name            | Event Status | File Status          | Test Submission |
        |-----------|----------------------|--------------|----------------------|-----------------|
        | 1014      | 4444_20220930_01.csv | VALIDATED    | VALIDATION_PASSED    | No              |
        | 1015      | 4444_20221001_01.csv | ASSURED      | ASSURE_FAILED        | No              |
        | 1016      | 4444_20221001_01.csv | VALIDATED    | VALIDATION_PASSED    | No              |
        | 1017      | 4444_20221002_01.csv | LOADED       | LOAD_FAILED          | No              |
        | 1018      | 4444_20221002_01.csv | VALIDATED    | VALIDATION_FAILED    | No              |
        | 1019      | 4444_20221003_01.csv | LOADED       | LOAD_FAILED          | No              |
        | 1020      | 4444_20221003_01.csv | VALIDATED    | VALIDATION_FAILED    | No              |
        | 1021      | 4444_20221002_01.csv | LOADED       | LOAD_PASSED          | No              |

      * Parameter
        ```
        Account Code: 4444
        Input Event Id: 1021
        ```
      * Expected Result
        ```
        Event to be replaced: 1017
        Is Replacement: Yes
        ```
