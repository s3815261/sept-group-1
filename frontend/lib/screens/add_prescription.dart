
import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:frontend/common/theme_helper.dart';
import 'package:frontend/screens/widgets/header_widget.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:hexcolor/hexcolor.dart';
import 'package:http/http.dart' as http;
import 'package:frontend/controller/UserController.dart';

import '../models/User.dart';
import '../utils/constants.dart';
import 'profile_page.dart';

class PrescriptionPage extends  StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return _PrescriptionPageState();
  }
}


class _PrescriptionPageState extends State<PrescriptionPage> {
  final _formKey = GlobalKey<FormState>();
  bool checkedValue = false;
  bool checkboxValue = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Add Prescription",
        style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),),
        backgroundColor: Colors.purpleAccent,
      ),
      body: Container(
        margin: EdgeInsets.fromLTRB(25, 50, 25, 10),
        padding: EdgeInsets.fromLTRB(10, 0, 10, 0),
        alignment: Alignment.center,
        child: Column(
          children: [
            Form(
              key: _formKey,
              child: Column(
                children: [
                  Container(
                    decoration: ThemeHelper().inputBoxDecorationShaddow(),
                    child: TextFormField(
                      decoration: ThemeHelper().textInputDecoration('Prescription', 'Enter drug name'),
                    ),
                  ),
                  SizedBox(height: 30.0),
                  Container(
                    decoration: ThemeHelper().inputBoxDecorationShaddow(),
                    child: TextFormField(
                      decoration: ThemeHelper().textInputDecoration('Doctor Name', 'Enter prescribing doctor'),
                    ),
                  ),
                  SizedBox(height: 20.0),
                  Container(
                    decoration: ThemeHelper().buttonBoxDecoration(context),
                    child: ElevatedButton(
                      style: ThemeHelper().buttonStyle(),
                      onPressed: null,
                      child: Padding(
                        padding: const EdgeInsets.fromLTRB(40, 10, 40, 10),
                        child: Text(
                          "Add Prescription".toUpperCase(),
                          style: const TextStyle(
                            fontSize: 20,
                            fontWeight: FontWeight.bold,
                            color: Colors.white,
                          ),
                        ),
                      ),
                    ),
                  )
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}