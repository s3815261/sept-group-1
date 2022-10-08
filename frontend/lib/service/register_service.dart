import 'dart:convert';

import 'package:http/http.dart' as http;

Future<http.Response> createUser(String firstName, String lastName, String email, String password, String role, bool isAdmin, bool loggedIn) {
  return http.post(
    Uri.parse('http://localhost:8080/register'),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8',
    },
    body: jsonEncode(<String, dynamic>{
      "firstName": firstName,
      "lastName": lastName,
      "email": email,
      "isAdmin": isAdmin,
      "loggedIn": loggedIn,
      "password": password,
      "role": role,
    }),
  );
}



//   Future<UserModel?> registerUser() async {
//     // try {
//     //   var url = Uri.parse(ApiConstants.baseUrl + ApiConstants.usersRegisterEndpoint);
//     //   var response = await http.post(url,
//     //   headers: <String, String>{"Content-Type": "application/json"},
//     //   body: jsonEncode(<String, dynamic>{
//     //     "firstName": firstName,
//     //     "lastName": lastName,
//     //     "email": email,
//     //     "isAdmin": isAdmin,
//     //     "loggedIn": loggedIn,
//     //     "password": password,
//     //     "role": role,
//     //   }));
//
//     }
//   }
// }