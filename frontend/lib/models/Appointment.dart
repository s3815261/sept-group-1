import 'dart:convert';

import '../utils/constants.dart';
import 'package:http/http.dart' as http;

AppointmentModel appointmentModelFromJson(String str) =>
    AppointmentModel.fromJson(json.decode(str));

String appointmentModelToJson(List<AppointmentModel> data) =>
    json.encode(List<dynamic>.from(data.map( (x) => x.toJson())));


class AppointmentModel {
  int doctorId;
  String doctorName;
  int patientId;
  String bookingStart;
  String bookingEnd;

  AppointmentModel(
      this.doctorId,
      this.doctorName,
      this.patientId,
      this.bookingEnd,
      this.bookingStart,
      );

  factory AppointmentModel.fromJson(Map<String, dynamic> json) {
    return AppointmentModel(json['doctorId'], json['doctorName'], json['patientId'], json['startTime'], json['endTime']);
  }

  Map<String, dynamic> toJson() => {
    "doctorId": doctorId,
    "patientId": patientId,
    "startTime": bookingStart,
    "endTime": bookingEnd,
  };

  Future<AppointmentModel> makeBooking(int doctorId, int patientId, String startTime, String endTime) async {
    final response = await http.post(
      Uri.parse(ApiConstants.baseUrl + ApiConstants.makeAppointmentEndpoint),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(<String, dynamic>{
        "doctorId": doctorId,
        "patientId": patientId,
        "startTime": startTime,
        "endTime": endTime,
      }),
    );

    if(response.statusCode == 201) {
      return AppointmentModel.fromJson(jsonDecode(response.body));
    }else {
      throw Exception('Failed to create booking!');
    }

  }

  // Future<List<AppointmentModel>> getAppointments() async {
  //   final response = await http.get(
  //     Uri.parse(ApiConstants.baseUrl + ApiConstants.makeAppointmentEndpoint));
  //
  //
  //   if(response.statusCode == 200) {
  //     final obj = jsonDecode(response.body);
  //     List<AppointmentModel> appointments = <AppointmentModel>[];
  //     for (int i = 0; i < obj['appointments'].length; i++) {
  //       AppointmentModel appointment = new AppointmentModel(doctorId: obj['appointments'][i]['doctorId'],
  //       patientId: obj['appointments'][i]['patientId'], startTime: obj['appointments'][i]['startTime'],
  //           endTime: obj['appointments'][i]['endTime']);
  //
  //         appointments.add(appointment);
  //
  // }
  //   return appointments;
  //     }
  //   }else {
  //     throw Exception('Failed to create booking!');
  //   }
  // }



}