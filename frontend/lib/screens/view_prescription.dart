import 'package:flutter/material.dart';
import 'package:frontend/models/Appointment.dart';

class PrescriptionList extends StatefulWidget {
  const PrescriptionList({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return _ViewPrescriptionPageState();
  }
}

class _ViewPrescriptionPageState extends State<PrescriptionList> {
  late final List<AppointmentModel> appointments;


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Prescriptions',
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
              "Prescription",
            ),
            title: Text("Paracetamol $i prescribed by Doctor Smith 11/11/2022"),
          );
        },
      ),

    );
  }
}