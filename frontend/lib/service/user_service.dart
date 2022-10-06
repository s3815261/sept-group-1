import 'dart:convert';
import 'dart:developer';

import 'package:http/http.dart' as http;
import 'package:frontend/utils/constants.dart';
import 'package:frontend/models/User.dart';


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