import 'dart:convert';

import 'package:frontend/models/User.dart';
import 'package:http/http.dart' as http;

import '../utils/constants.dart';
class UserController {

  Future<UserModel> createUser(String firstName, String lastName, String email, String password, String role, bool isAdmin, bool loggedIn) async {
    final response = await http.post(
      Uri.parse(ApiConstants.baseUrl + ApiConstants.usersRegisterEndpoint),
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

    if(response.statusCode == 201) {
      return UserModel.fromJson(jsonDecode(response.body));
    }else {
      throw Exception('Failed to create user!');
    }

  }
}