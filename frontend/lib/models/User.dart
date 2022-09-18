import 'dart:convert';

import '../utils/constants.dart';
import 'package:http/http.dart' as http;

UserModel userModelFromJson(String str) =>
    UserModel.fromJson(json.decode(str));

String userModelToJson(List<UserModel> data) =>
    json.encode(List<dynamic>.from(data.map( (x) => x.toJson())));

class UserModel {
  int id;
  String firstName;
  String lastName;
  String email;
  String password;
  String role;
  bool isAdmin;
  bool loggedIn;

  UserModel(
      this.id,
      this.firstName,
      this.lastName,
      this.email,
      this.isAdmin,
      this.loggedIn,
      this.password,
      this.role
      );

   factory UserModel.fromJson(Map<String, dynamic> json) {
     return UserModel(json['id'], json['firstName'], json['lastName'], json['email'], json['isAdmin'], json['loggedIn'], json['password'], json['role']);
   }

   Map<String, dynamic> toJson() => {
      "firstName": firstName,
     "lastName": lastName,
     "email": email,
     "isAdmin": isAdmin,
     "loggedIn": loggedIn,
     "password": password,
     "role": role,
   };

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