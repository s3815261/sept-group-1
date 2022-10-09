import 'package:flutter/material.dart';
import 'package:frontend/models/Appointment.dart';

class AppointmentList extends StatefulWidget {
  const AppointmentList({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return _ViewApointmentPageState();
  }
}

class _ViewApointmentPageState extends State<AppointmentList> {
  late final List<AppointmentModel> appointments;

  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Appointments',
          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
        ),
        backgroundColor: Colors.purpleAccent,
      ),
      body: ListView.builder(
        itemCount: 3,
        itemBuilder: (BuildContext context, int i) {
          return ListTile(
            leading: const Icon(Icons.list),
            trailing: const Text(
              "Appointment",
            ),
            title: Text("Appointment $i with Doctor Smith 11/11/2022 at 2:00pm"),
          );
        },
      ),

    );
  }
}