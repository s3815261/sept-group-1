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

  int getId()
  {
    return id;
  }

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


  // Will create a user in the database
  // However we have to return a status code in the backend so the exception won't run
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

  // This is the function to login a user..
  // Having issues attempting to take the JWT token from the backend and what to do with it?
  // How can I take a jwt token and persist the user data from it?
  Future<UserModel> loginUser(String email, String password) async {
    final response = await http.post(
      Uri.parse(ApiConstants.baseUrl + ApiConstants.userLoginEndpoint),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, String>{
        "email": email,
        "password": password,
      }),
    );

    if(response.statusCode == 201) {
      return UserModel.fromJson(jsonDecode(response.body));

    }else {
      throw Exception('Failed to login user!');
    }
  }

  // Will always do it to user id=10
  // Since we can't navigate the users in the url by id
  // Will need to be refactored to make a table for symptoms!
  Future<UserModel> updateHealthStatus(String status) async {
    final response = await http.post(
      Uri.parse(ApiConstants.baseUrl + ApiConstants.updateHealthStatusEndpoint),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, dynamic>{
        "user_id": 10,
        "status": status,
      }),
    );

    if(response.statusCode == 201) {
      return UserModel.fromJson(jsonDecode(response.body));

    }else {
      throw Exception('Failed to update user health status');
    }
  }

}