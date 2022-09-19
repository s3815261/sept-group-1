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

