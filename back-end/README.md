## To setup the project

`mvn install`

## API Routes

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
            "monday": "124124abc",
            "tuesday": "tuesday124",
            "friday": "asfas"
        }
    }
    Response: "Availabilities set"


bugs to fix:
- catch user already exists for registering users
- fix logout param and response

to do:
- add tests
- refactor
- merge to main
