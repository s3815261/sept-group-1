# SETUP SPRING BOOT

## To setup the project

`mvn install`

## To build the project

`mvn compile`

## Package the project

`mvn package`

## Execute the jar file / Run application

`java -jar target/back-end-0.0.1-SNAPSHOT.jar`

- Please make sure you have the appropriate settings in application.properties

## Containerize the app

`docker build -t backend:latest .`

--

# DOCKERIZE MYSQL

## Pull MYSQL image

`docker pull mysql`

## Run MYSQL image

`docker run -d -p 3308:3306 --name=mysql-docker --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=nd" mysql`

## Check if MYSQL container is up

`docker ps`


## Connect to the container and access the DB

`docker exec -it mysql-docker bash`

## Login to MYSQL server

`mysql -uroot -proot`

--

# API Routes

    POST /users/login

    Request: {
        "email": "someone@mail.com",
        "password": "password123"
    }
    Response: {
        "token": "eyjwtToken..."
    }

    ---

    POST /users/register

    Request: {
        "firstName": "mr",
        "lastName": "someone",
        "email": "someone@mail.com",
        "password": "password123",
        "role": "patient",
        "isAdmin": false,
    }
    Response: "SUCCESS" OR "USER ALREADY EXISTS"

    ---

    POST /users/logout
    
    ---

    POST /users/updatestatus

    Request: {
        "user_id": 21,
        "status": "fever"
    }
    Response: "Status updated" OR "User Not Found"


    ---

    POST /doctor/register

    Param: id = 21
    Response: "SUCCESS"

    ---

    POST /doctor/setinfo

    Request: {
        "doctor_id": 21,
        "doctor_info": "PHD in orthopaedic surgery"
    }
    Response: "Info added"

    ---

    POST /doctor/setavailability

    Request: {
        "doctor_id": 27,
        "availability": {
            "monday": "1663501568:1663601568",
            "tuesday": "1663501568:1663601568",
            "friday": "1663501568:1663601568"
        }
    }
    Response: "Availabilities set"

    ---

    POST /doctor/getavailability?id=25

    Response: {
        "monday": "1663501568:1663601568",
        "tuesday": "1663501568:1663601568",
        "wednesday": null,
        "thursday": null,
        "friday": "1663501568:1663601568"
    }

    ---

    POST /appointment/make

    Request: {
        "doctorId": 34,
        "patientId": 35,
        "startTime": "1664940931",
        "endTime": "1664943000"
    }

    Response: Appointment created

    ---

    GET /appointment/view?patientId=35

    Response: [
        {
            "doctorId": 34,
            "doctorName": "sq leo",
            "patientId": 35,
            "startTime": "1664940931",
            "endTime": "1664943000"
        },
        {
            "doctorId": 34,
            "doctorName": "sq leo",
            "patientId": 35,
            "startTime": "1664940931",
            "endTime": "1664943000"
        }
    ]

    ---
